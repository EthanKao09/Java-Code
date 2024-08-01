//---------------------------------------------------------------------------
// VocabularyDensityDemo.java      by Tseng
//
//---------------------------------------------------------------------------

/*  
 * 1. Create a package named "Homework4"
 * 
 * 2. Copy	CollectionInterface.java
 * 			SortedArrayCollection.java
 * 			MySortedArrayCollectionInterface.java
 * 			VocabularyDensityDemo.java (this file)
 * 			Shakespeare18thSonnet.txt
 * 			VerifyOutput.txt
 *    under src/Homework4 directory.
 * 
 * 3. Create MySortedArrayCollection.java
 *    This file is inherited from SortedArrayCollection.java
 *    This file implements MySortedArrayCollectionInterface.java
 * 	
 * 4. Complete and submit MySortedArrayCollection.java  
 * 
 */

package Homework3;

import java.io.*;
import java.util.*;

public class VocabularyDensityDemo {
	protected static final int CAPACITY = 100; // original capacity of collection
	protected static CollectionInterface<String> wordsC1 = new MySortedArrayCollection<String>(CAPACITY);
	protected static CollectionInterface<String> wordsC2 = new MySortedArrayCollection<String>(CAPACITY);
	protected static CollectionInterface<String> wordsC3 = new MySortedArrayCollection<String>(CAPACITY);

	private static String inputFileName = "./src/Homework3/Shakespeare18thSonnet.txt";
	private static String word; // current word
	private static int numWords; // total number of words
	private static double density; // vocabulary density

	public static void main(String[] args) throws FileNotFoundException {
		String actualOutputFileName = "./src/Homework3/ActualOutput.txt";
		String sampleOutputFileName = "./src/Homework3/SampleOutput.txt";
		String inputFileName = "./src/Homework3/Shakespeare18thSonnet.txt";

		File actualOutputFile = new File(actualOutputFileName);
		File sampleOutputFile = new File(sampleOutputFileName);
		File inputFile = new File(inputFileName);

		checkFiles(actualOutputFile, sampleOutputFile, inputFile);

		// Check project settings
		checkProjectSettings();

		// Output to display
		readFile();
		displayOutput();

		// Output to file
		System.setOut(new PrintStream(actualOutputFile));
		readFile();
		displayOutput();
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

		// Compare with VerifyOutput.txt
		if (!compareOutput(sampleOutputFileName, actualOutputFileName))
			System.out.println("Check your output by comparing SampleOutput.txt.");
		else
			System.out.printf("50/50.\n");
	}

	private static int checkProjectSettings() {
		// Check if Package was correct
		String packageName = wordsC1.getClass().getPackageName();
		if (!packageName.equalsIgnoreCase("Homework3")) {
			System.out.println("Set package to Homework3");
			System.exit(0);
		}

		// Check if Inheritance was included
		String inheritanceName = "";
		inheritanceName = wordsC1.getClass().getSuperclass().getName();
		if (!inheritanceName.substring(inheritanceName.lastIndexOf('.') + 1)
				.equalsIgnoreCase("SortedArrayCollection")) {
			System.out.println("Set inheritance to SortedArrayCollection");
			System.exit(0);
		}

		// Check if Interface was included
		String interfaceName = "";
		try {
			interfaceName = wordsC1.getClass().getInterfaces()[0].getName();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Interface not found");
			System.exit(0);
		}

		if (!interfaceName.substring(interfaceName.lastIndexOf('.') + 1)
				.equalsIgnoreCase("MySortedArrayCollectionInterface")) {
			System.out.println("Set to implement MySortedArrayCollectionInterface interface");
			System.exit(0);
		}

		return 1;
	}

	private static void readFile() {
		((MySortedArrayCollection<String>) wordsC1).clear();
		((MySortedArrayCollection<String>) wordsC2).clear();
		((MySortedArrayCollection<String>) wordsC3).clear();

		Scanner wordsInput = null;
		numWords = 0;

		try {
			wordsInput = new Scanner(new FileReader(inputFileName));
		} catch (Exception e) {
			System.out.println("File not found.");
			System.exit(0);
		}

		wordsInput.useDelimiter("[^a-zA-Z']+"); // delimiters are nonletters,'

		while (wordsInput.hasNext()) { // while more words to process
			word = wordsInput.next().toLowerCase();

			if (!wordsC1.contains(word))
				wordsC1.add(word);

			if (!wordsC2.contains(word))
				wordsC2.add(word);

			numWords++;
		}

		density = (double) numWords / wordsC1.size();
	}

