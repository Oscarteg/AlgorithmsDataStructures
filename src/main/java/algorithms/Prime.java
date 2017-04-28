package algorithms;

import java.util.stream.IntStream;

/**
 * Created by Oscar on 25/04/2017.
 */
public class Prime {

	public long countPrimes(int upTo) {
		return IntStream.range(1, upTo).filter(this::isPrime).count();
	}

	public boolean isPrime(int number) {
		return IntStream.range(2, number).allMatch(x -> (number % x) != 0);
	}

}
