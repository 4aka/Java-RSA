import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    // https://www.youtube.com/watch?v=xqPgE-hPIfE

    public static void main(String[] args) {
        int P = 13; int Q = 29; List<Integer> ciphered = new ArrayList<>();

        PublicKeyBuilder pbKeyBuilder = new PublicKeyBuilder(P, Q);
        Map<common, Integer> publicKey = pbKeyBuilder.getPublicKey();

        PrivateKeyBuilder prKeyBuilder = new PrivateKeyBuilder(P, Q, publicKey.get(common.EXP));
        Map<common, Integer> privateKey = prKeyBuilder.getPrivateKey();

        print("Public key : " + publicKey);
        print("Private key : " + privateKey);

        //            a   r  c  h  i   n  c   o   r   p
        int[] word = {1, 18, 3, 8, 9, 14, 3, 15, 18, 16};
        print("Data: 1, 18, 3, 8, 9, 14, 3, 15, 18, 16");

        for (int l: word) ciphered.add(new Ciphering(l, publicKey).cipher());
        print("Ciphered word: " + ciphered);

        List<BigInteger> deciphered = new Deciphering(privateKey).decipher(ciphered);
        print("Deciphered word: " + deciphered);
    }

    public static void print(Object data) {
        System.out.println(data);
    }
}
