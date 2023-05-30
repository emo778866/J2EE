package Day_7;

public class Inheritance {
    public static void main(String[] args) {

        MountainBike mb1 = new MountainBike(3, 100, 25);
        Bicycle mb2 = new MountainBike(4, 200, 20);
        Bicycle bicycle = new Bicycle(3, 150);

        mb1.doNothing(mb1);
        mb1.doNothing(mb2);
        mb1.doNothing(bicycle);

        System.out.println("Class of bicycle is " + bicycle.getClass());
        System.out.println("Class of mb1 is " + mb1.getClass());
        System.out.println("Class of mb2 is " + mb2.getClass());
        System.out.println("__________________________________");
        System.out.print("bicycle is instance of MountainBike class that is: ");
        System.out.println(bicycle instanceof MountainBike);
        System.out.print("bicycle is instance of Bicycle class that is: ");
        System.out.println(bicycle instanceof Bicycle);

        System.out.print("mb1 is instance of MountainBike class that is: ");
        System.out.println(mb1 instanceof MountainBike);
        System.out.print("mb1 is instance of Bicycle class that is: ");
        System.out.println(mb2 instanceof Bicycle);
        System.out.print("mb2 is instance of MountainBike class that is: ");
        System.out.println(mb2 instanceof MountainBike);
        System.out.print("mb2 is instance of Bicycle class that is: ");
        System.out.println(mb2 instanceof Bicycle);
        System.out.println("___________________________");
        System.out.println("mb1 calling toString() => " + mb1);
        System.out.println("mb2 calling toString() => " + mb2);
        try {
            System.out.println(mb1.gear);
        } catch (Exception ignored) {
        }
        System.out.println("Now mb2 is trying to access a value from the MountainBike class");
        try {
            /*
            This will give run time error!
             */
//            System.out.println(mb2.seatHeight);
        } catch (Exception ignored) {
            System.out.println("As the reference of mb2 is Bicycle (Which is the superclass) hence it can not access the property and method of MountainBike (Which is the subclass).");
        }
    }
}

class Bicycle {
    // the Bicycle class has two fields
    public int gear;
    public int speed;
    protected String y = "Hello";

    public Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    public String toString() {
        return ("This is the Bicycle's toString method.");
    }
}

// derived class
class MountainBike extends Bicycle {
    public int seatHeight;

    public MountainBike(int gear, int speed, int startHeight) {
        super(gear, speed);
        seatHeight = startHeight;
    }

    public void doNothing(Bicycle obj) {
        System.out.println("Boogeyman!!!");
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    @Override
    public String toString() {
        return ("This is the MountainBike's toString method.");
    }

}

// driver class
