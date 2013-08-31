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
    private static boolean[] crossedOut;
	private static int[] result; 

	public static int[] generatePrimes(int maxValue)
    {
        if (maxValue < 2) return new int[0];
        
        uncrossIntegersUpTo(maxValue);
        crossOutMultiples();
        transferPrimesToResult();
        
        return result;
    }

	private static void uncrossIntegersUpTo(int maxValue) {
		crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
	}	
	
	private static void crossOutMultiples() {
		double iterationLimit = computeIterationLimit();
		for (int i = 2; i < iterationLimit; i++)
			if (uncrossed(i))
				crossOutMultiplesOf(i);
	}

	private static boolean uncrossed(int i) {
		return !crossedOut[i];
	}	
	
	/**
	 * TO DO: Explain clearly why it is sufficient to stop when this limit is reached
	 */
	private static double computeIterationLimit() {
		return Math.sqrt(crossedOut.length) + 1;
	}	
	
	private static void crossOutMultiplesOf(int i) {
		for (int j = 2 * i; j < crossedOut.length; j += i)
			crossedOut[j] = true; 
	}

	private static void transferPrimesToResult() {
        result = new int[countPrimes()];
        for (int i = 2, j = 0; i < crossedOut.length; i++)
            if (uncrossed(i))
                result[j++] = i;
	}

	private static int countPrimes() {
		int count = 0;
        for (int i = 2; i < crossedOut.length; i++)
            if (uncrossed(i))
                count++;
		return count;
	}
}