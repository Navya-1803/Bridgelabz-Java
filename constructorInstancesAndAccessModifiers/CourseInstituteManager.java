class ManagedCourse {
    String courseName;
    int duration;
    double fee;

    // Shared by all course objects
    static String instituteName = "ABC Institute";

    ManagedCourse(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: INR " + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method: updates the institute name for all courses
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

public class CourseInstituteManager {
    public static void main(String[] args) {
        ManagedCourse javaCourse =
                new ManagedCourse("Java Programming", 3, 12000);

        ManagedCourse sqlCourse =
                new ManagedCourse("SQL Fundamentals", 2, 8000);

        System.out.println("Before Update:");
        javaCourse.displayCourseDetails();
        System.out.println();

        ManagedCourse.updateInstituteName("Tech Learning Academy");

        System.out.println("After Update:");
        javaCourse.displayCourseDetails();
        System.out.println();
        sqlCourse.displayCourseDetails();
    }
}