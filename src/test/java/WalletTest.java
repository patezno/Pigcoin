import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WalletTest {

    private Wallet wallet = null;
    private Wallet wallet1 = null;
    private Transaction transaction = null;
    private BlockChain blockChain = null;

    @Before
    public void init() {

        wallet = new Wallet();
        wallet.generateKeyPair();

        wallet1 = new Wallet();
        wallet1.generateKeyPair();

        transaction = new Transaction("hash_1", "0", wallet.getAddress(), wallet1.getAddress(),
                10, "fukin test");

        blockChain = new BlockChain();

    }

    @Test
    public void createWalletTest() {
        assertNotNull(wallet);
    }

    @Test
    public void generateKeyPairTest() {
        assertNotNull(wallet);
        assertNotNull(wallet.getAddress());
        assertNotNull(wallet.getSKey());
    }

    @Test
    public void loadCoinsTest() {

        blockChain.getBlockChain().add(transaction);

        wallet.loadCoins(blockChain);
        wallet1.loadCoins(blockChain);

        assertEquals(10, wallet.getTotalOutput(), 0.0);
        assertEquals(10, wallet1.getTotalInput(), 0.0);
        assertEquals(-10, wallet.getBalance(), 0.0);
        assertEquals(10, wallet1.getBalance(), 0.0);

    }

}
