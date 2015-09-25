package dragons;

import java.util.ArrayList;
import java.util.List;

public class Dragon {
    public static final int MAX_AGE = 6;
    public static final int START_LAY_EGGS_AGE = 3;
    public static final int STOP_LAY_EGGS_AGE = 5;

    private static int instanceCounter = 0;
    private int id;
    private int age;
    private boolean alive;
    private List<Egg> eggs;
    private List<Dragon> children;

    public Dragon() {
        instanceCounter++;
        this.setId(instanceCounter);
        this.setAge(0);
        this.setAlive(true);
        this.setEggs(new ArrayList<Egg>());
        this.setChildren(new ArrayList<Dragon>());
    }

    public int getId() {
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public List<Egg> getEggs() {
        return this.eggs;
    }

    private void setEggs(List<Egg> eggs) {
        this.eggs = eggs;
    }

    public List<Dragon> getChildren() {
        return this.children;
    }

    private void setChildren(List<Dragon> children) {
        this.children = children;
    }

    public boolean isAlive() {
        return this.alive;
    }

    private void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void layEgg() {
        if (this.age >= START_LAY_EGGS_AGE || this.age < STOP_LAY_EGGS_AGE) {
            this.getEggs().add(new Egg(this));
        }
    }

    public void die() {
        this.setAlive(false);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Dragon_%s\n", this.getId()));
        if(!this.getChildren().isEmpty()){
            for (Dragon dragon : this.getChildren()) {
                result.append(String.format("  Dragon_%s/Dragon_%s", this.getId(), dragon.getId()));
            }
            result.setLength(result.length() - 1);
        }
        
        return result.toString();
    }
}
