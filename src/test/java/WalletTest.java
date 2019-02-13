import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class WalletTest {

    private Wallet wallet = null;

    @Before
    public void init() {
        wallet = new Wallet();
        wallet.generateKeyPair();
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

}
