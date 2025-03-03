package PCG.Cards;

import java.util.ArrayList;

import PCG.GameMechanics.PlayerMechanics;

public abstract class TrainerCard extends Card {

    private String description;
    private String name;

    public TrainerCard() {
        setCardType("trainer");
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }
   

    public void setDescription( String description ){
        this.description = description;
    }

    public void setName( String name ){
        this.name = name;
    }

    public abstract ArrayList<Card> cardEffect(PlayerMechanics player);


}
