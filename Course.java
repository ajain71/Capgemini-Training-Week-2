
import java.util.Scanner;

class Course {
    private String courseName;
    private int duration; // in months
    private double fee;
    private static String instituteName = "Default Institute";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
    }

    // Class method to update institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        
        System.out.print("Enter course duration (in months): ");
        int duration = scanner.nextInt();
        
        System.out.print("Enter course fee: ");
        double fee = scanner.nextDouble();
        
        Course course = new Course(courseName, duration, fee);
        course.displayCourseDetails();
        
        scanner.close();
    }
}

