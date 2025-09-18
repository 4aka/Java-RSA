import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PrimeNumbers {

    public boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++)
            if (number % i == 0) return false;
        return true;
    }

    public int searchNextPrime(int from) {
        for (int i = from; i < from + 1000; i++)
            if (isPrime(i)) return i;
        return -1;
    }

    public List<Integer> getPrimesBetween(int from, int to) {
        assertTrue(from >= 2);
        assertTrue(to > from);

        List<Integer> primes = new ArrayList<>();
        for (int i = from; i < to + 1; i++)
            if (isPrime(i)) { primes.add(i); }
        return primes;
    }

    public Boolean isMutuallySimple(int prime, int euler) {
        return euler % prime != 0;
    }
}
