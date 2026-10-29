public class EducationalCourseInheritance {

    static class CourseRecord {
        protected String courseName;
        protected int duration;

        CourseRecord(String courseName, int duration) {
            this.courseName = courseName;
            this.duration = duration;
        }

        void displayCourse() {
            System.out.println("Course: " + courseName);
            System.out.println("Duration: " + duration + " hours");
        }
    }

    static class OnlineCourse extends CourseRecord {
        protected String platform;
        protected boolean isRecorded;

        OnlineCourse(String courseName, int duration,
                     String platform, boolean isRecorded) {
            super(courseName, duration);
            this.platform = platform;
            this.isRecorded = isRecorded;
        }

        @Override
        void displayCourse() {
            super.displayCourse();
            System.out.println("Platform: " + platform);
            System.out.println("Recorded: " + isRecorded);
        }
    }

    static class PaidOnlineCourse extends OnlineCourse {
        private double fee;
        private double discount;

        PaidOnlineCourse(String courseName, int duration,
                         String platform, boolean isRecorded,
                         double fee, double discount) {
            super(courseName, duration, platform, isRecorded);
            this.fee = fee;
            this.discount = discount;
        }

        @Override
        void displayCourse() {
            super.displayCourse();
            System.out.println("Original Fee: " + fee);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Final Fee: "
                    + (fee - fee * discount / 100));
        }
    }

    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse(
                "Java Programming", 40, "Online Academy",
                true, 5000, 20
        );

        course.displayCourse();
    }
}