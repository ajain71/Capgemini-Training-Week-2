class Vehicle {
    protected String model;
    protected int maxSpeed;
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
    public void displayDetails() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}
interface Refuelable {
    void refuel();
}
class ElectricVehicle extends Vehicle {
    private int batteryCapacity;
    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }
    public void charge() {
        System.out.println(model + " is charging. Battery Capacity: " + batteryCapacity + " kWh");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable {
    private double fuelCapacity;
    public PetrolVehicle(String model, int maxSpeed, double fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }
    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel Capacity: " + fuelCapacity + " liters");
    }
}
public class VehicleSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200, 75);
        ev.displayDetails();
        ev.charge();
        System.out.println();
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 250, 60);
        pv.displayDetails();
        pv.refuel();
    }
}