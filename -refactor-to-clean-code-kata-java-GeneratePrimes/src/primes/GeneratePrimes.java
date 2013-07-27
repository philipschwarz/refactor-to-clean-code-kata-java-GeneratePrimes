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
    private static boolean[] crossedOut;

    public static int[] generatePrimes(int maxValue)
    {
        if (maxValue < 2) 
        {
            return NO_PRIMES; 
        }
        
        uncrossIntegersUpTo(maxValue);
        // sieve
        for (int i = 2; i < Math.sqrt(crossedOut.length) + 1; i++)
        {
            if (uncrossed(i)) // if i is uncrossed, cross its multiples.
            {
                for (int j = 2 * i; j < crossedOut.length; j += i)
                    crossedOut[j] = true; // multiple is not prime
            }
        }
        // how many primes are there?
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++)
        {
            if (uncrossed(i))
                count++; // bump count.
        }
        int[] primes = new int[count];
        // move the primes into the result
        for (int i = 2, j = 0; i < crossedOut.length; i++)
        {
            if (uncrossed(i)) // if prime
                primes[j++] = i;
        }
        return primes; // return the primes
    }

    private static void uncrossIntegersUpTo(int maxValue)
    {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
    }

    private static boolean uncrossed(int i)
    {
        return !crossedOut[i];
    }
}