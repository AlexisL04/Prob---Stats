/*
 * Author: Alexis Lopez
 * The EnergyCard class contains methods and variables needed to create an energy card.
 * This class is a child of the Card class.
 */
package PCG.Cards;

public class EnergyCard extends Card 
{
    
    // All the variables needed to create an energy card
    String type;
    String energyType;

    /*
     * Constructor for the EnergyCard class, initializes the card type to "Energy"
     * @param none
     * @return none
     */
    public EnergyCard() 
    {
        super.setCardType ("Energy");
    }

    /*
     * Gets the type of energy
     * @param none
     * @return the type of energy as a String
     */
    public String getEnergyType() 
    {
        return energyType;
    }

    /*
     * Sets the type of energy
     * @param energyType the type of energy we want to set as a String
     * @return none
     */
    public void setEnergyType( String energyType ) 
    {
        this.energyType = energyType;
    }

}
