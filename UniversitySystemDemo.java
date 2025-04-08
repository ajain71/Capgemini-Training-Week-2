import java.util.*;

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
        }
    }

    public void viewEnrolledCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course course : enrolledCourses) {
            System.out.println("- " + course.getTitle());
        }
    }
}

class Course {
    private String title;
    private Professor professor;
    private List<Student> enrolledStudents;

    public Course(String title) {
        this.title = title;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void showCourseDetails() {
        System.out.println("Course: " + title);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }
}
public class UniversitySystemDemo {
    public static void main(String[] args) {
        Professor prof1 = new Professor("Dr. Smith");
        Professor prof2 = new Professor("Dr. Johnson");

        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Operating Systems");

        course1.assignProfessor(prof1);
        course2.assignProfessor(prof2);

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        s1.enrollCourse(course1);
        s1.enrollCourse(course2);

        s2.enrollCourse(course1);

        s1.viewEnrolledCourses();
        s2.viewEnrolledCourses();

        course1.showCourseDetails();
        course2.showCourseDetails();
    }
}