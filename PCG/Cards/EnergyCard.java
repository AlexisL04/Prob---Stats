package PCG.Cards;

public class EnergyCard extends Card {
    
    String type;
    String energyType;

    public EnergyCard() {
        setCardType ("Energy");
    }

    public String getEnergyType() {
        return energyType;
    }

    public void setEnergyType( String energyType ) {
        this.energyType = energyType;
    }

}
