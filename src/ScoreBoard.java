//This defines the ScoreBoard used in the CheckerGame
public class ScoreBoard {
	
		//playerArray is to hold the names of the players involved with the game.
		//scoreArray is to hold the values of the scores involved with the game.
		 private String[] playerArray = new String[2]; 
		 private int[] scoreArray = new int[2];
	
		 //The first name will be given to player 1 and the second name will be given to player 2.
		 public ScoreBoard(String name1, String name2)
		 {
			 setName(name1,0);
			 setName(name2,1);
		 }
		 
		 
		 
		//The setName method takes in a name and the player's number. Then, sets the name to the specified player. 
	public void setName(String name, int playerSlot)
	{
		if(playerSlot == 1 || playerSlot == 0)
		{
			playerArray[playerSlot] = name;
		}
	}
	
	
		//The setScore method takes in two numbers, the first being the score you want. 
		//The second being the player you want to apply this to
	public void setScore(int amount, int playerSlot)
	{
		scoreArray[playerSlot] = amount;
	}
	
	
	
	//Adds a number to a player specified by playerSlot
	public void addScore(int amount, int playerSlot)
	{
		scoreArray[playerSlot] += amount;
		System.out.println(playerArray[0]+" now has " + 
		scoreArray[0] + " and " +playerArray[1]+" now has " + scoreArray[1]);
	}
	
	//returns the name of the player you specify
	public String getName(int playerSlot)
	{
		return playerArray[playerSlot];
	}
	
	//returns the score of the player you specify
	public int getScore(int playerSlot)
	{
		return scoreArray[playerSlot];
	}
	
	
}
