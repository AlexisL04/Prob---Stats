package PCG.Cards.Pokemon;

import java.util.HashMap;
import PCG.Cards.PokemonCard;

public class Charmander extends PokemonCard {
    
    public Charmander() {

        HashMap<String, Integer> requiredEnergy = new HashMap<>();
        requiredEnergy.put("Fire", 1);

        HashMap<String, Integer> retreatCost = new HashMap<>();
        requiredEnergy.put("Normal", 1);

        setName("Charmander");
        setType("Fire");
        
        setHP(60);
        
        setAtkName("Heat Tackle");
        setAtkDesc("Does 30 damage to the opponent's active Pokemon, does 10 damage to itself");
        setRequiredEnergy(requiredEnergy);
        setAtkType("Fire");
        setAttack(30);
        
        setWeakness("Water");
        setResistance("None");
        
        setRetreatCost(retreatCost);
    }

    public int heatTackle() {
        setHP(getHP() - 10);
        return getAttack();
    }

}
