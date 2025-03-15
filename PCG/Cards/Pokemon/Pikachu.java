/*
 * Author: Alexis Lopez
 * This class is a child of the PokemonCard class and contains methods and variables needed to create a Pikachu card.
 */

package PCG.Cards.Pokemon;

import PCG.Cards.PokemonCard;
import java.util.HashMap;

public class Pikachu extends PokemonCard {

    /*
     * Constructor for the Pikachu class, initializes all the information needed for a pokemon card
     * @param none
     * @return none
     */
    public Pikachu() 
    {

        //Creates a hashmap and sets the required energy
        HashMap<String, Integer> requiredEnergy = new HashMap<>();
        requiredEnergy.put("Electric", 1);

        //Creates a hashmap and sets the retreat cost
        HashMap<String, Integer> retreatCost = new HashMap<>();
        requiredEnergy.put("Normal", 1);

        setName("Pikachu");
        setType("Lightning");

        setHP(60);

        setAtkName("Iron Tail");
        setAtkDesc("Does 30 damage to the opponent's active Pokemon");
        setRequiredEnergy(requiredEnergy);
        setAtkType("Lightning");
        setAttack(30);


        setWeakness("Fighting");
        setResistance("Steel");

        setRetreatCost(retreatCost);
    }
    
}
