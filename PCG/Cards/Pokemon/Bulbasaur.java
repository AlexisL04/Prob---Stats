package PCG.Cards.Pokemon;

import java.util.HashMap;
import PCG.Cards.PokemonCard;

public class Bulbasaur extends PokemonCard {

    public Bulbasaur(){

        HashMap<String, Integer> requiredEnergy = new HashMap<>();
        requiredEnergy.put("Grass", 1);
        requiredEnergy.put("Normal", 2);

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

    public int vineWhip() {
        return getAttack();
    }
    
}
