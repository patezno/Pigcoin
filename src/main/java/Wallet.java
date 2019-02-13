import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {

    // Atributos

    private PublicKey pKey = null;
    private PrivateKey sKey = null;
    private String total_input = "";
    private String total_output = "";
    private String balance = "";

    // Constructor

    public Wallet() {
    }

    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }


    public void setAddress(PublicKey aPublic) {
        this.pKey = aPublic;
    }

    // Metodos

    public PublicKey getAddress() {
        return this.pKey;
    }

    public String getTotalInput() {
        return this.total_input;
    }

    public String getTotalOutput() {
        return this.total_output;
    }

    private String getBalance() {
        return this.balance;
    }

    public PrivateKey getSKey() {
        return sKey;
    }

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
}

