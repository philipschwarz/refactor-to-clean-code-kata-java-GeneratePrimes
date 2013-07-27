package primes;
/**
 * This class Generates prime numbers up to a user specified
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 * <p>
 * The algorithm is quite simple. Given an array of integers
 * starting at 2. Cross out all multiples of 2. Find the next
 * uncrossed integer, and cross out all of its multiples.
 * Repeat untilyou have passed the square root of the maximum
 * value.
 */
public class GeneratePrimes
{
    private static final int[] NO_PRIMES = new int[0];

    public static int[] generatePrimes(int maxValue)
    {
        if (maxValue < 2) 
        {
            return NO_PRIMES; 
        }
        
        // declarations
        int arraySize = maxValue + 1; // size of array
        boolean[] f = new boolean[arraySize];
        int i;
        // initialize array to true.
        for (i = 0; i < arraySize; i++)
            f[i] = true;
        // get rid of known non-primes
        f[0] = f[1] = false;
        // sieve
        int j;
        for (i = 2; i < Math.sqrt(arraySize) + 1; i++)
        {
            if (f[i]) // if i is uncrossed, cross its multiples.
            {
                for (j = 2 * i; j < arraySize; j += i)
                    f[j] = false; // multiple is not prime
            }
        }
        // how many primes are there?
        int count = 0;
        for (i = 0; i < arraySize; i++)
        {
            if (f[i])
                count++; // bump count.
        }
        int[] primes = new int[count];
        // move the primes into the result
        for (i = 0, j = 0; i < arraySize; i++)
        {
            if (f[i]) // if prime
                primes[j++] = i;
        }
        return primes; // return the primes
    }
}