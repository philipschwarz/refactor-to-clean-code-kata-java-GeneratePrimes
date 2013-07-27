package primes;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GeneratePrimesTest
{
    // http://primes.utm.edu/lists/small/1000.txt

    private static final int[] PRIME_NUMBERS_LESS_THAN_100 = new int[] 
    { 
            2,      3,      5,      7,      11,     13,     17,     19,     23,     29, 
            31,     37,     41,     43,     47,     53,     59,     61,     67,     71, 
            73,     79,     83,     89,     97
    };

    @Test
    public void test()
    {
        assertArrayEquals(PRIME_NUMBERS_LESS_THAN_100, GeneratePrimes.generatePrimes(100));
    }
}
