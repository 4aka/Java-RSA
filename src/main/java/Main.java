import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int P = 3; int Q = 7;

        PublicKeyBuilder pbKeyBuilder = new PublicKeyBuilder(P, Q);
        Map<String, Integer> pk = pbKeyBuilder.getPublicKey();

        System.out.println("Public key Mod: " + pk.get("Mod"));
        System.out.println("Public key Exp: " + pk.get("Exp"));

        PrivateKeyBuilder prKeyBuilder = new PrivateKeyBuilder(P, Q, pk.get("Exp"));
        Map<String, Integer> prk = prKeyBuilder.getPrivateKey();

        System.out.println("Private key Mod: " + prk.get("Mod"));
        System.out.println("Private key D: " + prk.get("D"));
    }
}
