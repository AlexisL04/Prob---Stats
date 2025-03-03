package PCG.Cards;

public class Card {

    String cardType;
    
    public Card(){
        cardType = "";
    }

    public String getCardType()
    {
        return cardType;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

    public String getCardName(Card card)
    {

        if (card instanceof PokemonCard) 
        {
            return ((PokemonCard) card).getName();
        } 
        
        else if (card instanceof EnergyCard) 
        {
            return ((EnergyCard) card).getEnergyType();
        } 
        
        else if (card instanceof TrainerCard) 
        {
            return ((TrainerCard) card).getName();
        }
        return null;
    }


}
