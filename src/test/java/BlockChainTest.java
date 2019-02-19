import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BlockChainTest {

    private BlockChain blockChain = null;
    private Transaction transaction = null;

    @Before
    public void init() {
        blockChain = new BlockChain();
        transaction = new Transaction();
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
