package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class that simulates a random number generator
 * 
 * @author Tahmid Khan Arnab
 *
 */
public class RandomGuesser {
	private List<Integer> possibleGuesses;
	private Random random;

	/**
	 * Main constructor used
	 * 
	 * @param minValue Lowest value in the list
	 * @param maxValue Highest value in the list
	 */
	public RandomGuesser(int minValue, int maxValue) {
		possibleGuesses = new ArrayList<>();
		for (int i = minValue; i <= maxValue; i++) {
			possibleGuesses.add(i);
		}
		random = new Random();
	}

	/**
	 * Returns a random number from the ArrayList and removes it
	 * 
	 * @return A guessed number from the ArrayList
	 */
	public int makeGuess() {
		if (possibleGuesses.isEmpty()) {
			throw new IllegalStateException("No more possible guesses.");
		}

		int index = random.nextInt(possibleGuesses.size());
		int guess = possibleGuesses.get(index);
		possibleGuesses.remove(index);

		return guess;
	}
}
