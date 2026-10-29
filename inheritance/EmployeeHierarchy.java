public class EmployeeHierarchy {

    static class Employee {
        protected String name;
        protected int id;
        protected double salary;

        Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Salary: " + salary);
        }
    }

    static class Manager extends Employee {
        private int teamSize;

        Manager(String name, int id, double salary, int teamSize) {
            super(name, id, salary);
            this.teamSize = teamSize;
        }

        @Override
        void displayDetails() {
            super.displayDetails();
            System.out.println("Role: Manager");
            System.out.println("Team Size: " + teamSize);
        }
    }

    static class Developer extends Employee {
        private String programmingLanguage;

        Developer(String name, int id, double salary,
                  String programmingLanguage) {
            super(name, id, salary);
            this.programmingLanguage = programmingLanguage;
        }

        @Override
        void displayDetails() {
            super.displayDetails();
            System.out.println("Role: Developer");
            System.out.println("Language: " + programmingLanguage);
        }
    }

    static class Intern extends Employee {
        private int durationMonths;

        Intern(String name, int id, double salary, int durationMonths) {
            super(name, id, salary);
            this.durationMonths = durationMonths;
        }

        @Override
        void displayDetails() {
            super.displayDetails();
            System.out.println("Role: Intern");
            System.out.println("Duration: " + durationMonths + " months");
        }
    }

    public static void main(String[] args) {
        Employee[] employees = {
                new Manager("Aarav", 101, 90000, 8),
                new Developer("Priya", 102, 70000, "Java"),
                new Intern("Rohan", 103, 20000, 6)
        };

        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println("-------------------");
        }
    }
}