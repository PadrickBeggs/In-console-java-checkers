# In-console-java-checkers


The goal of my project is to simulate a game of checkers in the eclipse environment. All input 
and output will be through the console using a scanner object, the game will prompt you for your 
name then it will ask you for the location of the checker you would like to move, then the 
displacement vector. I will do this by creating a board data type that will be in charge of storing 
the checkers in a nested array inside of the board. The board will be able to display the objects on 
the board; clear the entire board; add/remove individual pieces to the board; and will be able to 
select a piece on the board, then move it according to a vector relative to the board. Using these 
methods, the checkers will be able to move. The scoreboard data type will be able to 
store/manipulate the scores of the players involved. It will also be able to clear the score and get 
the current score. I will also be using the list data type to keep store the checkers and seperate the 
checkers with respect to the players involved. The main method of the game will take the list of 
checkers and place them on the board in the checkers default arrangement. The checker will be 
the object to place in the board data type. It will have a method to change the movement of the 
object when it reaches the other side of the board kinging it, it will be displayed as a capital letter 
instead of a lower case letter. There will be a seperate method to run the game so it can be looped 
if the player wanted to play again. It will also have a method completely incharge of all the 
interactions between the types of pieces. Each time a checker will move to will call the check 
king method that will check if the checker is on a square that can turn the boolean value of king 
to true. All these methods working in tandem will create an awesome game of checkers.
 
 
 
 
