public class UniversityStudentDemo {

    static class UniversityStudentRecord {
        static String universityName = "SRM University";
        private static int totalStudents = 0;

        private String name;
        private final int rollNumber;
        private char grade;

        UniversityStudentRecord(String name, int rollNumber, char grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
            totalStudents++;
        }

        static void displayTotalStudents() {
            System.out.println("Total Students: " + totalStudents);
        }

        void displayDetails() {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        }

        void updateGrade(char newGrade) {
            this.grade = newGrade;
        }
    }

    public static void main(String[] args) {
        UniversityStudentRecord student =
                new UniversityStudentRecord("Ananya", 201, 'A');

        Object obj = student;

        if (obj instanceof UniversityStudentRecord) {
            UniversityStudentRecord validStudent =
                    (UniversityStudentRecord) obj;

            validStudent.displayDetails();
            validStudent.updateGrade('A');
        }

        UniversityStudentRecord.displayTotalStudents();
    }
}