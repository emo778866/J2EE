package Day_10;

public class BJIT {

    private Employee employee;

    public void setEmployee(Employee _employee) {
        employee = _employee;
    }

    public void signIn() {
        employee.employeeIn();
    }

    public void signOut() {
        employee.employeeOut();
    }

}