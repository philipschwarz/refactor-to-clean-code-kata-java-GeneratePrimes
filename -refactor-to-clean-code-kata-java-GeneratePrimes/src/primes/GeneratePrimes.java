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
    private static int[] result;

    public static int[] generatePrimes(int maxValue)
    {
        if (maxValue < 2) 
        {
            return NO_PRIMES; 
        }
        
        uncrossIntegersUpTo(maxValue);
        crossOutMultiples();
        putUncrossedIntegersIntoResult();
        return result;
    }

    private static void uncrossIntegersUpTo(int maxValue)
    {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
    }

    private static void crossOutMultiples()
    {
        double limit = calculaterIterationLimit();
        for (int i = 2; i < limit; i++)
        {
            if (uncrossed(i))
            {
                crossOutMultiplesOf(i);
            }
        }
    }

    private static boolean uncrossed(int i)
    {
        return !crossedOut[i];
    }

    private static void crossOutMultiplesOf(int i)
    {
        for (int j = 2 * i; j < crossedOut.length; j += i)
            crossedOut[j] = true;
    }

    /**
     * <Nice, clear explanation of why this optimisation is possible>
     */
    private static double calculaterIterationLimit()
    {
        return Math.sqrt(crossedOut.length) + 1;
    }

    private static void putUncrossedIntegersIntoResult()
    {
        result = new int[countPrimes()];
        for (int i = 2, j = 0; i < crossedOut.length; i++)
        {
            if (uncrossed(i))
                result[j++] = i;
        }
    }

    private static int countPrimes()
    {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++)
        {
            if (uncrossed(i))
                count++;
        }
        return count;
    }
}