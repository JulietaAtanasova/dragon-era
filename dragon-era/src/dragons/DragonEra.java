package dragons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import dragons.years.DragonYear;

public class DragonEra {
    private List<DragonYear> dragonYears;
    private List<Dragon> dragons;
    private List<Egg> eggs;

    public DragonEra() {
        this.setDragonYears(new ArrayList<DragonYear>());
        this.setDragons(new ArrayList<Dragon>());
        this.setEggs(new ArrayList<Egg>());
    }

    public List<DragonYear> getDragonYears() {
        return this.dragonYears;
    }

    private void setDragonYears(List<DragonYear> dragonYears) {
        this.dragonYears = dragonYears;
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

    public void pass() {
        for (DragonYear year : this.getDragonYears()) {
            for (Dragon dragon : dragons) {
                dragon.grow();
                if (dragon.getAge() >= Dragon.START_LAY_EGGS_AGE && dragon.getAge() < Dragon.STOP_LAY_EGGS_AGE) {
                    dragon.setLayEggs(true);
                }
            }

            for (Egg egg : this.getEggs()) {
                egg.grow();
            }
            
            hatchEggs(year.getEggFactor());

            for (Dragon dragon : dragons) {
                if (dragon.canLayEggs()) {
                    Egg newEgg = new Egg(dragon);
                    dragon.layEgg(newEgg);
                    this.getEggs().add(newEgg);
                }
            }

        }

    }

    private void hatchEggs(int eggFactor) {
        List<Egg> hatchedEggs = new ArrayList<>();
        for (Egg egg : this.getEggs()) {
            if (egg.getAge() == Egg.MAX_AGE) {
                if (egg.getParent().isAlive()) {
                    hatchedEggs.add(egg);
                    for (int i = 0; i < eggFactor; i++) {
                        Dragon newDragon = egg.hatch();
                        egg.getParent().getChildren().add(newDragon);
                        this.getDragons().add(newDragon);
                    }
                }
            }
        }

        this.getEggs().removeAll(hatchedEggs);
    }

    @Override
    public String toString() {
        String result = "";
        List<Dragon> orphans = this.getDragons().stream().filter(d -> d.isOrphan() == true)
                .collect(Collectors.toList());
        List<Dragon> printedDragons = new ArrayList<Dragon>();
        for (Dragon dragon : orphans) {
            result += addDragonsAndChilds(dragon, 0, printedDragons);
        }

        result = result.substring(0, result.length() - 1);
        return result;
    }

    private String addDragonsAndChilds(Dragon dragon, int repeatTimes, List<Dragon> printedDragons) {
        String result = "";
        String prefix = "  ";
        if (printedDragons.contains(dragon)) {
            return result;
        }

        if (dragon.isAlive()) {
            result += String.join("", Collections.nCopies(repeatTimes, prefix));
            result += dragon + "\n";
            printedDragons.add(dragon);
        }

        repeatTimes++;
        for (Dragon child : dragon.getChildren()) {
            result += addDragonsAndChilds(child, repeatTimes, printedDragons);
        }

        return result;
    }
}
