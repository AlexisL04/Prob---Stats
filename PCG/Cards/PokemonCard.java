package PCG.Cards;

import java.util.ArrayList;
import java.util.HashMap;



public class PokemonCard extends Card {
    
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

    public PokemonCard() {

        setCardType("Pokemon");
        attatchedEnergy = new ArrayList<>();
        requiredEnergy = new HashMap<>();

    }


    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public int getHP(){
        return hp;
    }

    public String getAtkType(){
        return atkType;
    }

    public int getAttack(){
        return attack;
    }

    public String getWeakness(){
        return weakness;
    }

    public String getResistance(){
        return resistance;
    }

    public HashMap<String, Integer> getRetreatCost(){
        return retreatCost;
    }

    public String getAtkName(){
        return atkName;
    }

    public String getAtkDesc(){
        return atkDesc;
    }

    public HashMap<String, Integer> getRequiredEnergy(){
        return requiredEnergy;
    }

    public ArrayList<EnergyCard> getAttatchedEnergy(){
        return attatchedEnergy;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public void setAtkType(String atkType){
        this.atkType = atkType;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setWeakness(String weakness){
        this.weakness = weakness;
    }

    public void setResistance(String resistance){
        this.resistance = resistance;
    }

    public void setRetreatCost(HashMap<String, Integer> retreatCost){
        this.retreatCost = retreatCost;
    }

    public void setAtkName(String atkName){
        this.atkName = atkName;
    }

    public void setAtkDesc(String atkDesc){
        this.atkDesc = atkDesc;
    }

    public void setRequiredEnergy(HashMap<String, Integer> requiredEnergy){
        this.requiredEnergy = requiredEnergy;
    }

    public void addEnergy(Card energy) {
        attatchedEnergy.add((EnergyCard)energy);
    }

}
