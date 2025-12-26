import java.util.HashMap;
import java.util.Map;

public class PrivateKeyBuilder {

    PrimeNumbers primeNumbers;
    private final int P;
    private final int Q;
    private final int EXP;

    PrivateKeyBuilder(int p, int q, int exp) {
        primeNumbers = new PrimeNumbers();
        this.P = p;
        this.Q = q;
        this.EXP = exp;
    }

    private int mod() { return P * Q; }
    private int euler() { return (P - 1) * (Q - 1); }

    public Map<common, Integer> getPrivateKey() {
        Map<common, Integer> privateKey = new HashMap<>();
        privateKey.put(common.EXP, mod());
        privateKey.put(common.D, getD());
        return privateKey;
    }

    private Integer getD() {
        int i = 2;
        while ((i * EXP) % euler() != 1) {
            i++;
            if ((i * EXP) % euler() == 1) return i;
        }
        return i;
    }
}
