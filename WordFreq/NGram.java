package Homework5;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
public class NGram {

	private static String inputFileName = "./src/Homework5/TheAdventuresOfSherlockHolmes.txt";
	private static SortedABList<WordFreq> ngramListA = new SortedABList<WordFreq>();
	private static SortedABList<WordFreq> ngramListB = new SortedABList<WordFreq>();

	public static void main (String args[]) {

		Scanner input = new Scanner(System.in);
		System.out.print("n-gram length>");
		int nlength = input.nextInt();
		System.out.print("Minimum n-gram frequency>");
		int nfrequency = input.nextInt();
		System.out.println("The " + nlength +"-gram with frequency counts of " + nfrequency + " and above:");
		readFileA(nlength);
		displayOutputA(nlength, nfrequency);

		System.out.print("Enter " + nlength + " words (X to stop): ");
		input.nextLine();
		String stopPhrase = input.nextLine();
		readFileB(nlength+1, stopPhrase);
		displayOutputB();


	}
	
	private static void readFileA(int nlength) {
		Scanner wordsInput = null;
		try {
			wordsInput = new Scanner(new FileReader(inputFileName));
		} catch (Exception e) {
			System.out.println("File not found.");
			System.exit(0);	
		}
		wordsInput.useDelimiter("[^a-zA-Z]+"); 


		int numWords = 0;
		ConcurrentLinkedQueue<String> ngramqueue = new ConcurrentLinkedQueue<String>();
		while (wordsInput.hasNext()) {
			if (numWords < nlength) {
				ngramqueue.add(wordsInput.next().toLowerCase());
				numWords++;
			}
			else {
				if (numWords == nlength) {
					Iterator<String> it = ngramqueue.iterator();
					String word = "";
					while (it.hasNext()) {
						word += it.next() + " ";
					}
					WordFreq ngram = new WordFreq(word);
					boolean contains = false;
					if (!ngramListA.isEmpty()) {
						Iterator<WordFreq> itr = ngramListA.iterator();
						while (itr.hasNext()) {
							WordFreq n = itr.next();
							if(ngram.compareTo(n) == 0) {
								n.inc();
								contains = true;
								break;
							}
						}
					}
					if (!contains) {
						ngram.inc();
						ngramListA.add(ngram);
					}
				}
				ngramqueue.remove();
				numWords--;
			}
		}
	}	
	
	private static void displayOutputA(int nlength, int nfrequency) {
		System.out.println("Freq  " + nlength + "-gram");
		System.out.println("----- -------------------"  );
		Iterator<WordFreq> itr = ngramListA.iterator();
		while (itr.hasNext()) {
			WordFreq n = itr.next();
			if(n.getFreq() >= nfrequency) {
				System.out.println(n);
			}
		}
	}
	
	private static void readFileB(int nlength, String stopPhrase) {
		Scanner wordsInput = null;
		try {
			wordsInput = new Scanner(new FileReader(inputFileName));
		} catch (Exception e) {
			System.out.println("File not found.");
			System.exit(0);	
		}
		wordsInput.useDelimiter("[^a-zA-Z]+"); 

		int numWords = 0;
		ConcurrentLinkedQueue<String> ngramqueue = new ConcurrentLinkedQueue<String>();
		while (wordsInput.hasNext()) {
			if (numWords < nlength) {
				ngramqueue.add(wordsInput.next().toLowerCase());
				numWords++;
			}
			else {
				if (numWords == nlength) {
					Iterator<String> it = ngramqueue.iterator();
					String word = "";
					int count = 1;
					boolean match = false;
					while (it.hasNext()) {
						word += it.next() + " ";
						if (count == nlength-1) {
							String newWord = word.substring(0, word.length()-1);
							if (newWord.compareTo(stopPhrase) == 0) {
								match = true;
							} else {
								break;
							}
						}
						count++;
					}
					if (match) {
						WordFreq ngram = new WordFreq(word);
						boolean contains = false;
						if (!ngramListB.isEmpty()) {
							Iterator<WordFreq> itr = ngramListB.iterator();
							while (itr.hasNext()) {
								WordFreq n = itr.next();
								if(ngram.compareTo(n) == 0) {
									n.inc();
									contains = true;
									break;
								}
							}
						}
						if (!contains) {
							ngram.inc();
							ngramListB.add(ngram);
						}
					}
				}
				ngramqueue.remove();
				numWords--;
			}
		}
	}
	private static void displayOutputB() {
		Iterator<WordFreq> itr1 = ngramListB.iterator();
		int sum = 0;
		while (itr1.hasNext()) {
			WordFreq n = itr1.next();
			sum += n.getFreq();
		}
		Iterator<WordFreq> itr2 = ngramListB.iterator();
		while (itr2.hasNext()) {
			WordFreq n = itr2.next();
			System.out.println(toString(n, sum));
		}
	}
	private static String toString(WordFreq n, int sum) {
		DecimalFormat fmt = new DecimalFormat("00000");
		double percent = (double) n.getFreq()/sum*100;
		return (fmt.format(n.getFreq()) + " " + percent + "%         " + n.getWordIs());
	}
}

