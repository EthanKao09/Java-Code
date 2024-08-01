import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
public class RaceNames 
{	
	private static String answer;
	static Scanner keyboard = new Scanner(System.in);
	static Random random = new Random();
	public static void raceNames() throws InterruptedException
	{	
		introduction();
		loop();


	}
	private static void introduction()
	{
		System.out.println("               This game races three names. The random number generator");
		System.out.println("               from the Math class repeatedly gives each name a random number");
		System.out.println("               between 1 and 5.  As the names move these random distances ");
		System.out.println("               we see which name gets to the finish line first.");

	}
	private static void loop() throws InterruptedException
	{
		do 
		{
			System.out.println("               Press enter to begin the race.");
			String enterr = keyboard.next();
			

			int Stack1 = 0;
			int Stack2= 0;
			int Stack3 = 0;
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("The race begins!");
			System.out.println("Khai                                                                      |");
			System.out.println("Tuong                                                                    |");
			System.out.println("Bin                                                                      |");
			Thread.sleep(1000);

			for (int time = 0; time<25; time++)
			{

				int A = random.nextInt(5)+1;
				int B = random.nextInt(5)+1;
				int C = random.nextInt(5)+1;


				Stack1 = Stack1 + A;
				Stack2 = Stack2 + B;
				Stack3 = Stack3 + C;

				String space = "                                                                      ";


				if(Stack1 <= 69 && Stack2 <= 69 && Stack3 <= 69 )
				{
					
					String randomSpaceFront1 = space.substring(0, Stack1);
					String randomSpaceFront2 = space.substring(0, Stack2);
					String randomSpaceFront3 = space.substring(0, Stack3);

					String randomSpaceBack1 = space.substring(Stack1,70);
					String randomSpaceBack2 = space.substring(Stack2,70);
					String randomSpaceBack3 = space.substring(Stack3,70);

					Thread.sleep(250);
					System.out.println("\n\n\n\n\n\n\n\n\n");
					System.out.println("The race continues");
					System.out.println(randomSpaceFront1 + "Khai" +randomSpaceBack1 +"|");
					System.out.println(randomSpaceFront2 + "Tuong" +randomSpaceBack2 +"|");
					System.out.println(randomSpaceFront3 + "Bin" +randomSpaceBack3 +"|");
				
				}
				if (Stack1 >= 70 && Stack2 <= 69 && Stack3 <= 69)
				{
					Stack1 = 70;
					String randomSpaceFront1 = space.substring(0);
					String randomSpaceFront2 = space.substring(0, Stack2);
					String randomSpaceFront3 = space.substring(0, Stack3);

					
					String randomSpaceBack2 = space.substring(Stack2,70);
					String randomSpaceBack3 = space.substring(Stack3,70);

					System.out.println("\n\n\n\n\n\n\n\n\n");
					System.out.println(randomSpaceFront1 + " Khai");
					System.out.println(randomSpaceFront2 + "Tuong" +randomSpaceBack2 +"|");
					System.out.println(randomSpaceFront3 + "Bin" +randomSpaceBack3 +"|");
					System.out.println("Khai finished first!");
					break;
				}
				else if (Stack2 >= 70 && Stack1 <= 69 && Stack3 <= 69)
				{
					Stack2 = 70;
					String randomSpaceFront1 = space.substring(0, Stack1);
					String randomSpaceFront2 = space.substring(0);
					String randomSpaceFront3 = space.substring(0, Stack3);

					String randomSpaceBack1 = space.substring(Stack1,70);
					
					String randomSpaceBack3 = space.substring(Stack3,70);

					System.out.println("\n\n\n\n\n\n\n\n\n");
					System.out.println(randomSpaceFront1 + "Khai" +randomSpaceBack1 +"|");
					System.out.println(randomSpaceFront2 + " Tuong");
					System.out.println(randomSpaceFront3 + "Bin" +randomSpaceBack3 +"|");
					System.out.println("Tuong finished first!");
					break;
				}
				else if (Stack3 >= 70 && Stack1 <= 69 && Stack2 <= 69 )
				{
					Stack3 = 70;
					String randomSpaceFront1 = space.substring(0, Stack1);
					String randomSpaceFront2 = space.substring(0, Stack2);
					String randomSpaceFront3 = space.substring(0);

					String randomSpaceBack1 = space.substring(Stack1,70);
					String randomSpaceBack2 = space.substring(Stack2,70);
					

					System.out.println("\n\n\n\n\n\n\n\n\n");
					System.out.println(randomSpaceFront1 + "Khai" +randomSpaceBack1 +"|");
					System.out.println(randomSpaceFront2 + "Tuong" +randomSpaceBack2 +"|");
					System.out.println(randomSpaceFront3 + " Bin");
					System.out.println("Bin finished first!");
					break;
				}
				else if (Stack1 >= 70 && Stack2 >= 70 && Stack3 <= 69)
				{
					Stack1 = 70;
					Stack2 = 70;
					String randomSpaceFront1 = space.substring(0);
					String randomSpaceFront2 = space.substring(0);
					String randomSpaceFront3 = space.substring(0, Stack3);

					
					String randomSpaceBack3 = space.substring(Stack3,70);

					System.out.println("\n\n\n\n\n\n\n\n\n");
					System.out.println(randomSpaceFront1 + " Khai");
					System.out.println(randomSpaceFront2 + " Tuong");
					System.out.println(randomSpaceFront3 + "Bin" +randomSpaceBack3 +"|");
					System.out.println("Khai and Tuong finished at the same time!");
					break;
				}
				else if (Stack1 >= 70 && Stack3 >= 70 && Stack2 <= 69)
				{
					Stack1 = 70;
					Stack3 = 70;
					String randomSpaceFront1 = space.substring(0);
					String randomSpaceFront2 = space.substring(0, Stack2);
					String randomSpaceFront3 = space.substring(0, Stack3);

					
					String randomSpaceBack2 = space.substring(Stack2,70);
					

					System.out.println("\n\n\n\n\n\n\n\n\n");
					System.out.println(randomSpaceFront1 + " Khai");
					System.out.println(randomSpaceFront2 + "Tuong" +randomSpaceBack2 +"|");
					System.out.println(randomSpaceFront3 + " Bin");
					System.out.println("Khai and Bin finished at the same time!");
					break;
				}
				else if (Stack2 >= 70 && Stack3 >= 70 && Stack1 <= 69)
				{
					Stack3 = 70;
					Stack2 = 70;
					String randomSpaceFront1 = space.substring(0);
					String randomSpaceFront2 = space.substring(0, Stack2);
					String randomSpaceFront3 = space.substring(0, Stack3);

					String randomSpaceBack1 = space.substring(Stack1,70);
					


					System.out.println("\n\n\n\n\n\n\n\n\n");
					System.out.println(randomSpaceFront1 + "Khai" +randomSpaceBack1 +"|");
					System.out.println(randomSpaceFront2 + " Tuong");
					System.out.println(randomSpaceFront3 + " Bin");
					System.out.println("Tuong and Bin finisehd at the same time!");
					break;
				}	
				else if (Stack2 >= 70 && Stack3 >= 70 && Stack1 >= 70)
				{
					Stack1 = 70;
					Stack3 = 70;
					Stack2 = 70;
					
					String randomSpaceFront1 = space.substring(0);
					String randomSpaceFront2 = space.substring(0, Stack2);
					String randomSpaceFront3 = space.substring(0, Stack3);
				

					System.out.println("\n\n\n\n\n\n\n\n\n");
					System.out.println(randomSpaceFront1 + " Khai");
					System.out.println(randomSpaceFront2 + " Tuong");
					System.out.println(randomSpaceFront3 + " Bin");
					System.out.println("Khai, Tuong and Bin finisehd at the same time!");
					break;
				}
								
			}
			System.out.println("		 Would you like to play the game again?(Yes/No)");
			answer = keyboard.next();
		}while (answer.equalsIgnoreCase("yes"));

	}
}
