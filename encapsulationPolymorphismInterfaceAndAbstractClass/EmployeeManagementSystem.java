import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {

    interface Department {
        void assignDepartment(String department);
        String getDepartmentDetails();
    }

    static abstract class Employee implements Department {
        private int employeeId;
        private String name;
        private double baseSalary;
        private String department;

        Employee(int employeeId, String name, double baseSalary) {
            this.employeeId = employeeId;
            this.name = name;
            setBaseSalary(baseSalary);
        }

        // Subclasses must provide their own salary calculation.
        abstract double calculateSalary();

        public void displayDetails() {
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Name: " + name);
            System.out.println("Base Salary: " + baseSalary);
            System.out.println("Department: " + department);
            System.out.println("Calculated Salary: " + calculateSalary());
        }

        @Override
        public void assignDepartment(String department) {
            this.department = department;
        }

        @Override
        public String getDepartmentDetails() {
            return department;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        public void setBaseSalary(double baseSalary) {
            if (baseSalary >= 0) {
                this.baseSalary = baseSalary;
            }
        }
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(int id, String name, double fixedSalary) {
            super(id, name, fixedSalary);
        }

        @Override
        double calculateSalary() {
            return getBaseSalary();
        }
    }

    static class PartTimeEmployee extends Employee {
        private int hoursWorked;
        private double hourlyRate;

        PartTimeEmployee(int id, String name, int hoursWorked,
                         double hourlyRate) {
            super(id, name, 0);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        double calculateSalary() {
            return hoursWorked * hourlyRate;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        Employee fullTime =
                new FullTimeEmployee(101, "Aarav", 60000);
        Employee partTime =
                new PartTimeEmployee(102, "Priya", 80, 500);

        fullTime.assignDepartment("Engineering");
        partTime.assignDepartment("Support");

        employees.add(fullTime);
        employees.add(partTime);

        // Polymorphism: each employee uses its own salary calculation.
        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println("-------------------");
        }
    }
}