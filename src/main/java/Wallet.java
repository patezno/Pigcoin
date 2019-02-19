import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Wallet {

    // Atributos

    private PublicKey pKey = null;
    private PrivateKey sKey = null;
    private double total_input = 0d;
    private double total_output = 0d;
    private double balance = 0d;
    private List<Transaction> inputTransactions = null;
    private List<Transaction> outputTransactions = null;

    // Constructor

    public Wallet() {}

    // Setters

    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }

    public void setAddress(PublicKey aPublic) {
        this.pKey = aPublic;
    }

    public void setInputTransactions(List<Transaction> inputTransactions) {
        this.inputTransactions = inputTransactions;
    }

    public void setOutputTransactions(List<Transaction> outputTransactions) {
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

    public List<Transaction> getInputTransactions() {
        return this.inputTransactions;
    }

    public List<Transaction> getOutputTransactions() {
        return this.outputTransactions;
    }

    // Metodos

    public void generateKeyPair() {

        KeyPair pair = GenSig.generateKeyPair();

        setAddress(pair.getPublic());
        setSK(pair.getPrivate());

    }

    public void update_balance() {
        setBalance(getTotalInput() - getTotalOutput());
    }

    public void loadCoins(BlockChain bChain) {

        double[] pigcoins = {0d, 0d};

        pigcoins = bChain.loadWallet(getAddress());

        setTotal_input(pigcoins[0]);
        setTotal_output(pigcoins[1]);

        update_balance();

    }

    public void loadInputTransactions(BlockChain bChain) {
        setInputTransactions(bChain.loadInputTransactions(getAddress()));
    }

    public void loadOutputTransactions(BlockChain bChain) {
        setOutputTransactions(bChain.loadOutputTransactions(getAddress()));
    }

    public byte[] signTransaction(String message) {
        return GenSig.sign(getSKey(), message);
    }

    @Override
    public String toString() {

        return "\n" + "Wallet = " + getAddress().hashCode() + "\n" +
                "Total input = " + getTotalInput() + "\n" +
                "Total output = " + getTotalOutput() + "\n" +
                "Balance = " + getBalance() + "\n";
    }

    /*
    public void sendCoins(PublicKey address, double coins, String message, BlockChain bChain) {

        collectCoins(coins);
        signTransaction(message);
        bChain.processTransaction(pKey, address, coins, message, signedTransaction);

    }

    public void collectCoins(double coins) {
    }
    */

}

