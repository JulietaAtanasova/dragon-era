package dragons;

public class Egg {
    public static final int MAX_AGE = 2;
    private int age;
    private Dragon parent;
    
    public Egg(Dragon parent){
        this.setParent(parent);
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dragon getParent() {
        return parent;
    }

    private void setParent(Dragon parent) {
        this.parent = parent;
    }
    
}
