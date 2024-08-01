import java.util.Scanner;

public class TicTacToe 
{
	public static boolean myTurn= true;
	public static String answer;
	public static int player=0;
	public static int machine=0;
	public static void ticTacToe()  throws InterruptedException
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("                                Tic_tac_toe game");
		System.out.println("               This game is played between you and the computer.");
		System.out.println("               You move first and the computer will then move.");
		System.out.println("               Play continues until you or the computer wins or");
		System.out.println("               it is a \"cat's\" game.");




		do
		{
			String row1 = "A ___|___|___";
			String row2 = "B ___|___|___";
			String row3 = "C    |   |   ";
			System.out.println("   1   2   3");
			System.out.println(row1);
			System.out.println(row2);
			System.out.println(row3);
			int a1 = 0, a2 =0, a3 = 0, b1 = 0, b2 = 0, b3 = 0, c1 = 0, c2 = 0, c3 = 0;
			int xa1 = 0, xa2 =0, xa3 = 0, xb1 = 0, xb2 = 0, xb3 = 0, xc1 = 0, xc2 = 0, xc3 = 0;
			for (int count =1; count < 10;) 
			{
				if (myTurn)
				{
					System.out.println("moveCount is "+ count );
					System.out.println("               Please enter your move.");
					String move = kb.next();	
					if(move.equalsIgnoreCase("a1") && a1==0 && xa1==0 ) 
					{
						row1 = row1.substring(0,3) + "O" +row1.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						a1++;
						myTurn = false;
					}
					else if(move.equalsIgnoreCase("a2")&& a2 == 0 &&xa2==0)
					{
						row1 = row1.substring(0,7) + "O" +row1.substring(8);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						a2++;
						myTurn = false;
					}
					else if(move.equalsIgnoreCase("a3")&& a3 == 0 && xa3==0 )
					{
						row1 = row1.substring(0,11) + "O" +row1.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						a3++;
						myTurn = false;
					}
					else if(move.equalsIgnoreCase("b1")&& b1 == 0 && xb1==0)
					{
						row2 = row2.substring(0,3) + "O" +row2.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						b1++;
						myTurn = false;
					}
					else if(move.equalsIgnoreCase("b2") && b2 == 0 && xb2==0)
					{
						row2 = row2.substring(0,7) + "O" +row2.substring(8);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						b2++;
						myTurn = false;
					}
					else if(move.equalsIgnoreCase("b3")&& b3 ==0 && xb3==0 )
					{
						row2 = row2.substring(0,11) + "O" +row2.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						b3++;
						myTurn = false;
					}
					else if(move.equalsIgnoreCase("c1")&& c1 == 0 && xc1==0)
					{
						row3 = row3.substring(0,3) + "O" +row3.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						c1++;
						myTurn = false;
					}
					else if(move.equalsIgnoreCase("c2") && c2 == 0 && xc2==0)
					{
						row3 = row3.substring(0,7) + "O" +row3.substring(8);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						c2++;
						myTurn = false;
					}
					else if (move.equalsIgnoreCase("c3") && c3 == 0 && xc3==0)
					{
						row3 = row3.substring(0,11) + "O" +row3.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						c3++;
						myTurn = false;
					}
					else
					{
						myTurn = true;
						System.out.println("Illegal move. Please enter legal move.");
					}


				}
				else 
				{
					System.out.println("moveCount is "+ count);
					System.out.println("               Computer makes a move. 	");
					if(b2 == 0 && xb2==0 )
					{
						row2 = row2.substring(0,7) + "X" +row2.substring(8);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xb2++;
					}
					
					else if (xb2==1 && xa1 ==1 && xc3==0 && c3==0)
					{
						row3 = row3.substring(0,11) + "X" +row3.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc3++;
					}
					else if (xc1==1 && xb1==1 && xa1==0 && a1==0)
					{
						row1 = row1.substring(0,3) + "X" +row1.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa1++;
					}
					else if (xa1==1 && xb1==1 && xc1==0 && c1==0)
					{
						row3 = row3.substring(0,3) + "X" +row3.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc1++;
					}
					else if (xa1==1 && xa2==1 && xc1==0 && c1==0)
					{

						row3 = row3.substring(0,3) + "X" +row3.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc1++;
					}
					else if (xa2==1 && xa3==1 && xa1==0 && a1==0)
					{
						row1 = row1.substring(0,3) + "X" +row1.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa1++;
					}
					else if (xa3==1 && xb3==1 && xc3==0 && c3==0)
					{
						row3 = row3.substring(0,11) + "X" +row3.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc3++;
					}

					else if (xb3==1 && xc3==1 && xa3==0 && a3==0)
					{

						row1 = row1.substring(0,11) + "X" +row1.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa3++;
					}
					else if (xc2==1 && xc3==1 && xc1==0 && c1==0)
					{

						row3 = row3.substring(0,3) + "X" +row3.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc1++;
					}
					else if (xc1==1 && xc2 ==1 && xc3==0 && c3==0)
					{
						row3 = row3.substring(0,11) + "X" +row3.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc3++;
					}
					else if (xb2 == 1 && xa2==1 && xc2==0 && c2==0)
					{

						row3 = row3.substring(0,7) + "X" +row3.substring(8);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc2++;
					}
					else if (xb2==1 && xc2==1 && xa2==0 && a2==0)
					{
						row1 = row1.substring(0,7) + "X" +row1.substring(8);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa2++;
					}
					else if (xb2==1 && xb1==1 && xb3==0 && b3==0)
					{
						row2 = row2.substring(0,11) + "X" +row2.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xb3++;

					}
					else if (xb2 ==1 && xb3 ==1 && xb1==0 && b1==0)
					{
						row2 = row2.substring(0,3) + "X" +row2.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xb1++;
					}
					else if (xb2 ==1 && xc1 ==1 && xa3==0 && a3==0)
					{
						row1 = row1.substring(0,11) + "X" +row1.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa3++;	
					}
					else if (xb2==1 && xa3==1 && xc1==0 && c1==0 )
					{

						row3 = row3.substring(0,3) + "X" +row3.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc1++;
					}
					else if (xb2==1 && xc3==1 && xa1==0 && a1==0)
					{
						row1 = row1.substring(0,3) + "X" +row1.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa1++;
					}

					else if(b2==1 && b1==1 && xb3==0 && b3==0)
					{
						row2 = row2.substring(0,11) + "X" +row2.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xb3++;
					}
					else if (c1==1 && b1==1 && xa1==0 && a1==0)
					{
						row1 = row1.substring(0,3) + "X" +row1.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa1++;
					}
					else if (c1==1 && c2==1 && xc3==0 && c3==0)
					{
						row3 = row3.substring(0,11) + "X" +row3.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc3++;
					}
					else if (b2 ==1 && a2==1 && xc2==0 && c2==0)
					{
						row3 = row3.substring(0,7) + "X" +row3.substring(8);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc2++;	
					}
					else if ( c2==1 && b2 ==1 && xa2==0 && a2==0) 
					{
						row1 = row1.substring(0,7) + "X" +row1.substring(8);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa2++;	
					}
					else if (b2 ==1 && b3==1 && xb1==0 && b1==0)
					{
						row2 = row2.substring(0,3) + "X" +row2.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xb1++;
					}
					else if (b2 ==1 && c1==1 && xa3 ==0 && a3==0)
					{
						row1 = row1.substring(0,11) + "X" +row1.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa3++;
					}
					else if (b2 ==1 && a3 ==1 && xc1==0 && c1==0)
					{
						row3 = row3.substring(0,3) + "X" +row3.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc1++;
					}
					else if (b2==1 && c3==1 && xa1==0 && a1==0)
					{
						row1 = row1.substring(0,3) + "X" +row1.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa1++;
					}
					else if (b2==1 && a1 == 1 && xc3==0 && c3==0)
					{
						row3 = row3.substring(0,11) + "X" +row3.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc3++;
					}
					else if (c2==1 && c3==1 && xc1==0 && c1==0)
					{
						row3 = row3.substring(0,3) + "X" +row3.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc1++;
					}

					else if (a1==1 && b1==1 && xc1==0 && c1==0)
					{
						row3 = row3.substring(0,3) + "X" +row3.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc1++;
					}
					else if (a1==1 && a2==1 && xa3==0 && a3==0)
					{
						row1 = row1.substring(0,11) + "X" +row1.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa3++;
					}
					else if (a2==1 && a3==1 && xa1==0 && a1==0)
					{
						row1 = row1.substring(0,3) + "X" +row1.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa1++;
					}
					else if (c3==1 && b3==1 && xa3==0 && a3==0)
					{
						row1 = row1.substring(0,11) + "X" +row1.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa3++;
					}
					else if (a3==1 && b3==1 && xc3==0 && c3==0)
					{
						row3 = row3.substring(0,11) + "X" +row3.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc3++;
					}
					else if (a1 ==0 && xa1==0 && a1==0)	
					{
						row1 = row1.substring(0,3) + "X" +row1.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa1++;
					}
					else if (a2 ==0 && xa2 ==0 && a2==0)
					{
						row1 = row1.substring(0,7) + "X" +row1.substring(8);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa2++;
					}
					else if (c2 == 0 && xc2 ==0 && c2==0)
					{
						row3 = row3.substring(0,7) + "X" +row3.substring(8);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc2++;
					}
					else if (b1 ==0 && xb1==0 && b1==0)
					{
						row2 = row2.substring(0,3) + "X" +row2.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xb1++;
					}

					else if (a3 ==0 && xa3==0 && a3==0)
					{
						row1 = row1.substring(0,11) + "X" +row1.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xa3++;
					}
					else if (b3 == 0 && xb3==0 && b3==0)
					{
						row2 = row2.substring(0,11) + "X" +row2.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xb3++;
					}

					else if (c3 ==0 && xc3==0 && c3==0)
					{
						row3 = row3.substring(0,11) + "X" +row3.substring(12);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc3++;
					}
					else if (c1 ==0 && xc1 ==0 )
					{
						row3 = row3.substring(0,3) + "X" +row3.substring(4);
						System.out.println("   1   2   3");
						System.out.println(row1);
						System.out.println(row2);
						System.out.println(row3);
						count++;
						xc1++;
					}

					myTurn = true;

				}
				if ((a1==1&&a2==1&&a3==1)||(b1==1&&b2==1&&b3==1)||(c1==1&&c2==1&&c3==1)||(a1==1&&b1==1&&c1==1)||(a2==1&&b2==1&&c2==1)||(a3==1&&b3==1&&c3==1)||(a1==1&&b2==1&&c3==1)||(a3==1&&b2==1&&c1==1))
				{
					count=11;
					System.out.println("Player Won!!");
				}
				else if ((xa1==1&&xa2==1&&xa3==1)||(xb1==1&&xb2==1&&xb3==1)||(xc1==1&&xc2==1&&xc3==1)||(xa1==1&&xb1==1&&xc1==1)||(xa2==1&&xb2==1&&xc2==1)||(xa3==1&&xb3==1&&xc3==1)||(xa1==1&&xb2==1&&xc3==1)||(xa3==1&&xb2==1&&xc1==1))
				{
					count=11;
					System.out.println("Computer Won!!");
				}
				else if (count==10)
				{
					System.out.println("                  No winner, it is a Cat's game.");	
				}
			}
			System.out.println("                      Would you like to play Tic-Tac-Toe again?(Yes/No)");
			answer = kb.next();
		}while(answer.equalsIgnoreCase("yes"));

	}
}