	private static void displayOutput() {
		System.out.println("Analyzed file " + inputFileName);
		System.out.println("\n\tTotal words:  " + numWords);
		System.out.println("\tUnique words: " + wordsC1.size());
		System.out.printf("\n\tVocabulary density: %.2f\n", density);

		// Test toString() method
		System.out.println("\n\tTest toString() method:");
		System.out.print(wordsC1);

		// Test greather() method
		System.out.println("\n\tTest greater() method:");
		System.out.printf("%d elements greater than \"art\":\n",
				((MySortedArrayCollection<String>) wordsC1).greater("art"));
		System.out.printf("%d elements greater than \"too\":\n",
				((MySortedArrayCollection<String>) wordsC1).greater("too"));

		// Test smallest() method
		System.out.println("\n\tTest smallest() method");
		System.out.println("The smallest element is " + ((MySortedArrayCollection<String>) wordsC1).smallest());
		System.out.println("The smallest element is " + ((MySortedArrayCollection<String>) wordsC3).smallest()); // null
		wordsC3.add("this");
		wordsC3.add("thou");
		wordsC3.add("llama");
		System.out.println("The smallest element is " + ((MySortedArrayCollection<String>) wordsC3).smallest());

		// Test combine() method
		System.out.println("\n\t Test combine() method");
		System.out.print(
				((MySortedArrayCollection<String>) wordsC1).combine((MySortedArrayCollection<String>) wordsC3));

		// Test toArray() method
		System.out.println("\n\t Test toArray() method");
		Object[] a = ((MySortedArrayCollection<String>) wordsC1).toArray();
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);

		// Test equals
		System.out.println("\n\t Test equals() method");
		System.out.println("equals() returns " + wordsC1.equals(wordsC2));
		System.out.println("\n\t Test !equals() method");
		System.out.println("equals() returns " + !wordsC1.equals(wordsC2));

		// Test addAll() method
		System.out.println("\n\t Test addAll() method");
		System.out.println("addAll() returns "
				+ ((MySortedArrayCollection<String>) wordsC2).addAll((MySortedArrayCollection<String>) wordsC3));
		System.out.print(wordsC2);

		// Test clear() method
		System.out.println("\n\t Test clear() method");
		((MySortedArrayCollection<String>) wordsC2).clear();
		System.out.print(wordsC2);

		System.out.println("\nRestore Collection:");
		System.out
				.println(((MySortedArrayCollection<String>) wordsC2).addAll((MySortedArrayCollection<String>) wordsC1));

		System.out.print(wordsC2);

		// Test retainAll() method
		System.out.println("\n\t Test retainAll() method");
		System.out.println("retainAll: "
				+ ((MySortedArrayCollection<String>) wordsC1).retainAll((MySortedArrayCollection<String>) wordsC3));
		System.out.print(wordsC1);

		// Test removeAll() method
		System.out.println("\n\t Test removeAll() method");
		((MySortedArrayCollection<String>) wordsC1).removeAll((MySortedArrayCollection<String>) wordsC3);
		System.out.print(wordsC1);
	}

	private static int checkFiles(File actual, File sample, File input) {
		if (!sample.exists()) {
			System.out.println(sample.getName() + " missing");
			System.exit(0);
		}

		if (!input.exists()) {
			System.out.println(input.getName() + " missing");
			System.exit(0);
		}

		actual.delete();

		return 1;
	}

	private static boolean compareOutput(String file1, String file2) {
		Scanner inputStream1 = null;
		Scanner inputStream2 = null;

		try {
			inputStream1 = new Scanner(new File(file1));
			inputStream2 = new Scanner(new File(file2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		int lineNumber = 1;

		boolean same = true;
		while (inputStream1.hasNextLine() && inputStream2.hasNextLine()) {
			if (!inputStream1.nextLine().trim().equals(inputStream2.nextLine().trim())) {
				same = false;
				break;
			}
			lineNumber++;
		}

		if (!same || inputStream1.hasNextLine() || inputStream2.hasNextLine())
			System.out.println("\nCheck line #" + lineNumber);

		inputStream1.close();
		inputStream2.close();

		return same;
	}
}