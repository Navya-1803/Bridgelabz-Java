public class SchoolRoleHierarchy {

    static class SchoolPerson {
        protected String name;
        protected int age;

        SchoolPerson(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void displayRole() {
            System.out.println("Role: General School Person");
        }

        void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            displayRole();
        }
    }

    static class SchoolTeacher extends SchoolPerson {
        private String subject;

        SchoolTeacher(String name, int age, String subject) {
            super(name, age);
            this.subject = subject;
        }

        @Override
        void displayRole() {
            System.out.println("Role: Teacher");
            System.out.println("Subject: " + subject);
        }
    }

    static class SchoolStudent extends SchoolPerson {
        private String grade;

        SchoolStudent(String name, int age, String grade) {
            super(name, age);
            this.grade = grade;
        }

        @Override
        void displayRole() {
            System.out.println("Role: Student");
            System.out.println("Grade: " + grade);
        }
    }

    static class SchoolStaff extends SchoolPerson {
        private String department;

        SchoolStaff(String name, int age, String department) {
            super(name, age);
            this.department = department;
        }

        @Override
        void displayRole() {
            System.out.println("Role: Staff");
            System.out.println("Department: " + department);
        }
    }

    public static void main(String[] args) {
        SchoolPerson[] people = {
                new SchoolTeacher("Meera", 35, "Mathematics"),
                new SchoolStudent("Arjun", 16, "Grade 11"),
                new SchoolStaff("Ravi", 40, "Administration")
        };

        for (SchoolPerson person : people) {
            person.displayDetails();
            System.out.println("-------------------");
        }
    }
}