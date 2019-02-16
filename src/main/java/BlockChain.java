import java.security.PublicKey;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BlockChain {

    // Atrinbutos

    private List<Transaction> blockchain = new LinkedList<Transaction>();

    // Constructor

    public BlockChain() {}

    // Getter

    public List<Transaction> getBlockChain() {
        return this.blockchain;
    }

    // Metodos

    public void addOrigin(Transaction transaction) {
        this.getBlockChain().add(transaction);
    }

    public void summarize() {

        for (Transaction transaction : this.getBlockChain()) {
            System.out.println(transaction);
        }
    }

    public void summarize(int position) {
        System.out.println(getBlockChain().get(position).toString());
    }

    /*
    public void processTransaction(PublicKey pKey_sender, PublicKey pKey_recipient, Map<String, Double> consumedCoins,
                                   String message, byte[] signedTransaction) {
        isSignatureValid(pKey_sender, message, signedTransaction);
        isConsumedCoinValid(consumedCoins);
        createTransactions(pKey_sender, pKey_recipient, consumedCoins, message, signedTransaction);
    }

    public boolean isSignatureValid(PublicKey pKey_sender, String message, byte[] signedTransaction) {
    }

    public boolean isConsumedCoinValid(Map<String, Double> consumedCoins) {
    }

    public void createTransactions(PublicKey pKey_sender, PublicKey pKey_recipient, Map<String, Double> consumedCoins,
                                   String message, byte[] signedTransaction) {
    }
    */
}
