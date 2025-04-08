import java.util.ArrayList;
class Employee{
    private String name;
    private String position;
    public Employee(String name, String position){
        this.name = name;
        this.position = position;
    }
    public void displayEmployeeInfo(){
        System.out.println(" - " + name + " (" + position + ")");
    }
}
class Department{
    public String departmentName;
    private ArrayList<Employee> employees;
    public Department(String departmentName){
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(String name, String position){
        employees.add(new Employee(name, position));
    }
    public void displayDepartmentInfo(){
        System.out.println("Department: " + departmentName);
        for (Employee employee : employees){
            employee.displayEmployeeInfo();
        }
        System.out.println();
    }
}
class Company{
    private String companyName;
    private ArrayList<Department> departments;
    public Company(String companyName){
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }
    public void addDepartment(String departmentName){
        departments.add(new Department(departmentName));
    }
    public Department getDepartment(String departmentName){
        for(Department dept : departments){
            if(dept.departmentName.equals(departmentName)){
                return dept;
            }
        }
        return null;
    }
    public void displayCompanyInfo(){
        System.out.println("Company: " + companyName);
        for(Department department : departments){
            department.displayDepartmentInfo();
        }
    }
}
public class CompanySystem{
    public static void main(String[] args){
        Company company = new Company("Tech Solutions");
        company.addDepartment("Software Development");
        company.addDepartment("Human Resources");
        Department softwareDept = company.getDepartment("Software Development");
        if(softwareDept != null){
            softwareDept.addEmployee("Alice Johnson", "Software Engineer");
            softwareDept.addEmployee("Bob Smith", "Senior Developer");
        }
        Department hrDept = company.getDepartment("Human Resources");
        if(hrDept != null){
            hrDept.addEmployee("Charlie Brown", "HR Manager");
        }
        company.displayCompanyInfo();
    }
}