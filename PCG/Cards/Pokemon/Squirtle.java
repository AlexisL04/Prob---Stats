package PCG.Cards.Pokemon;

import PCG.Cards.PokemonCard;
import java.util.HashMap;

public class Squirtle extends PokemonCard {
    

    public Squirtle(){
        
        HashMap<String, Integer> requiredEnergy = new HashMap<>();
        requiredEnergy.put("Water", 1);

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
    
    public int waterGun() {
        return getAttack();
    }

}
