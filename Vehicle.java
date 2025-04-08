class Vehicle {
    private static double registrationFee = 500.0;
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;
    
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid object!");
        }
    }
    
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Alice Johnson", "Car", "ABC1234");
        Vehicle vehicle2 = new Vehicle("Bob Smith", "Motorcycle", "XYZ5678");
        
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
        
        updateRegistrationFee(600.0);
        System.out.println("Updated Registration Fee: $" + registrationFee);
    }
}

