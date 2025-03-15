/*
 * Author: Alexis Lopez
 * This class is a child of the PokemonCard class and contains methods and variables needed to create a Bulbasaur card.
 */

package PCG.Cards.Pokemon;

import java.util.HashMap;
import PCG.Cards.PokemonCard;

public class Bulbasaur extends PokemonCard {

    public Bulbasaur(){

        //Creates a hashmap and sets the required energy
        HashMap<String, Integer> requiredEnergy = new HashMap<>();
        requiredEnergy.put("Grass", 1);
        requiredEnergy.put("Normal", 2);

        //Creates a hashmap and sets the retreat cost
        HashMap<String, Integer> retreatCost = new HashMap<>();
        requiredEnergy.put("Normal", 2);

        setName("Bulbasaur");
        setType("Grass");
        setHP(60);
        
        setAtkName("Vine Whip");
        setAtkDesc("Does 50 damage to the opponent's active Pokemon");
        setRequiredEnergy(requiredEnergy);
        setAtkType("Grass");
        setAttack(50);
        
        setWeakness("Fire");
        setResistance("None");
        
        setRetreatCost(retreatCost);
    }

    
}
