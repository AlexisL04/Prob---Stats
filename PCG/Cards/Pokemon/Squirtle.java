/*
 * Author: Alexis Lopez
 * This class is a child of the PokemonCard class and contains methods and variables needed to create a Squirtle card.
 */
package PCG.Cards.Pokemon;

import PCG.Cards.PokemonCard;
import java.util.HashMap;

public class Squirtle extends PokemonCard 
{
    
    /*
     * Constructor for the Squirtle class, initializes all the information needed for a pokemon card
     * @param none
     * @return none
     */
    public Squirtle()
    {
        
        //Creates a hashmap and sets the required energy
        HashMap<String, Integer> requiredEnergy = new HashMap<>();
        requiredEnergy.put("Water", 1);

        //Creates a hashmap and sets the retreat cost
        HashMap<String, Integer> retreatCost = new HashMap<>();
        requiredEnergy.put("Normal", 1);

        setName("Squirtle");
        setType("Water");
        
        setHP(70);
        
        setAtkName("Water gun");
        setAtkDesc("Does 20 damage to the opponent's active Pokemon");
        setRequiredEnergy(requiredEnergy);
        setAtkType("Water");
        setAttack(20);
        
        setWeakness("Lightning");
        setResistance("None");
        
        setRetreatCost(retreatCost);
    }
    
}
