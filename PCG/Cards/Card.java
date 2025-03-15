/*
 * Author: Alexis Lopez
 * The Card class contains methods and variables needed to create a card object which will be used for all of the required cards 
 * needed to play the game. (Pokemon, Energy, and Trainer)
 * The class contains methods to get and set the card type, and get the name of the card.
 * The class also contains a method to get the name of the card based on the type of card it is.
 */

package PCG.Cards;

public class Card 
{

    // The type of card (Pokemon, Energy, Trainer)
    String cardType;
    
    /*
     * Constructor for the Card class, initializes the cardType to an empty string
     * @param none
     * @return void
     */
    public Card()
    {
        cardType = "";
    }

    /*
     * Gets the type of card
     * @param none
     * @return the type of card as a string
     */
    public String getCardType()
    {
        return cardType;
    }

    /*
     * Sets the type of card
     * @param cardType the type of card we want to set as a string
     * @return void
     */
    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

    /*
     * Gets the name of the card based on the type of card it is
     * @param card the card we want to get the name of
     * @return the name of the card
     */
    public String getCardName(Card card)
    {

        // If the card is a PokemonCard, return the name of the Pokemon
        if (card instanceof PokemonCard) 
        {
            return ((PokemonCard) card).getName();
        } 
        
        // If the card is an EnergyCard, return the type of energy
        else if (card instanceof EnergyCard) 
        {
            return ((EnergyCard) card).getEnergyType();
        } 
        
        // If the card is a TrainerCard, return the name of the trainer
        else if (card instanceof TrainerCard) 
        {
            return ((TrainerCard) card).getName();
        }

        // If the card is none of the above, return null
        return null;
    }


}
