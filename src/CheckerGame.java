import java.util.*;
//The class where the main executes and the game is run.
public class CheckerGame {

	
	//instantiates the gameboard object, scoreboard object, the scanner object, and lists for the red and black pieces. 
			public static ScoreBoard B;
			public static GameBoard board = new GameBoard();
			public static ArrayList redL = new ArrayList();
			public static ArrayList blackL = new ArrayList();
			public static Scanner keyBoard = new Scanner(System.in);
	
	
	//This is the main method that will run the game.
	public static void main(String[] args) {
		
		//The default boolean is false for playing again.
		boolean again = false; 
		
		
		//fills the red and black lists with checker objects.
		for(int i = 0; i < 12; i++)
		{
			redL.add(new Checker("r"));
			blackL.add(new Checker("b"));
		}
		//Calls method to roll the intro of the game.
		intro();
		do
		{
			//again is a boolean variable that if true runs the game again. The run method returns a boolean.
			again = run();
			
		}while(again == true);
		
	}
	
	
	
	//Runs the game. If it returns true then they want to play again if it returns false then the code ends
	public static boolean run()
	{
		//declares all variables needed for the run method
		String again = "";
		//clears the board of extra pieces
		board.clear();
		
		setBoard();
		
		board.display();
		
		int turncount = 0;
		int tempX = 0;
		int tempY = 0;
		int tempH = 0;
		int tempV = 0;
		boolean goAgain = false;
		//Runs the game until someone wins 
		while((B.getScore(0) != 12) &&( B.getScore(1) != 12))
		{
			//switches every turn from odd to even. 
			if( turncount%2 == 0)
			{
				//this do while loop is here to let a player go again if they capture the others piece
				do 
				{
					//prompts the user to give the position of the piece. 
					System.out.println("It is "+ B.getName(1) + "'s turn. Enter x of postion: ");
					tempX = keyBoard.nextInt();
					//if the input is invalid then t loops through the question once more.
					while((tempX <= -1) || (tempX >= 8))
					{
						System.out.println("Enter x of postion: ");
						tempX = keyBoard.nextInt();
					}
					keyBoard.nextLine();
					System.out.println("Enter y of postion: ");
					tempY = keyBoard.nextInt();
					while((tempY <= -1) || (tempY >= 8))
					{
						System.out.println("Enter y of postion: ");
						tempY = keyBoard.nextInt();
					}
					
					keyBoard.nextLine();
					//if the user inputs a bad value it lets them go again.
					if(board.getPiece(tempX, tempY)== null)
					{
						goAgain = true;
					}
					else
					{
						if(board.getPiece(tempX, tempY).getKing() == false)
						{
							System.out.println("Enter the displacement vector: ");
							tempH = keyBoard.nextInt();
							
							//this while loop is the ensure good input for the vectors
							while(((tempH + tempX) == -1) || ((tempH + tempX) == 8))
							{
								System.out.println("Enter the displacement vector: ");
								
								tempH = keyBoard.nextInt();
							}
							goAgain = moveC(tempX, tempY, tempH, 1);
							
						}
						else
						{
							System.out.println("Enter the x component displacement vector: ");
							tempH = keyBoard.nextInt();
							keyBoard.nextLine();
							
							//this while loop is the ensure good input for the vectors
							while(((tempH + tempX) == -1) || ((tempH + tempX) == 8))
							{
								System.out.println("Enter the x component displacement vector: ");
								tempH = keyBoard.nextInt();
								keyBoard.nextLine();
							}
							System.out.println("Enter the y component displacement vector: ");
							tempV = keyBoard.nextInt();
							goAgain = moveC(tempX, tempY, tempH, tempV);
							
							//this while loop is the ensure good input for the vectors
							while(((tempY + tempV) == -1) || ((tempY + tempV) == 8))
							{
							System.out.println("Enter the y component displacement vector: ");
							tempV = keyBoard.nextInt();
							goAgain = moveC(tempX, tempY, tempH, tempV);
							}
						}
					}
					//displays the updated board.
					board.display();
				}while(goAgain == true);
					
			}
			else
			{
				
					do 
					{
						//prompts the user to give the position of the piece. 
						System.out.println("It is "+ B.getName(0) + "'s turn. Enter x of postion: ");
						tempX = keyBoard.nextInt();
						keyBoard.nextLine();
						System.out.println("Enter y of postion: ");
						tempY = keyBoard.nextInt();
						
						keyBoard.nextLine();
						
						//if the user inputs a bad value it lets them go again.
						if(board.getPiece(tempX, tempY)== null)
						{
							goAgain = true;
						}
						else
							{
							if(board.getPiece(tempX, tempY).getKing() == false)
							{
								
								System.out.println("Enter the displacement vector: ");
								
								tempH = keyBoard.nextInt();
								
								//this while loop is the ensure good input for the vectors
								while(((tempH + tempX) == -1) || ((tempH + tempX) == 8))
								{
									System.out.println("Enter the displacement vector: ");
									
									tempH = keyBoard.nextInt();
								}
								goAgain = moveC(tempX, tempY, tempH, -1);
								
							}
							else
							{
								System.out.println("Enter the x component displacement vector: ");
								tempH = keyBoard.nextInt();
								keyBoard.nextLine();
								
								//this while loop is the ensure good input for the vectors
								while(((tempH + tempX) == -1) || ((tempH + tempX) == 8))
								{
									System.out.println("Enter the x component displacement vector: ");
									tempH = keyBoard.nextInt();
									keyBoard.nextLine();
								}
								System.out.println("Enter the y component displacement vector: ");
								tempV = keyBoard.nextInt();
								goAgain = moveC(tempX, tempY, tempH, tempV);
								
								//this while loop is the ensure good input for the vectors
								while(((tempY + tempV) == -1) || ((tempY + tempV) == 8))
								{
									System.out.println("Enter the y component displacement vector: ");
									tempV = keyBoard.nextInt();
									goAgain = moveC(tempX, tempY, tempH, tempV);
								}
							}
						}
						//displays the updated board
						board.display();
					}while(goAgain == true);
					
				}
			//increments the turn count to change the number to even if odd and odd if even
			turncount++;
			}
			
		//if player 2 wins 
		if(B.getScore(1) == 12)
		{
			System.out.println( B.getName(1) + " wins!!");
		}
		//if player 1 wins
		else
		{
			System.out.println( B.getName(0) + " wins.");
		}
			System.out.println("would you like to play again? Answer Yes or No:  ");
			keyBoard.nextLine();
			again = keyBoard.nextLine();
			
			//if the player responds yes or anything with a yes the game will restart. 
		if(again.contains("y") || again.contains("Y"))
		{
			B.setScore(0, 0);
			B.setScore(0, 1);
			return true;
		}
		else
		{
			return false; 
		}
		
	}
	
	
	//prints the intro of the game and gives player 1 and 2 names.
	public static void intro()
	{
		String p1 = "";
		String p2 = "";
		
		//asks for the players names
		System.out.println("Welcome to Checkers player 2!");
		System.out.println("Please enter the name of player 1: ");
		p1 = keyBoard.nextLine();
		
		System.out.println("hi " + p1);
		System.out.println("What's your name player 2?");
		p2 = keyBoard.nextLine();
		
		System.out.println("\n" + p2 + " is a great name! I am gonna let you go first instead " + p2+"\n");
		
		//plants the players into the score board object
		B = new ScoreBoard(p1, p2);
		//prints out all of the rules
		System.out.println("This is text based checkers, as most people can assume the best type of checkers."
				+ "\nThis is how to control the checkers: \n\nNormal checkers are given 2 movement options: left (-1) and right (1)\n\n"
				+ "Kinged checkers are given 4 movement options: left(-1) and down/up(-1 or 1) or right(1) and down/up(-1 or 1)\n\n"
				+ "So when the game tells you it is your turn, it will take from the user a position on the board and how you would\n"
				+ "like to move the piece. Given in this format. First, postion: x,y then, the displacement vector of the piece. \n"
				+ "for normal pieces: -1 or 1, for kings, its -1 or 1 then -1 or 1.\n"
				+ "Player 1 is in control of red checkers while Player 2 is in control of black checkers. That is all so lets start!\n\n\n");
	}
	
