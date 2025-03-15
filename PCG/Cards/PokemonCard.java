/*
 * Author: Alexis Lopez
 * This class is a child of the Card class and implements the PokemonCardInterface
 * The PokemonCard class contains methods and variables needed to create a Pokemon card such as HP, attack, type, and name.
 * The class also contains methods to add energy to the card, and find the weakness, resistance, and retreat cost of the card.
 */
package PCG.Cards;

import java.util.ArrayList;
import java.util.HashMap;

public class PokemonCard extends Card implements PokemonCardInterface 
{
    
    // All the variables needed to create a pokemon card
    private String name;
    private String type;
    private int hp;
    
    private String atkName;
    private String atkDesc;
    private HashMap<String,Integer> requiredEnergy;
    private String atkType;
    private int attack;
    private ArrayList<EnergyCard> attatchedEnergy;

    private String weakness;
    private String resistance;
    private HashMap<String, Integer> retreatCost;

    /*
     * Constructor for the PokemonCard class, initializes the card type to "Pokemon" as well as creating arraylists and hashmaps for itself
     * @param none
     * @return none
     */
    public PokemonCard() 
    {

        super.setCardType("Pokemon");
        attatchedEnergy = new ArrayList<>();
        requiredEnergy = new HashMap<>();

    }

    /*
     * Gets the name of the pokemon
     * @param none
     * @return the name of the pokemon as a string
     */
    public String getName()
    {
        return name;
    }

    /*
     * Gets the type of pokemon
     * @param none
     * @return the type of the pokemon as a string
     */
    public String getType()
    {
        return type;
    }

    /*
     * Gets the HP of the pokemon
     * @param none
     * @return the HP of the pokemon as an int
     */
    public int getHP()
    {
        return hp;
    }

    /*
     * Gets the type of attack
     * @param none
     * @return the attack type as a string
     */
    public String getAtkType()
    {
        return atkType;
    }

    /*
     * Gets the attack amount of the pokemon
     * @param none
     * @return the attack damage as an int
     */
    public int getAttack()
    {
        return attack;
    }

    /*
     * Gets the weakness of the pokemon
     * @param none
     * @return the weakness of the pokemon as a string
     */
    public String getWeakness()
    {
        return weakness;
    }

    /*
     * Gets the resistance of the pokemon
     * @param none
     * @return the resistance of the pokemon in a String
     */
    public String getResistance()
    {
        return resistance;
    }

    /*
     * Gets the retreat cost of the pokemon
     * @param none
     * @return the retreat cost of the pokemon as a hashmap
     */
    public HashMap<String, Integer> getRetreatCost()
    {
        return retreatCost;
    }

    /*
     * Gets the name of the attack
     * @param none
     * @return the name of the attack as a string
     */
    public String getAtkName()
    {
        return atkName;
    }

    /*
     * Gets the description of the attack
     * @param none
     * @return the description of the attack as a string
     */
    public String getAtkDesc()
    {
        return atkDesc;
    }

    /*
     * Gets the required energy of the pokemon
     * @param none
     * @return the required energy of the pokemon as a hashmap
     */
    public HashMap<String, Integer> getRequiredEnergy()
    {
        return requiredEnergy;
    }

    /*
     * Gets the attached energy of the pokemon
     * @param none
     * @return the attached energy of the pokemon as an arraylist of EnergyCards
     */
    public ArrayList<EnergyCard> getAttatchedEnergy()
    {
        return attatchedEnergy;
    }

    /*
     * Sets the name of the pokemon
     * @param name the name we want to set as a string
     * @return none
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /*
     * Sets the type of pokemon
     * @param type The type we want to set as a String
     * @return none
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /*
     * Sets the HP of the pokemon
     * @param hp the HP we want to set as an int
     * @return none
     */
    public void setHP(int hp){
        this.hp = hp;
    }

    /*
     * Sets the type of attack
     * @param atkType the type of attack we want to set as a String
     * @return none
     */
    public void setAtkType(String atkType)
    {
        this.atkType = atkType;
    }

    /*
     * Sets the attack amount of the pokemon
     * @param attack the attack amount we want to set as an int
     * @return none
     */
    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    /*
     * Sets the weakness of the pokemon
     * @param weakness the weakness we want to set as a String
     * @return none
     */
    public void setWeakness(String weakness)
    {
        this.weakness = weakness;
    }

    /*
     * Sets the resistance of the pokemon
     * @param resistance the resistance we want to set as a String
     * @return none
     */
    public void setResistance(String resistance)
    {
        this.resistance = resistance;
    }

    /*
     * Sets the retreat cost of the pokemon
     * @param retreatCost the retreat cost we want to set as a hashmap
     * @return none
     */
    public void setRetreatCost(HashMap<String, Integer> retreatCost)
    {
        this.retreatCost = retreatCost;
    }

    /*
     * Sets the name of the attack
     * @param atkName the name we want to set as a String
     * @return none
     */
    public void setAtkName(String atkName)
    {
        this.atkName = atkName;
    }

    /*
     * Sets the description of the attack
     * @param atkDesc the description we want to set as a String
     * @return none
     */
    public void setAtkDesc(String atkDesc)
    {
        this.atkDesc = atkDesc;
    }

    /*
     * Sets the required energy of the pokemon
     * @param requiredEnergy the required energy we want to set as a hashmap
     * @return none
     */
    public void setRequiredEnergy(HashMap<String, Integer> requiredEnergy)
    {
        this.requiredEnergy = requiredEnergy;
    }

    /*
     * Allows us to add energy to the pokemon
     * @param energy the energy we want to add as a Card
     * @return none
     */
    public void addEnergy(Card energy) 
    {
        attatchedEnergy.add((EnergyCard)energy);
    }

}
