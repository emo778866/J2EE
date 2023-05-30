package Day_11.Example2;

// PRODUCT
public class Mobile {

    private String name;
    private int battery;
    private int camera;
    private int ram;

    public void setName(String _name) {
        name = _name;
    }

    public void setBattery(int _battery) {
        battery = _battery;
    }

    public void setCamera(int _camera) {
        camera = _camera;
    }

    public void setRam(int _ram) {
        ram = _ram;
    }

    public String toString() {
        return "Name:" + name + ", Battery:" + battery + ", Camera:" + camera + ", Ram:" + ram;
    }

}
