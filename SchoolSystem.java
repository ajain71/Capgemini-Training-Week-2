class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    public void displayRole() {
        System.out.println("General Person in the School System");
    }
}
class Teacher extends Person {
    private String subject;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }
    public void displaySubject() {
        System.out.println("Teaches: " + subject);
    }
}
class Student extends Person {
    private int grade;
    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }
    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }
    public void displayGrade() {
        System.out.println("Grade: " + grade);
    }
}
class Staff extends Person {
    private String department;
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    @Override
    public void displayRole() {
        System.out.println("Role: Staff");
    }
    public void displayDepartment() {
        System.out.println("Department: " + department);
    }
}
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice Johnson", 35, "Mathematics");
        teacher.displayRole();
        teacher.displayDetails();
        teacher.displaySubject();
        System.out.println();
        Student student = new Student("Bob Smith", 16, 10);
        student.displayRole();
        student.displayDetails();
        student.displayGrade();
        System.out.println();
        Staff staff = new Staff("Charlie Brown", 40, "Administration");
        staff.displayRole();
        staff.displayDetails();
        staff.displayDepartment();
    }
}