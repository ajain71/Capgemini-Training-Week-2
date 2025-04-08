import java.util.ArrayList;
class Faculty {
    private String name;
    private String designation;
    public Faculty(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }
    public void displayFacultyInfo() {
        System.out.println("Faculty: " + name + ", Designation: " + designation);
    }
}
class Department {
    private String departmentName;
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
    public void displayDepartmentInfo() {
        System.out.println("Department: " + departmentName);
    }
}
class University {
    private String universityName;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> facultyMembers;
    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }
    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }
    public void displayUniversityInfo() {
        System.out.println("University: " + universityName);
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.displayDepartmentInfo();
        }
        System.out.println("Faculty Members:");
        for (Faculty faculty : facultyMembers) {
            faculty.displayFacultyInfo();
        }
    }
}
public class UniversitySystem {
    public static void main(String[] args) {
        Faculty faculty1 = new Faculty("Dr. Smith", "Professor");
        Faculty faculty2 = new Faculty("Dr. Johnson", "Assistant Professor");
        University university = new University("XYZ University");
        university.addDepartment("Computer Science");
        university.addDepartment("Mathematics");
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        university.displayUniversityInfo();
    }
}