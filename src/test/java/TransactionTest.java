import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TransactionTest {

    private Wallet wallet1 = null;
    private Wallet wallet2 = null;
    private Transaction transaction = null;

    @Before
    public void init() {

        wallet1 = new Wallet();
        wallet1.generateKeyPair();

        wallet2 = new Wallet();
        wallet2.generateKeyPair();

        transaction = new Transaction("hash_1", "2", wallet1.getAddress(), wallet2.getAddress(),
                30, "a fucking pig");

    }

    @Test
    public void createTransactionTest() {
        assertNotNull(transaction);
    }

    @Test
    public void gettersTransactionTest() {
        assertEquals("hash_1", transaction.getHash());
        assertEquals("2", transaction.getPrevHash());
        assertNotNull(transaction.getPKeySender());
        assertNotNull(transaction.getPKeyReceiver());
        assertEquals(30, transaction.getPigcoins(), 0.0);
        assertEquals("a fucking pig", transaction.getMessage());
    }
}
