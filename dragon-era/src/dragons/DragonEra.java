package dragons;

import java.util.ArrayList;
import java.util.List;

import dragons.years.Year;

public class DragonEra {
    private List<Year> years;
    private List<Dragon> dragons;
    private List<Egg> eggs;

    public DragonEra(){
        this.setYears(new ArrayList<Year>());
        this.setDragons(new ArrayList<Dragon>());
        this.setEggs(new ArrayList<Egg>());
    }
    
    public List<Year> getYears() {
        return years;
    }

    private void setYears(List<Year> years) {
        this.years = years;
    }
    
    public List<Dragon> getDragons() {
        return this.dragons;
    }
    
    private void setDragons(List<Dragon> dragons) {
       this.dragons = dragons;
    }

    public List<Egg> getEggs() {
        return this.eggs;
    }

    public void setEggs(List<Egg> eggs) {
        this.eggs = eggs;
    }

    public void pass(){
        
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Dragon dragon : this.getDragons()) {
            result.append(dragon);
        }
        return result.toString();
    }
}
