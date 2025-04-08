class Employee {
   
    private static String companyName = "TechCorp";
    private static int totalEmployees = 0;
    
   
    private String name;
    private String designation;
    private final int id;
    
   
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
    }
    
    public static void displayTotalEmployees(int count) {
        System.out.println("Total Employees Displayed: " + count);
    }
    
   
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Name: " + name);
            System.out.println("Employee ID: " + id);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid object!");
        }
    }
    
    public static void main(String[] args) {
       
        Employee emp1 = new Employee("Alice Johnson", 101, "Software Engineer");
        Employee emp2 = new Employee("Bob Smith", 102, "Project Manager");
        
       
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
        
       
        displayTotalEmployees(2);
    }
}



