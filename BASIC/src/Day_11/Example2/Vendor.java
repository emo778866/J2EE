package Day_11.Example2;

// DIRECTOR
public class Vendor {

    private MobileBuilder mobileBuilder;

    public void setMobileBuilder(MobileBuilder _mobileBuilder) {
        mobileBuilder = _mobileBuilder;
    }

    public void constructMobile() {

        mobileBuilder.createNewMobileProduct();

        mobileBuilder.buildName();

        mobileBuilder.buildBattery();

        mobileBuilder.buildCamera();

        mobileBuilder.buildRam();

    }

    public Mobile getMobile() {
        return mobileBuilder.getMobile();
    }

}
