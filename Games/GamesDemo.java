import java.util.Scanner;
public class GamesDemo
{
	static int endGameNumber;
	static Scanner scan = new Scanner(System.in);
	public static void main(String [] args) throws InterruptedException
	{
		int choiceNumber = 0;
		endGameNumber = 7;
		introduction();
		while(choiceNumber != endGameNumber)
		{
			printMenuChoices();
			choiceNumber = readChoiceNumber();
			switch (choiceNumber)
			{
			case 1:
			PrintRandomChart.printRandomChart();
				break;
			case 2:
				DiceFaceInARow.diceFaceInARow();
				break;
			case 3:
				PatternOfSix.patternOfSix();
				break;
			case 4:
				RaceNames.raceNames();
				break;
			case 5:
				GeometricShapes.GeometricShapes();
				break;
			case 6:
				TicTacToe.ticTacToe();
				break;
			case 7:
				System.out.println("                     Thank you for playing the games.");
				choiceNumber = endGameNumber;
				break;
			default:
				System.out.println("         Invalid choice.  The game is over.");
				choiceNumber = endGameNumber;
				break;
			}//switch

		}//while
	}
	private static void introduction()
	{
		System.out.println("\n\n" +
				"                   Ten empty lines are added.  This is useful.\n\n\n\n\n\n\n\n\n\n");
		System.out.println("" +
				"                   This program demonstrates the framework\n" +
				"                            of the games projects.\n"+
				"                      \n" );
	}
	private static void printMenuChoices()
	{
		System.out.println(""+
				"                      Testing an example project.\n"
				+ "                        1) Print Random Chart.\n"
				+ "                        2) Dice Face In A Row. \n"
				+ "                        3) Pattern Of Six. \n"
				+ "                        4) Race Name. \n"
				+ "                        5) Geometric Shapes. \n"
				+ "                        6) Tic Tac Toe. \n"
				+ "                        7) Quit playing this example. \n"
				+ "                      Please choose one of the seven choices.");

	}
	private static int readChoiceNumber()
	{
		int choiceNumber;
		choiceNumber = scan.nextInt();
		while(choiceNumber < 1 || choiceNumber > endGameNumber)
		{
			System.out.println("        the number must be 1" +
				    " through " + endGameNumber + " inclusive");
					System.out.println("               please enter a proper choice.  ");
					choiceNumber = scan.nextInt();		}
		return choiceNumber;
	}
}
