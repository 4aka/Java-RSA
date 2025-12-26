import java.util.Map;

public class Ciphering {

    private int mod;
    private int exp;
    private int num;

    public Ciphering(int num, Map<common, Integer> pk) {
        assert(num < pk.get(common.MOD));
        mod = pk.get(common.MOD);
        exp = pk.get(common.EXP);
        this.num = num;
    }

    public int cipher() {
        PrimeNumbers primes = new PrimeNumbers();
        Long result = primes.raiseToDegree(num, exp);
        result = result % mod;
        return Math.toIntExact(result);
    }

}
