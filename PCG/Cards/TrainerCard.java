/*
 * Author: Alexis Lopez
 * This class is a child of the Card class and contains methods and variables needed to create a trainer card.
 */

package PCG.Cards;

import java.util.ArrayList;
import PCG.GameMechanics.PlayerMechanics;

public abstract class TrainerCard extends Card 
{

    // All the variables needed to create a trainer card
    private String description;
    private String name;

    /*
     * Constructor for the TrainerCard class, initializes the card type to "Trainer"
     * @param none
     * @return none
     */
    public TrainerCard() 
    {
        setCardType("trainer");
    }

    /*
     * Gets the description of the trainer card
     * @param none
     * @return the description of the trainer card as a String
     */
    public String getDescription()
    {
        return description;
    }

    /*
     * Gets the name of the trainer card
     * @param none
     * @return the name of the trainer card as a String
     */
    public String getName()
    {
        return name;
    }
   
    /*
     * Sets the description of the trainer card
     * @param description the description we want to set as a String
     * @return none
     */
    public void setDescription( String description )
    {
        this.description = description;
    }

    /*
     * Sets the name of the trainer card
     * @param name the name we want to set as a String
     * @return none
     */
    public void setName( String name )
    {
        this.name = name;
    }

    /*
     * Abstract method that will be implemented in the child classes
     * @param player the player that is using the trainer card
     * @return an arraylist of cards that will be affected by the trainer card
     */
    public abstract ArrayList<Card> cardEffect(PlayerMechanics player);


}
