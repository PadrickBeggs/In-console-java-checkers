

//This class defines the gameboard the checker game uses.
public class GameBoard {
		//this 2d array holds any object in an 8 by 8 table.
	 private Checker[][] board = new Checker[8][8];
	 //the running count of pieces on the board
	 private int pieceCount = 0; 
	
	
	//displays the board and all objects on it using their toString() method.
	public void display()
	{
		System.out.println("     0       1       2       3       4       5       6       7"+
				"\n _________________________________________________________________\n");
		for(int j = 0; j < 8; j++)
		{
			
		System.out.print(j+" |  ");
		for(int i = 0; i < 8; i++)
		{
			if(board[i][j] == null)
			{
				System.out.print(" "+ "   |   ");
			}
			else {
		System.out.print(board[i][j]+ "   |   ");
			}
		}
		System.out.println("\n _________________________________________________________________\n");
		}
		System.out.println("\n");
	}
	
	//takes in the location of piece (x,y) and moves it along the h (horizonal) and v(vertical)
	public boolean move(int x, int y, int h, int v)
	{
		if((board[x+h][y+v] == null) && (board[x][y] != null)&& ((x+h)<= 7)&&((y+v)<=7))
		{
		board[x+h][y+v] = board[x][y];
		board[x][y] = null;
		return true;
		}
		return false;
	}
	
	public void addPiece(Object Piece, int x, int y)
	{
		//adds a piece to the board at a specified location
		board[x][y] = (Checker) Piece;
		pieceCount ++;
	}
	
	public void removePiece(int x, int y)
	{
		//removes a piece from a specified location in the board
		if(board[x][y] != null)
		{
		board[x][y] = null;
		pieceCount --;
		}
	}
	
	
	public void clear()
	{
		//Clears the entire board of all pieces 
		for(int j = 0; j < 8; j++)
		{
			for(int i = 0; i < 8; i++)
			{
				board[i][j] = null;
			}
		}
		
		pieceCount = 0;
	}
	//returns the piece count
	public int getPieceCount()
	{
		return pieceCount;
	}
	//returns the checker you are looking for.
	public Checker getPiece(int x, int y)
	{
		
		return  board[x][y];
	}
}
