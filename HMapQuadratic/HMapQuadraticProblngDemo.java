package FinalExam.Question2;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class HMapQuadraticProblngDemo {
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
	
	public static void main(String[] args) throws FileNotFoundException {
		HMapQuadraticProbing<Integer, String> test = new HMapQuadraticProbing<Integer, String>(5, 0.75);

		String packageName = test.getClass().getPackageName();
		if (!packageName.equalsIgnoreCase("FinalExam.Question2")) {
			System.out.println("Set package to FinalExam.Question2");
			System.exit(0);
		}
		
		String actualOutputFileName = "./src/FinalExam/Question2/ActualOutput.txt";
		String sampleOutputFileName = "./src/FinalExam/Question2/SampleOutput.txt";
		File actualOutputFile = new File(actualOutputFileName);
		File sampleOutputFile = new File(sampleOutputFileName);

		if (!sampleOutputFile.exists()) {
			System.out.println(sampleOutputFile.getName() + " missing");
			System.exit(0);
		}

		if (actualOutputFile.exists()) {
			actualOutputFile.delete();
		}
		
		System.setOut(new PrintStream(actualOutputFile));

		System.out.println(test);

		test.put(5, "Apple");
		System.out.println(test);

		test.put(15, "Orange");
		System.out.println(test);

		test.put(25, "Strawberry");
		System.out.println(test);

		test.put(3, "Lemon");
		System.out.println(test);

		test.put(2, "Grava");
		System.out.println(test);

		test.remove(5);
		System.out.println(test);

		System.out.println(test.get(35));

		test.remove(15);
		System.out.println(test);

		test.put(15, "Test");
		System.out.println(test);

		System.out.println(test.contains(15));
		System.out.println(test.contains(13));

		System.out.println(test);
		
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

		// Compare with VerifyOutput.txt
		if (!compareOutput(sampleOutputFileName, actualOutputFileName))
			System.out.println("Check your output by comparing SampleOutput.txt.");
		else
			System.out.printf("50/50.\n");
	}
}
