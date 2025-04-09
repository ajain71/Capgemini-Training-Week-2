
// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Vehicle class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Not Set";
    }

    // Encapsulation: Getters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per KM: $" + ratePerKm);
    }

    protected void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    protected String fetchCurrentLocation() {
        return currentLocation;
    }
}

// Car subclass
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return fetchCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation("Car at " + newLocation);
    }
}

// Bike subclass
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.8; // discount for bikes
    }

    @Override
    public String getCurrentLocation() {
        return fetchCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation("Bike at " + newLocation);
    }
}

// Auto subclass
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 10; // base fare
    }

    @Override
    public String getCurrentLocation() {
        return fetchCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation("Auto at " + newLocation);
    }
}

// Main class to demonstrate functionality
public class RideHailingApp {
    // Polymorphic fare processor
    public static void processRide(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        if (vehicle instanceof GPS gps) {
            System.out.println("Location: " + gps.getCurrentLocation());
        }
        System.out.println("Distance: " + distance + " KM");
        System.out.println("Fare: $" + vehicle.calculateFare(distance));
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Vehicle car = new Car("CAR101", "Alice", 12.0);
        Vehicle bike = new Bike("BIK202", "Bob", 8.0);
        Vehicle auto = new Auto("AUT303", "Charlie", 10.0);

        ((GPS) car).updateLocation("Main Street");
        ((GPS) bike).updateLocation("Central Park");
        ((GPS) auto).updateLocation("Market Square");

        processRide(car, 5.5);
        processRide(bike, 3.0);
        processRide(auto, 7.2);
    }
}

