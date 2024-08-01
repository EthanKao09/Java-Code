import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
public class PatternOfSix 
{
	static Scanner keyboard = new Scanner(System.in);
	static Random random = new Random();
	static DecimalFormat numberFormat = new DecimalFormat();

	public static String answer;
	public static int answer1;
	public static void patternOfSix() throws InterruptedException
	{
		System.out.println("            This game requests six dice numbers from the player.");
		System.out.println("            The game then throws the dice until that pattern appears.");
		System.out.println("            The game then tells the player how many throws it took");
		do
		{
			System.out.println("            Please enter the six number pattern you would");
			System.out.println("            like the computer to throw seperated by spaces");
			int firstChoice = keyboard.nextInt();
			int secondChoice = keyboard.nextInt();
			int thirdChoice = keyboard.nextInt();
			int fourthChoice = keyboard.nextInt();
			int fifthChoice = keyboard.nextInt();
			int sixthChoice = keyboard.nextInt();
			int count = 0;

			if (firstChoice < 7 && secondChoice < 7 && thirdChoice <7 && fourthChoice < 7 && fifthChoice < 7 && sixthChoice < 7 && firstChoice > 0 && secondChoice > 0 && thirdChoice > 0 && fourthChoice > 0 && fifthChoice > 0 && sixthChoice > 0)
			{
				for ( int time = 0; time < 6;) 
				{
					int face1 = random.nextInt(6)+1;
					int face2 = random.nextInt(6)+1;
					int face3 = random.nextInt(6)+1;
					int face4 = random.nextInt(6)+1;
					int face5 = random.nextInt(6)+1;
					int face6 = random.nextInt(6)+1;
					if (face1 == firstChoice)
					{
						time++;
					}
					else
						time = 0;
					if (face2 == secondChoice)
					{
						time++;
					}
					else
						time = 0;
					if (face3 == thirdChoice)
					{
						time++;
					}
					else
						time = 0;
					if (face4 == fourthChoice)
					{
						time++;
					}
					else
						time = 0;
					if (face5 == fifthChoice)
					{
						time++;
					}
					else
						time = 0;

					if (face6 == sixthChoice)
					{
						time++;
					}
					else
						time = 0;
					count = count +6;

				}
				DecimalFormat numberFormat = new DecimalFormat();
				String number = numberFormat.format(count);
				System.out.println("            it took " + number + " throws to get the pattern "+" "+firstChoice+" "+secondChoice+" "+thirdChoice+" "+fourthChoice+" "+fifthChoice+" "+sixthChoice);
				System.out.println("		 Would you like to play the game again?(Yes/No)");
				answer = keyboard.next();
			}
			else
			{
				System.out.println("            INVALID VALUE");
				System.out.println("            Valid values are from 1 to 6");
				answer = "yes";
			}

		}while (answer.equalsIgnoreCase("yes"));
	}
}