package primes;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * This class Generates prime numbers up to a user specified
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 * <p>
 * Eratosthenes of Cyrene, b. c. 276 BC, Cyrene, Libya --
 * d. c. 194, Alexandria. The first man to calculate the
 * circumference of the Earth. Also known for working on
 * calendars with leap years and ran the library at Alexandria.
 * <p>
 * The algorithm is quite simple. Given an array of integers
 * starting at 2. Cross out all multiples of 2. Find the next
 * uncrossed integer, and cross out all of its multiples.
 * Repeat untilyou have passed the square root of the maximum
 * value.
 */
public class GeneratePrimes
{
    public static int[] generatePrimes(int maxValue)
    {
        return integersFrom2UpTo(maxValue)
                .filter(hasNoDivisorsOtherThanOneAndItself)
                .toArray();
    }

    static final IntPredicate hasNoDivisorsOtherThanOneAndItself = n ->
    {
        IntPredicate dividesN = m -> n % m == 0;

        return integersFrom2UpTo(n - 1)
                .filter(dividesN)
                .count() == 0;
    };

    private static IntStream integersFrom2UpTo(int n)
    {
        return IntStream.rangeClosed(2, n);
    }

    public static void main(String[] args)
    {
        Arrays.stream(generatePrimes(50)).forEach( System.out::println );
    }
}

