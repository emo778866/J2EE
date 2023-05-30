package Day_10;

public class Trainer implements Employee{

    @Override
    public void employeeIn() {
        System.out.println("Trainer in.");
    }

    @Override
    public void employeeOut() {
        System.out.println("Trainer out.");
    }
}
