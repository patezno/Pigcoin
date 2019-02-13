import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {

    // Atributos

    private PublicKey pKey = null;
    private PrivateKey sKey = null;
    private int total_input = 0;
    private int total_output = 0;
    private int balance = 0;

    // Constructor

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

    public void generateKeyPair() {
        setAddress(GenSig.generateKeyPair().getPublic());
    }
}
