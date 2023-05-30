package Day_10;

public class Student implements Employee {

    @Override
    public void employeeIn() {
        System.out.println("Student in.");
    }

    @Override
    public void employeeOut() {
        System.out.println("Student out.");
    }
}