package Day_11.Example2;

public class BuilderExample {
    public static void main(String[] args) {
        Vendor vendor = new Vendor();
        MobileBuilder samsungMobileBuilder = new SamsungMobileBuilder();
        vendor.setMobileBuilder(samsungMobileBuilder);
        vendor.constructMobile();
        Mobile mobile = vendor.getMobile();
        System.out.println(mobile.toString());
    }
}
