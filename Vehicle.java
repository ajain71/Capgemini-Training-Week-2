
import java.util.Scanner;

class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 500.00; // Fixed fee for all vehicles

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    // Class method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();
        
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        
        Vehicle vehicle = new Vehicle(ownerName, vehicleType);
        vehicle.displayVehicleDetails();
        
        scanner.close();
    }
}

