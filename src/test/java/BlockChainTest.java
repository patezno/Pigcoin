import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BlockChainTest {

    private BlockChain blockChain = null;

    @Before
    public void init() {
        blockChain = new BlockChain();
    }

    @Test
    public void createBlockChainTest() {
        assertNotNull(blockChain);
    }

    @Test
    public void isBlockChainCreatedTest() {
        assertNotNull(blockChain.getBlockChain());
    }


}
