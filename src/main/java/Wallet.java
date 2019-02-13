import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {

    // Atributos

    private PublicKey address = null;
    private PrivateKey sKey = null;
    private int total_input = 0;
    private int total_output = 0;
    private int balance = 0;

    // Constructor

    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }


    public void setAddress(PublicKey aPublic) {
        this.address = aPublic;
    }

    public PublicKey getAddress() {
        return this.address;
    }
}
