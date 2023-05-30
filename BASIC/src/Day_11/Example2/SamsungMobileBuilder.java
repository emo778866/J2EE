package Day_11.Example2;

// concrete BUILDER
public class SamsungMobileBuilder extends MobileBuilder {

    @Override
    public void buildName() {
        mobile.setName("Samsung UlTRA PRO MAX PLUS MINUS");
    }

    @Override
    public void buildBattery() {
        mobile.setBattery(5000);
    }

    @Override
    public void buildCamera() {
        mobile.setCamera(50);
    }

    @Override
    public void buildRam() {
        mobile.setRam(8);
    }

}
