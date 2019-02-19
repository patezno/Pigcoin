import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BlockChainTest {

    private BlockChain blockChain = null;
    private Transaction transaction = null;
    private Wallet wallet1 = null;
    private Wallet wallet2 = null;

    @Before
    public void init() {

        blockChain = new BlockChain();

        wallet1 = new Wallet();
        wallet1.generateKeyPair();

        wallet2 = new Wallet();
        wallet2.generateKeyPair();

        transaction = new Transaction("hash_1", "2", wallet1.getAddress(), wallet2.getAddress(),
                30, "a fucking pig");
    }

    @Test
    public void createBlockChainTest() {
        assertNotNull(blockChain);
    }

    @Test
    public void isBlockChainCreatedTest() {
        assertNotNull(blockChain.getBlockChain());
    }

    @Test
    public void addOriginTest() {

        blockChain.addOrigin(transaction);

        for (Transaction trx : blockChain.getBlockChain()) {
            assertEquals(transaction, trx);
        }
    }
}
