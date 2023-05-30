package Day_7;
public class Casting {
    public static void main(String[] args) {

        //Upcasting
        Sport sport1 = new Cricket();
        //calling method
        sport1.displayName();

        System.out.println("Before casting the name is -> " + sport1.name + " as the reference is given of the superclass while creating the object.");

        try {
            Sport sport = new Sport();
            Cricket castedToCricket = (Cricket) sport;
            System.out.println(castedToCricket.name);
            castedToCricket.displayName();
        } catch (ClassCastException ignored) {
            System.out.println(ignored);
        }
    }
}

/* Java program to demonstrate upcasting */

//Creating a parent class Sport
class Sport {
    String name = "Sport";

    //Method to display name
    void displayName() {
        System.out.println("Sport");
    }
}

//Creating a child class Cricket
class Cricket extends Sport {
    String name = "Cricket";

    //Method to display name
    void displayName() {
        System.out.println("Cricket");
    }
}