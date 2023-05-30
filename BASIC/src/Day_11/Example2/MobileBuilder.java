package Day_11.Example2;

// abstract BUILDER A.K.A BUILDER
public abstract class MobileBuilder {

    protected Mobile mobile;

    public void createNewMobileProduct() {
        mobile = new Mobile();
    }

    public abstract void buildName();

    public abstract void buildBattery();

    public abstract void buildCamera();

    public abstract void buildRam();

    public Mobile getMobile(){
        return mobile;
    }

}
