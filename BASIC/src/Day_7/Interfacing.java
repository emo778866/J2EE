package Day_7;

public class Interfacing {
    public static void main(String[] args) {
        Animal animal1 = new Cat();
        OtherAnimal animal2 = new Cat();
        animal1.run();
        animal2.run(5);
        SmallAnimal animal3 = new Cat();
        animal3.sleep();
    }
}


interface Animal {

    void makeSound();

    void run();
}

interface OtherAnimal {
    void makeSound();

    void run(int x);

    void sleep();

}

class SmallAnimal {
    public void makeSound() {
        System.out.println("The small animal is making a sound.");
    }

    public void run() {
        System.out.println("The small animal is running.");
    }

    public void sleep() {
        System.out.println("The small animal is sleeping zzz...");
    }
}

class Cat extends SmallAnimal implements Animal, OtherAnimal {
    public void makeSound() {
        System.out.println("The cat is making a sound.");
    }

    public void run() {
        System.out.println("The cat is running.");
    }

    public void run(int _x) {
        System.out.println("The cat is running at " + _x + " m/s.");
    }
}