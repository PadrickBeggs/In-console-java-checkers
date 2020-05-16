//The interface of the checker
public interface CheckerInterface {

	/**
	 * An interface for an object that simulates a checker
	 * 
	 * @author Padrick Beggs
	 */
	
	public void crown();
	/**
	 * Sets the piece as a king
	 * 
	 */
	
	
	public void setColor(String c);
	/**
	 * @param String c is to distinguish between the player's checkers.
	 */
	
	public String getColor();
	/**
	 * @return gets the color of the piece
	 */
	
	public boolean getKing();
	/**
	 * @return it gets a boolean expression of it is a king or not.
	 */
	
}// end of CheckerInterface
