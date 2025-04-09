class Employee {
    String name;
    int id;
    double salary;
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: $" + salary);
    }
}
class Manager extends Employee {
    int teamSize;
    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}
class Developer extends Employee {
    String programmingLanguage;
    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
class Intern extends Employee {
    int durationInMonths;
    Intern(String name, int id, double salary, int durationInMonths) {
        super(name, id, salary);
        this.durationInMonths = durationInMonths;
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: " + durationInMonths + " months");
    }
}
public class EmployeeHierarchy {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 101, 75000, 5);
        Employee developer = new Developer("Bob", 102, 60000, "Java");
        Employee intern = new Intern("Charlie", 103, 20000, 6);
        System.out.println("Manager Details:");
        manager.displayDetails();
        System.out.println();
        System.out.println("Developer Details:");
        developer.displayDetails();
        System.out.println();
        System.out.println("Intern Details:");
        intern.displayDetails();
    }
}