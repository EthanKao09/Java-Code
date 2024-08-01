package Exam1.Problem1;


import java.util.*;

import Exam1.Problem1.Card.Rank;
import Exam1.Problem1.Card.Suit;

import java.io.*;

public class PokerGame {
	private static final int OUTPUT_SIZE = 1000;

	public static void main(String[] args) throws FileNotFoundException {
		final String POKER_VALUE_OUTPUT_FILE = "./src/Exam1/Problem1/PokerValueOutput.txt";
		final String POKER_VALUE_OUTPUT_SAMPLE_FILE = "./src/Exam1/Problem1/PokerValueOutputSample.txt";
		final String POKER_ODDS_FILE = "./src/Exam1/Problem1/PokerOddsOutput.txt";

		// Output PokerValue()
		generatePokerValueOutput(POKER_VALUE_OUTPUT_FILE);
		checkOutput(POKER_VALUE_OUTPUT_FILE);
		
		// Testing overloaded constructor and .toArray()
		checkOutput(POKER_VALUE_OUTPUT_SAMPLE_FILE);
		
		// Output PokerOdds()
		generatePokerOdds(POKER_ODDS_FILE);
	}

	private static void generatePokerValueOutput(String fileName) throws FileNotFoundException {
		System.setOut(new PrintStream(new File(fileName)));

		for (int i = 0; i < OUTPUT_SIZE; i++) {
			System.out.printf("%2d\t%s", i, new PokerValue());	// Hint: implement .toString() method.
		}

		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	}

	// Read cards from a file into PokerValue(sampleHand) overloaded constructor, i.e., assign five cards to PokerValue
	// Then check if toArray() method returns the best hand rank as a String correctly
	private static boolean checkOutput(String fileName) {
		Scanner token = null;

		try {
			token = new Scanner(new FileReader(fileName));
		} catch (Exception e) {
			System.out.println(fileName + " file not found.");
			System.exit(0); 
		}

		while (token.hasNext()) {
			Card[] sampleHand = new Card[5];
			int lineNumber = Integer.parseInt(token.next());
			String sampleBestHand = token.next().replace(':', ' ').trim();

			// Reading Card inputs
			for (int i = 0; i < 5; i++) {
				Suit s = Suit.valueOf(token.next());
				Rank r = Rank.valueOf(token.next());

				sampleHand[i] = new Card(r, s, null);
//				sampleHand[i] = new Card(r, s, new javax.swing.ImageIcon());
			}

			// Passing Card to overloaded constructor
			// The toArray() method returns an array of the best hand rank and Card objects.  
			// For example, {"Two_Pair", Card 1, Card 2, Card 3, Card 4, Card 5}.
			Object[] actualHand = new PokerValue(sampleHand).toArray();	// Hint: implement .toArray() method.

			// Verifying generated best rank
			if (!sampleBestHand.equals(actualHand[0])) {
				System.out.printf("Mismatch at line %d.\n", lineNumber);
				return false;
			}
		}

		return true;
	}

	private static void generatePokerOdds(String fileName) throws FileNotFoundException {
		System.out.println("Simulating ... Wait ...");

		System.setOut(new PrintStream(new File(fileName)));
		long timerStart = System.currentTimeMillis();
		
		System.out.print(new PokerOdds(2598960)); // It is necessary to simulate about 2.6 million times to show Royal Flush
		//System.out.print(new PokerOdds(2598));
		
		long timerStop = System.currentTimeMillis();
		System.out.println("This simulation took " + (timerStop - timerStart) / 1000 + " seconds.");
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

		System.out.println("This simulation took " + (timerStop - timerStart) / 1000 + " seconds.");
	}
}
