package dragons;

import java.util.ArrayList;
import java.util.List;

public class Dragon {
    public static final int MAX_AGE = 6;
    public static final int START_LAY_EGGS_AGE = 3;
    public static final int STOP_LAY_EGGS_AGE = 5;

    public static int instanceCounter = 0;
    private int id;
    private String name;
    private int age;
    private boolean layEggs;
    private boolean alive;
    private List<Egg> eggs;
    private List<Dragon> children;

    public Dragon(String name) {
        instanceCounter++;
        this.setId(instanceCounter);
        this.setName(name);
        this.setAge(0);
        this.setLayEggs(false);
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

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
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

    public boolean canLayEggs(){
        return this.layEggs;
    }
    
    public void setLayEggs(boolean layEggs){
        this.layEggs = layEggs;
    }
    
    public void layEgg(Egg egg) {
        this.getEggs().add(egg);
    }

    public void grow() {
        if (this.getAge() < MAX_AGE) {
            this.setAge(this.getAge() + 1);
        }
        
        if (this.getAge() == MAX_AGE) {
            this.setAlive(false);
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
