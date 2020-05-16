


//This class defines the Checker used in the game. It implements the CheckerInterface
public class Checker implements CheckerInterface {
	//color holds a string 
	private String color= "";
	//holds a boolean value and if it is true it will unlock different movement options for the checker. 
	private boolean king = false; 
	
	//overloaded constructor that specifies color
	public Checker(String c)
	{
		setColor(c);
		
	}
	//crowns the selected piece as a king.
	public void crown()
	{
		king = true;
		color = color.toUpperCase();
	}
	
	
	//setColor sets the color of the checker. 
	public void setColor(String c)
	{
		if(c.equals("b")|| c.equals("r"))
		{
			color = c;
		}
	}
	
	//getColor returns the color of the checker.
	public String getColor()
	{
		return color; 
		
	}
	//when toString is called it gives the Color as the output so it comes out in the display. 
	public String toString()
	{
		
		return getColor();
	}
	//returns the boolean for king
	public boolean getKing()
	{
		return king;
	}
}
