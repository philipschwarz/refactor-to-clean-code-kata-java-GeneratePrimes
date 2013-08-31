package primes;
/**
 * This class Generates prime numbers up to a user specified
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 *	
 * The algorithm is quite simple. Given an array of integers
 * starting at 2. Cross out all multiples of 2. Find the next
 * uncrossed integer, and cross out all of its multiples.
 * Repeat until you have passed the square root of the maximum
 * value.
 */
public class GeneratePrimes
{
    private static boolean[] uncrossed; 

	public static int[] generatePrimes(int maxValue)
    {
        if (maxValue < 2) return new int[0];
        
        uncrossed = new boolean[maxValue + 1];
        // initialize array to true.
        for (int i = 0; i < uncrossed.length; i++)
            uncrossed[i] = true;
        // get rid of known non-primes
        uncrossed[0] = uncrossed[1] = false;
        // sieve
        for (int i = 2; i < Math.sqrt(uncrossed.length) + 1; i++)
        {
            if (uncrossed[i]) // if i is uncrossed, cross its multiples.
            {
                for (int j = 2 * i; j < uncrossed.length; j += i)
                    uncrossed[j] = false; // multiple is not prime
            }
        }
        // how many primes are there?
        int count = 0;
        for (int i = 0; i < uncrossed.length; i++)
        {
            if (uncrossed[i])
                count++; // bump count.
        }
        int[] primes = new int[count];
        // move the primes into the result
        for (int i = 0, j = 0; i < uncrossed.length; i++)
        {
            if (uncrossed[i]) // if prime
                primes[j++] = i;
        }
        return primes; // return the primes
    }
}