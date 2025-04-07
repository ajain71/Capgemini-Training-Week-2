import java.util.Scanner;

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Method to get CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Method to set CGPA
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass to demonstrate protected member usage
class PostgraduateStudent extends Student {
    private String specialization;

    // Constructor
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    // Method to display postgraduate student details
    public void displayPostgraduateDetails() {
        displayStudentDetails(); // Accessing protected member 'name'
        System.out.println("Specialization: " + specialization);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter CGPA: ");
        double CGPA = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        
        PostgraduateStudent pgStudent = new PostgraduateStudent(rollNumber, name, CGPA, specialization);
        pgStudent.displayPostgraduateDetails();
        
        scanner.close();
    }
