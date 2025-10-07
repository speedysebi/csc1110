package week_6;

public class Cat {
    private int age;
    private boolean hunger;
    private String name;

    public Cat(int age, boolean hunger, String name) {
        this.age = age;
        this.hunger = hunger;
        this.name = name;
    }

    public String toString(){
        return this.name + " age" + this.age +  " is hunger" + this.hunger;

    }

    public void birthday() {
        this.age += 1;
    }

    public void feed(){
        this.hunger = true;
    }
}
