//package Homework5;
//
//import java.io.*;
//import java.util.*;
//import java.util.concurrent.ConcurrentLinkedQueue;
//public class NGram {
//
//	private static String inputFileName = "./src/Homework5/TheAdventuresOfSherlockHolmes.txt";
//	private static SortedABList<WordFreq> ngramlist = new SortedABList<WordFreq>();
//
//	public static void main (String args[]) {
//
//		Scanner input = new Scanner(System.in);
//		System.out.print("n-gram length>");
//		int nlength = input.nextInt();
//		System.out.print("Minimum n-gram frequency>");
//		int nfrequency = input.nextInt();
//		System.out.println("The " + nlength +"-gram with frequency counts of " + nfrequency + " and above:");
//		readFile(nlength);
//		displayOutput(nlength, nfrequency);
//		//		System.out.print("Enter " + nlength + " words (X to stop): " + stopPhrase);
//		//		string stopPhrase = input.nextString();
//		//		displayOutputB(nlength+1);
//
//	}
//	private static void readFile(int nlength) {
//		Scanner wordsInput = null;
//		try {
//			wordsInput = new Scanner(new FileReader(inputFileName));
//		} catch (Exception e) {
//			System.out.println("File not found.");
//			System.exit(0);	
//		}
//		wordsInput.useDelimiter("[^a-zA-Z]+"); 
//
//
//		int numWords = 0;
//		ConcurrentLinkedQueue<String> ngramqueue = new ConcurrentLinkedQueue<String>();
//		while (wordsInput.hasNext()) {
//			if (numWords < nlength) {
//				ngramqueue.add(wordsInput.next().toLowerCase());
//				numWords++;
//			}
//			else {
//				if (numWords == nlength) {
//					Iterator<String> it = ngramqueue.iterator();
//					String word = "";
//					while (it.hasNext()) {
//						word += it.next() + " ";
//					}
//					WordFreq ngram = new WordFreq(word);
//					boolean contains = false;
//					if (!ngramlist.isEmpty()) {
//						Iterator<WordFreq> itr = ngramlist.iterator();
//						while (itr.hasNext()) {
//							WordFreq n = itr.next();
//							if(ngram.compareTo(n) == 0) {
//								n.inc();
//								contains = true;
//								break;
//							}
//						}
//					}
//					if (!contains) {
//						ngram.inc();
//						ngramlist.add(ngram);
//					}
//				}
//				ngramqueue.remove();
//				numWords--;
//			}
//		}
//	}	
//	private static void displayOutput(int nlength, int nfrequency) {
//		System.out.println("Freq  " + nlength + "-gram");
//		System.out.println("----- -------------------"  );
//		Iterator<WordFreq> itr = ngramlist.iterator();
//		while (itr.hasNext()) {
//			WordFreq n = itr.next();
//			if(n.getFreq() >= nfrequency) {
//				System.out.println(n);
//			}
//		}
//	}
//	//	private static void displayOutputB(int nlength+1) {
//	//		
//	//	}
//}
