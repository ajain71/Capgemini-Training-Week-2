
// Department Interface
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// Abstract Employee class
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Department methods
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }

    // Concrete Method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Final Salary: $" + calculateSalary());
    }

    // Abstract method
    public abstract double calculateSalary();
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, hourlyRate); // baseSalary here used for hourlyRate
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Main class to test
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(101, "Alice", 50000, 10000);
        emp1.assignDepartment("HR");

        Employee emp2 = new PartTimeEmployee(102, "Bob", 200, 60);
        emp2.assignDepartment("IT");

        Employee emp3 = new FullTimeEmployee(103, "Charlie", 60000, 15000);
        emp3.assignDepartment("Finance");

        // Polymorphic processing
        Employee[] employees = { emp1, emp2, emp3 };

        for (Employee emp : employees) {
            System.out.println("-------------");
            emp.displayDetails();
        }
    }
}

