class Device {
    protected String deviceId;
    protected String status;
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status);
    }
}
class Thermostat extends Device {
    private int temperatureSetting;
    public Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}
public class SmartHome {
    public static void main(String[] args) {
        Device device1 = new Device("D001", "ON");
        device1.displayStatus();
        Thermostat thermostat1 = new Thermostat("T001", "ON", 24);
        thermostat1.displayStatus();
    }
}