package Day_10;

public class Light implements IElectricalEquipment {

    @Override
    public void powerOn() {
        System.out.println("Light is on.");
    }

    @Override
    public void powerOff() {
        System.out.println("Light is off.");
    }

}
