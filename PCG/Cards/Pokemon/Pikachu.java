package PCG.Cards.Pokemon;

import PCG.Cards.PokemonCard;
import java.util.HashMap;

public class Pikachu extends PokemonCard {

    public Pikachu() {

        HashMap<String, Integer> requiredEnergy = new HashMap<>();
        requiredEnergy.put("Electric", 1);

        HashMap<String, Integer> retreatCost = new HashMap<>();
        requiredEnergy.put("Normal", 1);

        setName("Pikachu");
        setType("Lightning");

        setHP(60);

        setAtkName("Iron Tail");
        setAtkDesc("Flip a coin until you get tails. This attack does 20 damage for each heads.");
        setRequiredEnergy(requiredEnergy);
        setAtkType("Lightning");
        setAttack(20);


        setWeakness("Fighting");
        setResistance("Steel");

        setRetreatCost(retreatCost);
    }



    public int ironTail() {

        int damage = 0;

        while( Math.random() != 1) {
            damage += 20;
        }

        return damage;
    }
    
}
