/*
 * Author: Alexis Lopez
 * This class represents a Pokemon and its stats.
 */
package PokemonBattle;

public class Pokemon {
    
    // Instance variables for Pokemon
    private int hp;
    private int attack;
    private int defense;
    private int speed;

    //Getters and setters for pokemon
    public int getHp(){
        return hp;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public int getSpeed(){
        return speed;
    }

    public void setHp(int userHp){
        hp = userHp;
    }

    public void setAttack(int userAttack){
        attack = userAttack;
    }

    public void setDefense(int userDefense){
        defense = userDefense;
    }

    public void setSpeed(int userSpeed){
        speed = userSpeed;
    }

}

