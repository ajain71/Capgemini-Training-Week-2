
// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Getters and Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    // Abstract Method
    public abstract double calculateRentalCost(int days);

    // Display info
    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: $" + rentalRate);
        System.out.println("Rental Cost for " + days + " days: $" + calculateRentalCost(days));

        if (this instanceof Insurable) {
            System.out.println("Insurance Cost: $" + ((Insurable) this).calculateInsurance());
            System.out.println("Insurance Details: " + ((Insurable) this).getInsuranceDetails());
        }
        System.out.println("-----------------------------");
    }
}

// Car class
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% of base rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + getInsurancePolicyNumber();
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Not insurable, so no interface implemented
}

// Truck class
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Includes a heavy vehicle surcharge
        return (getRentalRate() * days) + 500; // Flat surcharge
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of base rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + getInsurancePolicyNumber();
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        int rentalDays = 5;

        Vehicle v1 = new Car("KA01AB1234", 1500, "CAR-INS-1001");
        Vehicle v2 = new Bike("KA02XY5678", 500, "BIKE-INS-2002");
        Vehicle v3 = new Truck("KA03TR9012", 2500, "TRUCK-INS-3003");

        Vehicle[] fleet = { v1, v2, v3 };

        for (Vehicle v : fleet) {
            v.displayDetails(rentalDays);
        }
    }
}

