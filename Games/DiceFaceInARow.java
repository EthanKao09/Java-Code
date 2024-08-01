import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
public class DiceFaceInARow
{
	public static void diceFaceInARow() throws InterruptedException 
	{
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		int traceOrAnswer;
		
		
		String answer;
		do
		{
			System.out.println("     Please enter the version you want:");
			System.out.println("       1) Trace the game.");
			System.out.println("       2) Just give the answer.");
			System.out.println("     Please enter 1 or 2");
			traceOrAnswer = keyboard.nextInt();
			
			switch (traceOrAnswer)
			{
			case 1:
				System.out.println("Please enter the dice face number that you would like to be repeated.");
				int face = keyboard.nextInt();
				System.out.println(" Please enter the number of times that you would like " + face + " to appear in a row.");
				int time = keyboard.nextInt();
				int count = 0;
				for (int time2=0;time2<time;)
				{
					DecimalFormat numberFormat = new DecimalFormat();
					int diceFace = random.nextInt(6)+1;

					if (diceFace == face)
					{
						time2++;
						count++;
					}
					else
					{
						time2 = 0;
						count++;
					}
					String number = numberFormat.format(count);
					System.out.println();
					System.out.println("You got a "+diceFace);
					System.out.println("Number of times in a row so far is " + time2);
					System.out.println("Number of throws is "+number);
					System.out.println();
				}

				System.out.println("Do you want to play again?(Yes/No)");
				break;
			
			case 2:
				DecimalFormat numberFormat = new DecimalFormat();
				System.out.println("Please enter the dice face number that you would like to be repeated.");
				int face1 = keyboard.nextInt();
				System.out.println(" Please enter the number of times that you would like " + face1 + " to appear in a row.");
				int time1 = keyboard.nextInt();
				int count1=0;
				for (int time3=0;time3<time1;)
				{
					int diceFace = random.nextInt(6)+1;

					if (diceFace == face1)
					{
						time3++;
						count1++;
					}
					else
					{
						time3 = 0;
						count1++;
					}
					
				}
				String number = numberFormat.format(count1);
				System.out.println(" It took "+ number +" throws to get the number "+ face1 +" to appear " + time1 + " times in a row.");
				System.out.println();
				System.out.println("Do you want to play again?(Yes/No)");
				break;
				
			}answer = keyboard.next();

		}while (answer.equalsIgnoreCase("yes"));
	}
}