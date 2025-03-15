/*
 * Author: Alexis Lopez
 * The PokemonCardInterface class contains the required methods needed in order to create a Pokemon Card
 */
package PCG.Cards;

import java.util.ArrayList;
import java.util.HashMap;


public interface PokemonCardInterface 
{
    
    public String getName();
    public String getType();
    public int getHP();
    public String getAtkType();
    public int getAttack();
    public String getWeakness();
    public String getResistance();
    public HashMap<String, Integer> getRequiredEnergy();
    public HashMap<String, Integer> getRetreatCost();
    public String getAtkName();
    public String getAtkDesc();
    public ArrayList<EnergyCard> getAttatchedEnergy();
        
    public void setName(String name);
    public void setType(String type);
    public void setHP(int hp);
    public void setAtkType(String atkType);
    public void setAttack(int attack);
    public void setWeakness(String weakness);
    public void setResistance(String resistance);
    public void setRequiredEnergy(HashMap<String, Integer> requiredEnergy);
    public void setRetreatCost(HashMap<String, Integer> retreatCost);
    public void setAtkName(String atkName);
    public void setAtkDesc(String atkDesc);
    public void addEnergy(Card energy);

}
