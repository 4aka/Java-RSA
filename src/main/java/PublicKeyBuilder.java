import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublicKeyBuilder {

    PrimeNumbers primeNumbers;
    private final int P;
    private final int Q;

    PublicKeyBuilder(int p, int q) {
        primeNumbers = new PrimeNumbers();
        this.P = p;
        this.Q = q;
    }

    public Map<String, Integer> getPublicKey() {
        Map<String, Integer> publicKey = new HashMap<>();
        publicKey.put("Mod", mod());
        publicKey.put("Exp", getOpenExp());
        return publicKey;
    }

    private int mod() { return P * Q; }
    private int euler() { return (P - 1) * (Q - 1); }

    private int getOpenExp() {
        List<Integer> primes = primeNumbers.getPrimesBetween(2, euler());
        for (int exp: primes)
            if (IsOpenExpMeetTheRequirements(exp)) return exp;
        return -1;
    }

    private Boolean IsOpenExpMeetTheRequirements(int exp) {
        int euler = euler();
        boolean rule_1_2 = false, rule_3 = false;
        if (primeNumbers.isPrime(exp) && exp < euler) rule_1_2 = true;
        if (primeNumbers.isMutuallySimple(exp, euler)) rule_3 = true;
        return rule_1_2 && rule_3;
    }
}