	//This method sets the gameBoard up for a game of checkers
	public static void setBoard()
	{
		int k = 0;
		//this for loop is to set the red piece on top of the board in the arrangement of classic checkers 
		
		
		for(int j = 0; j < 3; j++)
		{
			for(int i = 0; i < 8; i+=2)
			{
				board.addPiece(redL.get(k), i +j%2, j);
				k++;
			}
		}
		k=0;
		//this for loop sets the black pieces on the bottom of the board in the arrangement of classic checkers
		for(int j = 5; j < 8; j++)
		{
			for(int i = 0; i < 8; i+=2)
			{
				board.addPiece(blackL.get(k), i +j%2, j);
				k++;
			}
		}
		k=0;
	}
	
	//This method checks to see if the pieces are on the opposite side of the board from where they started from
	//If so it makes the piece a king
	public static void checkKing(int x, int y)
	{
		if(board.getPiece(x, y).getColor().equals("b")&& y==0)
		{
			board.getPiece(x, y).crown();
		}
		else if(board.getPiece(x, y).getColor().equals("r")&& y==7)
		{
			board.getPiece(x, y).crown();
		}
		
	}
	
	
	//The method to move the piece
	public static boolean moveC(int x, int y, int h, int v)
	{
		//makes h and v unit vectors to insure no foul play is done.
		h = h/Math.abs(h);
		v = v/Math.abs(v);
		
		
		//This line of if statements are incharge of all the possible interactions a checker may have with the square it
		//will be moving to. From simple movement to what a king will do if there is a opposing checker in its way. 
		
	
		//for non-king red pieces to move into a open space.
		if((board.getPiece(x, y)).getColor().equals("r") && (board.getPiece(x+h, y+1) == null))
		{
			board.move(x, y, h, 1);
			checkKing(x+h,y+1);
			return false;
		}
		//for non-king red pieces to take a non-king black piece
		else if((board.getPiece(x, y)).getColor().equals("r") &&(board.getPiece(x+h, y+1)).getColor().equals("b")&& (board.getPiece(x+(2*h), y+(2*1)) == null))
		{
			board.move(x,y, (2*h),2);
			board.removePiece(x+h, y+1);
			checkKing(x+(2*h),y+2);
			B.addScore(1, 0);
			return true;
		}
		//for non-king red pieces to take a king black piece
		else if((board.getPiece(x, y)).getColor().equals("r") &&(board.getPiece(x+h, y+1)).getColor().equals("B")&& (board.getPiece(x+(2*h), y+(2*1)) == null))
		{
			board.move(x,y, (2*h),2);
			board.removePiece(x+h, y+2);
			checkKing(x+(2*h),y+2);
			B.addScore(1, 0);
			return true;
		}
		//for a non-king black piece to move to an open space
		else if((board.getPiece(x, y)).getColor().equals("b") && (board.getPiece(x+h, y-1) == null))
		{
			board.move(x, y, h, -1);
			checkKing(x+h,y-1);
			return false;
		}
		//for a non-king black piece to take a non-king red piece
		else if((board.getPiece(x, y)).getColor().equals("b") &&(board.getPiece(x+h, y-1)).getColor().equals("r")&& (board.getPiece(x+(2*h), y+(2*-1)) == null))
		{
			board.move(x,y, (2*h),-2);
			board.removePiece(x+h, y-1);
			checkKing(x+(2*h),y-2);
			B.addScore(1, 1);
			return true;
		}
		//for a non-king black piece to take a king red piece
		else if((board.getPiece(x, y)).getColor().equals("b") &&(board.getPiece(x+h, y-1)).getColor().equals("R")&& (board.getPiece(x+(2*h), y+(2*-1)) == null))
		{
			board.move(x,y, (2*h),-2);
			board.removePiece(x+h, y-1);
			checkKing(x+(2*h),y-2);
			B.addScore(1, 1);
			return true;
		}
		//for a king red piece to move to an open space
		else if((board.getPiece(x, y)).getColor().equals("R") && (board.getPiece(x+h, y+v) == null))
		{
			board.move(x, y, h, v);
			return false;
		}
		//for a king black piece to move to an open space
		else if((board.getPiece(x, y)).getColor().equals("B") && (board.getPiece(x+h, y+v) == null))
		{
			board.move(x, y, h, v);
			return false;
		}
		//for a king red piece to take a non-king black piece off the board
		else if((board.getPiece(x, y)).getColor().equals("R") &&(board.getPiece(x+h, y+v)).getColor().equals("b")&& (board.getPiece(x+(2*h), y+(2*v)) == null))
		{
			board.move(x,y, (2*h),(2*v));
			board.removePiece(x+h, y+v);
			checkKing(x+(2*h),y+(2*v));
			B.addScore(1, 0);
			return true;
		}
		//for a king red piece to take a king black piece out
		else if((board.getPiece(x, y)).getColor().equals("R") &&(board.getPiece(x+h, y+v)).getColor().equals("B")&& (board.getPiece(x+(2*h), y+(2*v)) == null))
		{
			board.move(x,y, (2*h),(2*v));
			board.removePiece(x+h, y+v);
			checkKing(x+(2*h),y+(2*v));
			B.addScore(1, 0);
			return true;
		}
		//for a king black piece to take a non-king red piece out
		else if((board.getPiece(x, y)).getColor().equals("B") &&(board.getPiece(x+h, y+v)).getColor().equals("r")&& (board.getPiece(x+(2*h), y+(2*v)) == null))
		{
			board.move(x,y, (2*h),(2*v));
			board.removePiece(x+h, y+v);
			checkKing(x+(2*h),y+(2*v));
			B.addScore(1, 1);
			return true;
		}
		//for a king black piece to take a king red piece out
		else if((board.getPiece(x, y)).getColor().equals("B") &&(board.getPiece(x+h, y+v)).getColor().equals("R")&& (board.getPiece(x+(2*h), y+(2*v)) == null))
		{
			board.move(x,y, (2*h),(2*v));
			board.removePiece(x+h, y+v);
			checkKing(x+(2*h),y+(2*v));
			B.addScore(1, 1);
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
}
