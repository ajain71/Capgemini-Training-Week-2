
import java.util.ArrayList;
import java.util.List;

// Interface for Medical Records
interface MedicalRecord {
    void addRecord(String entry);
    List<String> viewRecords();
}

// Abstract Patient class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalHistory = new ArrayList<>();

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Encapsulation: Getters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected void addToMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    protected List<String> getMedicalHistory() {
        return new ArrayList<>(medicalHistory); // return a copy
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Total Bill: $" + calculateBill());
    }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String entry) {
        addToMedicalHistory("In-Patient Note: " + entry);
    }

    @Override
    public List<String> viewRecords() {
        return getMedicalHistory();
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String entry) {
        addToMedicalHistory("Out-Patient Note: " + entry);
    }

    @Override
    public List<String> viewRecords() {
        return getMedicalHistory();
    }
}

// Main class to demonstrate polymorphism
public class HospitalManagementSystem {
    public static void processPatient(Patient patient) {
        patient.getPatientDetails();
        if (patient instanceof MedicalRecord) {
            MedicalRecord record = (MedicalRecord) patient;
            System.out.println("Medical History:");
            for (String r : record.viewRecords()) {
                System.out.println(" - " + r);
            }
        }
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Patient p1 = new InPatient("P001", "Alice", 30, 5, 1500);
        Patient p2 = new OutPatient("P002", "Bob", 45, 400);

        // Adding medical records
        ((MedicalRecord) p1).addRecord("Admitted with pneumonia.");
        ((MedicalRecord) p1).addRecord("Prescribed antibiotics.");
        ((MedicalRecord) p2).addRecord("Consulted for fever.");
        ((MedicalRecord) p2).addRecord("Prescribed paracetamol.");

        // Process patients using polymorphism
        processPatient(p1);
        processPatient(p2);
    }
}

