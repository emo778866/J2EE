package Day_10;

public class Fan implements IElectricalEquipment {

    @Override
    public void powerOn() {
        System.out.println("Fan is on.");
    }

    @Override
    public void powerOff() {
        System.out.println("Fan is off.");
    }

}
