import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {

    // Atributos

    private PublicKey pKey = null;
    private PrivateKey sKey = null;
    private double total_input = 0d;
    private double total_output = 0d;
    private double balance = 0d;
    private Transaction inputTransactions = null;
    private Transaction outputTransactions = null;

    // Constructor

    public Wallet() {
    }

    // Setters

    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }


    public void setAddress(PublicKey aPublic) {
        this.pKey = aPublic;
    }

    public void setInputTransactions(Transaction inputTransactions) {
        this.inputTransactions = inputTransactions;
    }

    public void setOutputTransactions(Transaction outputTransactions) {
        this.outputTransactions = outputTransactions;
    }

    public void setTotal_input(double total_input) {
        this.total_input += total_input;
    }

    public void setTotal_output(double total_output) {
        this.total_output += total_output;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getters

    public PublicKey getAddress() {
        return this.pKey;
    }

    public double getTotalInput() {
        return this.total_input;
    }

    public double getTotalOutput() {
        return this.total_output;
    }

    public double getBalance() {
        return this.balance;
    }

    public PrivateKey getSKey() {
        return sKey;
    }

    public Transaction getInputTransactions() {
        return this.inputTransactions;
    }

    public Transaction getOutputTransactions() {
        return this.outputTransactions;
    }

    // Metodos

    public void generateKeyPair() {
        setAddress(GenSig.generateKeyPair().getPublic());
        setSK(GenSig.generateKeyPair().getPrivate());
    }

    @Override
    public String toString() {
        return "\n" + "Wallet = " + getAddress().hashCode() + "\n" +
                "Total input = " + getTotalInput() + "\n" +
                "Total output = " + getTotalOutput() + "\n" +
                "Balance = " + getBalance() + "\n";
    }

    public void update_balance() {
        setBalance(getTotalInput() - getTotalOutput());
    }

    public void loadCoins(BlockChain bChain) {

        for (Transaction transaction : bChain.getBlockChain()) {

            if (transaction.getPKeyReceiver() == this.getAddress()) {
                setTotal_input(transaction.getPigcoins());
            } else if (transaction.getPKeySender() == this.getAddress()) {
                setTotal_output(transaction.getPigcoins());
            }
        }

        update_balance();

    }

    public void loadInputTransactions(BlockChain bChain) {

        for (Transaction transaction : bChain.getBlockChain()) {

            if (transaction.getPKeyReceiver() == this.getAddress()) {
                setInputTransactions(transaction);
            }
        }
    }

    public void loadOutputTransactions(BlockChain bChain) {

        for (Transaction transaction : bChain.getBlockChain()) {

            if (transaction.getPKeySender() == this.getAddress()) {
                setOutputTransactions(transaction);
            }
        }
    }

    /*
    public void signTransaction(String message) {
        Transaction.setSignature(sKey);
    }

    public void sendCoins(PublicKey address, double coins, String message, BlockChain bChain) {

        collectCoins(coins);
        signTransaction(message);
        bChain.processTransaction(pKey, address, coins, message, signedTransaction);

    }

    public void collectCoins(double coins) {
    }
    */

}

