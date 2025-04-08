class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private String name;
    private int age;
    private String ailment;
    private final int patientID;
    
    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }
    
    public static int getTotalPatients() {
        return totalPatients;
    }
    
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Hospital: " + hospitalName);
        } else {
            System.out.println("Invalid object!");
        }
    }
    
    public static void main(String[] args) {
        Patient patient1 = new Patient("Alice Johnson", 30, "Flu", 101);
        Patient patient2 = new Patient("Bob Smith", 45, "Fracture", 102);
        
        patient1.displayPatientDetails();
        patient2.displayPatientDetails();
        
        System.out.println("Total Patients Admitted: " + getTotalPatients());
    }
}

