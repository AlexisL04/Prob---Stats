/*
 * Author: Alexis Lopez
 * The Door class contains methods and variables needed to simulate the doors in the Monty Hall game.
 * The class:
 * - Initializes the doors to 0, or a dud prize
 * - Sets the prize behind the doors
 * - Returns the prize behind the doors
 */

package MontyHall;

public class Door {
    
    private int doorPrize;

    /*
     * Constructor for the Door class, initializes the doorPrize to 0
     * @param none
     * @return void
     */
    public Door()
    {
        doorPrize = 0;
    }

    /*
     * Sets the prize behind the doors
     * @param prize the prize behind the door
     * @return void
     */
    public void setDoor( int prize)
    {
        doorPrize = prize;
    }

    /*
     * Returns the prize behind the door
     * @param doorNum the door number
     * @return the prize behind the door
     */
    public int getDoor(int doorNum)
    {
        return doorPrize;
    }

}
