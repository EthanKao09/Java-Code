import java.util.Scanner;
import java.util.Random;
public class PrintRandomChart
{
	public static void printRandomChart()  throws InterruptedException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("This game requests a number from the player.");
		System.out.println("The game then throws the dice that number of times.");
		System.out.println("The game then displays a chart showing the number of");
		System.out.println("times the six dice faces appeared given");
		System.out.println("the number of throws.");
		Random random = new Random();
		String answer;
		do 
		{	
			System.out.println("Please enter the number of times that you would");
			System.out.println("like the computer to throw the dice.");
			int times = keyboard.nextInt();

			int face1=0,face2=0,face3=0,face4=0,face5=0,face6=0;

			{
				for( int zero = 1; zero <= times; zero++) 
				{
					int dieFace = random.nextInt(6) + 1;

					if(dieFace==1)
					{
						face1++;
					}
					if(dieFace==2)
					{
						face2++;
					}
					if(dieFace==3)
					{
						face3++;
					}
					if(dieFace==4)
					{
						face4++;
					}
					if(dieFace==5)
					{
						face5++;
					}
					if(dieFace==6)
					{
						face6++;
					}

				}
				System.out.print("Dice number 1: ");
				for(int time1 = 1; time1 <= face1; time1++)
				{
					System.out.print("*");
				}
				System.out.println();
				System.out.print("Dice number 2: ");
				for(int time2 = 1; time2 <= face2; time2++)
				{
					System.out.print("*");
				}
				System.out.println();
				System.out.print("Dice number 3: ");
				for(int time3 = 1; time3 <= face3; time3++)
				{
					System.out.print("*");
				}
				System.out.println();
				System.out.print("Dice number 4: ");
				for(int time4 = 1; time4 <= face4; time4++)
				{
					System.out.print("*");
				}
				System.out.println();
				System.out.print("Dice number 5: ");
				for(int time5 = 1; time5 <= face5; time5++)
				{
					System.out.print("*");
				}
				System.out.println();
				System.out.print("Dice number 6: ");
				for(int time6 = 1; time6 <= face6; time6++)
				{
					System.out.print("*");
				}
				System.out.println();
				System.out.println("Do you want to play again?(Yes/No)");

			}
			answer = keyboard.next();

		}while (answer.equalsIgnoreCase("yes"));



	}
}
