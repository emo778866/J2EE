package Day_11.Practice;

public class Switch {

    private IElectricalEquipment equipment;

    public void setIElectricalEquipment(IElectricalEquipment _equipment) {
        equipment = _equipment;
    }

    public void On() {
        equipment.powerOn();
    }

    public void Off() {
        equipment.powerOff();
    }

}