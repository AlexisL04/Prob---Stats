/*
 * Author: Alexis Lopez
 * The GoatGame class contains the methods and variables needed to simulate the Monty Hall game.
 * The class can:
 * - Shuffle the doors and assign a prize to one of them
 * - Simulate the game with the player not changing their choice after a door is revealed
 * - Simulate the game with the player changing their choice after a door is revealed
 * - Return the percentage of games won for each simulation
 */
package MontyHall;

import java.util.Random;

public class GoatGame {
    
    private Door[] doors;

    /*
     * Constructor for the GoatGame class, initializes the doors array
     * @param none
     * @return none
     */
    public GoatGame()
    {
        doors = new Door[3];
    }

    /*
     * Shuffles the doors and assigns a prize to one of them
     * @param none
     * @return the shuffled doors
     */
    public Door[] shuffleDoors()
    {
        
        //Creates a random number to determine which door the prize should be assigned to
        Random rand = new Random();
        int prizeDoor = rand.nextInt(3);
        
        //Assigns the prize to the door
        for(int i = 0; i < 3; i++)
        {
            
            //Creates a new door object
            doors[i] = new Door();
            
            // If the door number is equal to the randomly chosen number then it is the prize door
            if(i == prizeDoor)
            {
                doors[i].setDoor(1);
            } 
            
            // Otherwise it is a goat door
            else 
            {
                doors[i].setDoor(0);
            }

        }

        return doors;
    }

    /*
     * Simulates the game with the player not changing their choice after a door is revealed
     * @param numGames the number of games to simulate
     * @return the percentage of games won
     */
    public double noChange(double numGames)
    {
        
        double wins = 0;
        Random rand = new Random();

        //Simulates the game as many times as assigned in the parameter
        for(int i = 0; i < numGames; i++)
        {
            //Shuffles the doors
            doors = shuffleDoors();
            
            //Randomly chooses a door
            int chosenDoor = rand.nextInt(3);
            
            //If the chosen door has a prize then the player wins
            if(doors[chosenDoor].getDoor(chosenDoor) == 1)
            {
                wins++;
            }
        }
        
        //Calculates the percentage of wins
        double result = ( wins / numGames );

        //Returns the percentage of wins
        return result;
    }

    /*
     * Simulates the game with the player changing their choice after a door is revealed
     * @param numGames the number of games to simulate
     * @return the percentage of games won
     */
    public double withChange(double numGames)
    {
        double wins = 0;
        Random rand = new Random();
        
        //Simulates the game as many times as assigned in the parameter
        for(int i = 0; i < numGames; i++)
        {
            //Shuffles the doors
            doors = shuffleDoors();
            
            //Randomly chooses a door
            int chosenDoor = rand.nextInt(3);
            
            //initializes a variable we will use to determine which door to open
            int goatDoor = rand.nextInt(3);

            
            //Randomly chooses on a door that does not contain the prize or is the players chosen door
            while(goatDoor == chosenDoor || doors[goatDoor].getDoor(goatDoor) == 1)
            {
                goatDoor = rand.nextInt(3);
            }

            //Switches the previously chosen door to the other, unrevealed door
            int newDoor = 0;
            for(int j = 0; j < 3; j++)
            {
                if(j != chosenDoor && j != goatDoor)
                {
                    newDoor = j;
                }
            }

            //If the new door has a prize then the player wins
            if(doors[newDoor].getDoor(newDoor) == 1)
            {
                wins++;
            }


        }
        
        //Calculates the percentage of wins
        double result = ( wins/ numGames );

        //returns the percentage of wins
        return result;
    }

}
