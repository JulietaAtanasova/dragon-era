package dragons.years;

public class Year {
    private int eggFactor;
    
    public Year(int eggFactor){
        this.setEggFactor(eggFactor);
    }

    public int getEggFactor() {
        return this.eggFactor;
    }

    private void setEggFactor(int eggFactor) {
        this.eggFactor = eggFactor;
    }
}
