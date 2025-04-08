 class Student {
    private static String universityName = "Global University";
    private static int totalStudents = 0;
    private String name;
    private final int rollNumber;
    private char grade;
    
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
    
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Invalid object!");
        }
    }
    
    public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Updated Grade for " + name + ": " + grade);
        } else {
            System.out.println("Invalid object!");
        }
    }
    
    public static void main(String[] args) {
        Student student1 = new Student("Alice Johnson", 101, 'A');
        Student student2 = new Student("Bob Smith", 102, 'B');
        
        student1.displayStudentDetails();
        student2.displayStudentDetails();
        
        displayTotalStudents();
        
        student2.updateGrade('A');
    }
}

