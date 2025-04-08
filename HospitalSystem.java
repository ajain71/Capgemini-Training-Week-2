import java.util.ArrayList;
class Patient {
    private String name;
    private int patientId;
    private ArrayList<Doctor> doctors;
    public Patient(String name, int patientId) {
        this.name = name;
        this.patientId = patientId;
        this.doctors = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getPatientId() {
        return patientId;
    }
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }
    public void displayDoctors() {
        System.out.println("Patient: " + name + " (ID: " + patientId + ") is consulting with:");
        for (Doctor doctor : doctors) {
            System.out.println("- Dr. " + doctor.getName() + " (" + doctor.getSpecialization() + ")");
        }
    }
}
class Doctor {
    private String name;
    private String specialization;
    private ArrayList<Patient> patients;
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
    }
    public void consult(Patient patient) {
        if (patients.contains(patient)) {
            System.out.println("Dr. " + name + " (Specialization: " + specialization + ") is consulting " + patient.getName() + " (Patient ID: " + patient.getPatientId() + ")");
        } else {
            System.out.println("Dr. " + name + " is not assigned to this patient.");
        }
    }
    public void displayPatients() {
        System.out.println("Dr. " + name + " (Specialization: " + specialization + ") is consulting:");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName() + " (ID: " + patient.getPatientId() + ")");
        }
    }
}
class Hospital {
    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    public void displayHospitalInfo() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("\nDoctors in Hospital:");
        for (Doctor doctor : doctors) {
            doctor.displayPatients();
            System.out.println();
        }
        System.out.println("Patients in Hospital:");
        for (Patient patient : patients) {
            patient.displayDoctors();
            System.out.println();
        }
    }
}
public class HospitalSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");
        Doctor doc1 = new Doctor("Alice Green", "Cardiology");
        Doctor doc2 = new Doctor("Bob White", "Neurology");
        Patient patient1 = new Patient("John Doe", 101);
        Patient patient2 = new Patient("Emily Clark", 102);
        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);
        doc1.addPatient(patient1);
        doc1.addPatient(patient2);
        doc2.addPatient(patient2);
        doc1.consult(patient1);
        doc1.consult(patient2);
        doc2.consult(patient2);
        System.out.println();
        hospital.displayHospitalInfo();
    }
}