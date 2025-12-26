import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Deciphering {

    private int mod;
    private int d;

    public Deciphering(Map<common, Integer> privateKey) {
        mod = privateKey.get(common.EXP);
        d = privateKey.get(common.D);
    }

    public List<BigInteger> decipher(List<Integer> cipheredWord) {
        List<BigInteger> result = new ArrayList<>();

        for (int l: cipheredWord) {
            BigInteger base = BigInteger.valueOf(l);
            BigInteger exponent = BigInteger.valueOf(d);
            BigInteger modus = BigInteger.valueOf(mod);
            result.add(base.modPow(exponent, modus));
        }
        return result;
    }

}
