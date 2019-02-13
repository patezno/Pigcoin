import java.util.LinkedList;
import java.util.List;

public class BlockChain {

    private List<Transaction> blockchain = new LinkedList<Transaction>();

    public BlockChain() {}

    public void addOrigin(Transaction transaction) {
        this.getBlockChain().add(transaction);
    }
    
    public List<Transaction> getBlockChain() {
        return this.blockchain;
    }
}
