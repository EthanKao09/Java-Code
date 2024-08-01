package Homework2;

/*
    Use this driver program to test against your FixedFrontArrayQueue.java and CircularLinkedQueue.java

    Upload your FixedFrontArrayQueue.java and CircularLinkedQueue.java to Canvas for grade.

Tips:   Comment out sections that you have not finished, so it does not
        interfere your troubleshooting.  
*/

import java.io.File;
import java.io.PrintStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class Homework2Demo {
	public static void main(String[] args) throws FileNotFoundException {
		String actualOutputFileName = "./src/Homework2/ActualOutput.txt";
		String sampleOutputFileName = "./src/Homework2/SampleOutput.txt";

		File actualOutputFile = new File(actualOutputFileName);
		File sampleOutputFile = new File(sampleOutputFileName);

		int score = 0;

		score += checkProjectSettings1();
		score += checkProjectSettings2();
		score += checkFiles(actualOutputFile, sampleOutputFile);

		if (score < 2) {
			System.out.println("Check project and package settings.");
			System.exit(0);
		}

		// Test# 1
		score += testFixedFrontArrayQueue();	
		score += testCircularLinkedQueue();
		
		System.setOut(new PrintStream(actualOutputFile));
		testFixedFrontArrayQueue();
		testCircularLinkedQueue();
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

		if (compareOutput(sampleOutputFileName, actualOutputFileName))
			score += 5;

		System.out.printf("Your score is %d/50.\n", score);
	}

	private static int testFixedFrontArrayQueue() {
		int score = 0;

		FixedFrontArrayQueue<Character> c = new FixedFrontArrayQueue<Character>();
		if (c.getQueueCapacity() == 100)
			score += 1;
		else
			System.out.println("Check default constructor.");

		FixedFrontArrayQueue<String> q = new FixedFrontArrayQueue<String>(2);
		if (q.getQueueCapacity() == 2)
			score += 1;
		else
			System.out.println("Check overloaded constructor.");

		try {
			q.dequeue(); // Note: Underflow exception should occur
		} catch (Exception e) {
			score += 3;
		}

		if (q.isEmpty() && !q.isFull() && q.size() == 0)
			score += 3;
		else
			System.out.println("Check isEmpty(), isFull() and size() methods.");

		System.out.println("Enqueue Orange");
		q.enqueue("Orange");
		System.out.println(q);

		System.out.println("Enqueue Mango");
		q.enqueue("Mango");
		System.out.println(q);

		System.out.println("Enqueue Guave into full queue");
		try {
			q.enqueue("Guava"); // Note: with Queue size 2, this won't get into the queue.
		} catch (Exception e) {
			score += 3;
		}
		System.out.println(q);

		if (q.isFull())
			score += 2;
		else
			System.out.println("Check enqueue() and isFull() method.");

		System.out.println("Dequeue");
		if (q.dequeue().equals("Orange") && q.size() == 1 && !q.isEmpty())
			score += 3;
		else
			System.out.println("Check dequeue(), size() and isEmpty() methods");
		System.out.println(q);

		System.out.println("Dequeue");

		if (q.dequeue().equals("Mango") && q.size() == 0 && q.isEmpty())
			score += 2;
		else
			System.out.println("Check dequeue(), size() and isEmpty() methods");
		System.out.println(q);

		System.out.println("Enqueue Strawberry");
		q.enqueue("Strawberry");
		System.out.println(q);

		System.out.println("Enqueue Lemon");
		q.enqueue("Lemon");
		System.out.println(q);

		System.out.println("Resize and Enqueu Banana");
		q.resize(2); // Increase the array size by 2
		q.enqueue("Banana");
		if (q.getQueueCapacity() == 4 && q.size() == 3 && !q.isEmpty() && !q.isFull())
			score += 3;
		else
			System.out.println("Check enqueue(), resize(), getQueueCapacity(), size(), isEmpty and isFull()");
		System.out.println(q);

		System.out.println("Resize");
		q.resize(-1); // Decrease the array size by 1.
		if (q.getQueueCapacity() == 3 && q.size() == 3 && !q.isEmpty() && q.isFull())
			score += 2;
		else
			System.out.println("Check resize(), getQueueCapacity(), size(), isEmpty and isFull()");
		System.out.println(q);

		return score;
	}

	private static int testCircularLinkedQueue() {
		int score = 0;

		CircularLinkedQueue<String> cq = new CircularLinkedQueue<String>();

		try { // Note: This is to test if dequeue from an empty queue is handled.
			System.out.println(cq.dequeue());
		} catch (Exception e) {
			score += 4;
		}

		if (cq.size() == 0 && cq.isEmpty() && !cq.isFull())
			score += 5;
		else
			System.out.println("Check size(), isEmpty() and isFull() methods");

		System.out.println("Enqueue Tomato");
		cq.enqueue("Tomato");
		System.out.println(cq);

		System.out.println("Enqueue Grape");
		cq.enqueue("Grape");
		System.out.println(cq);

		if (cq.size() == 2 && !cq.isEmpty() && !cq.isFull())
			score += 5;
		else
			System.out.println("Check enqueue(), size(), isEmpty() and isFull() methods");

		System.out.println("Dequeue");
		cq.dequeue();
		System.out.println(cq);

		System.out.println("Dequeue");
		cq.dequeue();
		System.out.println(cq);

		if (cq.size() == 0 && cq.isEmpty() && !cq.isFull())
			score += 5;
		else
			System.out.println("Check dequeue(), size(), isEmpty() and isFull() methods");

		System.out.println("Enqueu Pineapple");
		cq.enqueue("Pineapple");
		System.out.println(cq);

		System.out.println("Enqueue Line");
		cq.enqueue("Lime");
		System.out.println(cq);

		return score;
	}

	private static int checkProjectSettings1() {
		final String PACKAGE_NAME = "Homework2";
		final String INTERFACE_NAME = "QueueInterface";

		// Check if Package was correct
		FixedFrontArrayQueue<String> test = new FixedFrontArrayQueue<String>();

		String packageName = test.getClass().getPackageName();
		if (!packageName.equalsIgnoreCase(PACKAGE_NAME)) {
			System.out.println("Set package to " + PACKAGE_NAME);
			System.exit(0);
		}

		// Check if Interface was included
		String interfaceName = "";
		try {
			interfaceName = test.getClass().getInterfaces()[0].getName();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Interface not found");
			System.exit(0);
		}

		if (!interfaceName.substring(interfaceName.lastIndexOf('.') + 1).equalsIgnoreCase(INTERFACE_NAME)) {
			System.out.println("Set to implement " + INTERFACE_NAME + " interface");
			System.exit(0);
		}

		return 1;
	}

	private static int checkProjectSettings2() {
		final String PACKAGE_NAME = "Homework2";
		final String INTERFACE_NAME = "QueueInterface";

		// Check if Package was correct
		CircularLinkedQueue<String> test = new CircularLinkedQueue<String>();

		String packageName = test.getClass().getPackageName();
		if (!packageName.equalsIgnoreCase(PACKAGE_NAME)) {
			System.out.println("Set package to " + PACKAGE_NAME);
			System.exit(0);
		}

		// Check if Interface was included
		String interfaceName = "";
		try {
			interfaceName = test.getClass().getInterfaces()[0].getName();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Interface not found");
			System.exit(0);
		}

		if (!interfaceName.substring(interfaceName.lastIndexOf('.') + 1).equalsIgnoreCase(INTERFACE_NAME)) {
			System.out.println("Set to implement " + INTERFACE_NAME + " interface");
			System.exit(0);
		}

		return 1;
	}

	private static int checkFiles(File actual, File sample) {
		if (!sample.exists()) {
			System.out.println("SampleOutput.txt missing");
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
			System.out.println("Check line #" + lineNumber);

		inputStream1.close();
		inputStream2.close();

		return same;
	}
}
