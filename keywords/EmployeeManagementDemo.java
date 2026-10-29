public class EmployeeManagementDemo {

    static class EmployeeRecord {
        static String companyName = "Tech Solutions";
        private static int totalEmployees = 0;

        private String name;
        private final int id;
        private String designation;

        EmployeeRecord(String name, int id, String designation) {
            this.name = name;
            this.id = id;
            this.designation = designation;
            totalEmployees++;
        }

        static void displayTotalEmployees() {
            System.out.println("Total Employees: " + totalEmployees);
        }

        void displayDetails() {
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + name);
            System.out.println("Employee ID: " + id);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        EmployeeRecord employee1 =
                new EmployeeRecord("Riya", 101, "Developer");
        EmployeeRecord employee2 =
                new EmployeeRecord("Karan", 102, "Tester");

        Object employee = employee1;

        if (employee instanceof EmployeeRecord) {
            ((EmployeeRecord) employee).displayDetails();
        }

        EmployeeRecord.displayTotalEmployees();
    }
}