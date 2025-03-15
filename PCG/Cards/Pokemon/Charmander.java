/*
 * Author: Alexis Lopez
 * This class is a child of the PokemonCard class and contains methods and variables needed to create a Charmander card.
 */

package PCG.Cards.Pokemon;

import java.util.HashMap;
import PCG.Cards.PokemonCard;

public class Charmander extends PokemonCard {
    
    public Charmander() {

        //Creates a hashmap and sets the required energy
        HashMap<String, Integer> requiredEnergy = new HashMap<>();
        requiredEnergy.put("Fire", 1);

        //Creates a hashmap and sets the retreat cost
        HashMap<String, Integer> retreatCost = new HashMap<>();
        requiredEnergy.put("Normal", 1);

        setName("Charmander");
        setType("Fire");
        
        setHP(60);
        
        setAtkName("Heat Tackle");
        setAtkDesc("Does 30 damage to the opponent's active Pokemon");
        setRequiredEnergy(requiredEnergy);
        setAtkType("Fire");
        setAttack(30);
        
        setWeakness("Water");
        setResistance("None");
        
        setRetreatCost(retreatCost);
    }


}
