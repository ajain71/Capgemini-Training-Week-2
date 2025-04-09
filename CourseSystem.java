class Course {
    protected String courseName;
    protected int duration;
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks");
    }
}
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    public double getDiscountedFee() {
        return fee - (fee * discount / 100);
    }
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%, Final Price: $" + getDiscountedFee());
    }
}
public class CourseSystem {
    public static void main(String[] args) {
        Course course = new Course("Data Structures", 8);
        course.displayCourseDetails();
        OnlineCourse onlineCourse = new OnlineCourse("Java Programming", 6, "Udemy", true);
        onlineCourse.displayCourseDetails();
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Machine Learning", 12, "Coursera", true, 500, 20);
        paidCourse.displayCourseDetails();
    }
}