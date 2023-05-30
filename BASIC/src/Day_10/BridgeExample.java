package Day_10;

public class BridgeExample {
    public static void main(String[] args) {
        IElectricalEquipment fan = new Fan();
        IElectricalEquipment light = new Light();

        Switch fancySwitch = new FancySwitch();
        Switch normalSwitch = new NormalSwitch();

        fancySwitch.setIElectricalEquipment(fan);
        fancySwitch.On();
        fancySwitch.Off();

        normalSwitch.setIElectricalEquipment(light);
        normalSwitch.On();
        normalSwitch.Off();


    }
}