import java.util.ArrayList;
import java.util.List;

public class UniversityCourseManagement {

    // Parent class
    static abstract class CourseType {
        private String courseName;

        CourseType(String courseName) {
            this.courseName = courseName;
        }

        String getCourseName() {
            return courseName;
        }

        abstract String getEvaluationMethod();

        @Override
        public String toString() {
            return courseName + " | Evaluation: "
                    + getEvaluationMethod();
        }
    }

    static class ExamCourse extends CourseType {
        ExamCourse(String courseName) {
            super(courseName);
        }

        @Override
        String getEvaluationMethod() {
            return "Written Examination";
        }
    }

    static class AssignmentCourse extends CourseType {
        AssignmentCourse(String courseName) {
            super(courseName);
        }

        @Override
        String getEvaluationMethod() {
            return "Assignments";
        }
    }

    static class ResearchCourse extends CourseType {
        ResearchCourse(String courseName) {
            super(courseName);
        }

        @Override
        String getEvaluationMethod() {
            return "Research Project";
        }
    }

    // Multi-level inheritance
    static class ComputerScienceExamCourse extends ExamCourse {
        ComputerScienceExamCourse(String courseName) {
            super(courseName);
        }
    }

    // Generic course class
    static class Course<T extends CourseType> {
        private String department;
        private T courseType;

        Course(String department, T courseType) {
            this.department = department;
            this.courseType = courseType;
        }

        T getCourseType() {
            return courseType;
        }

        @Override
        public String toString() {
            return "Department: " + department
                    + " | " + courseType;
        }
    }

    // Wildcard method for displaying different course types
    static void displayCourses(
            List<? extends CourseType> courses) {

        for (CourseType course : courses) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {

        Course<ComputerScienceExamCourse> csCourse =
                new Course<>(
                        "Computer Science",
                        new ComputerScienceExamCourse("Data Structures")
                );

        Course<AssignmentCourse> assignmentCourse =
                new Course<>(
                        "Information Technology",
                        new AssignmentCourse("Web Development")
                );

        Course<ResearchCourse> researchCourse =
                new Course<>(
                        "Research Department",
                        new ResearchCourse("Artificial Intelligence")
                );

        List<CourseType> courses = new ArrayList<>();

        courses.add(csCourse.getCourseType());
        courses.add(assignmentCourse.getCourseType());
        courses.add(researchCourse.getCourseType());

        System.out.println("--- University Courses ---");

        displayCourses(courses);
    }
}