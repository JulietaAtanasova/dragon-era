package dragons.years;

public class DragonYear {
    private int eggFactor;
    
    public DragonYear(int eggFactor){
        this.setEggFactor(eggFactor);
    }

    public int getEggFactor() {
        return this.eggFactor;
    }

    private void setEggFactor(int eggFactor) {
        this.eggFactor = eggFactor;
    }
}
