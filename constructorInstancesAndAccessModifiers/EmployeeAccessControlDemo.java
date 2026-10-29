class EmployeeRecord {
    public int employeeID;
    protected String department;
    private double salary;

    EmployeeRecord(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        setSalary(salary);
    }

    // Public method to modify the private salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }

    // Public getter for salary
    public double getSalary() {
        return salary;
    }
}

// Subclass demonstrates access to employeeID and department
class DepartmentManager extends EmployeeRecord {
    String teamName;

    DepartmentManager(int employeeID, String department,
                      double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: INR " + getSalary());
        System.out.println("Team: " + teamName);
    }
}

public class EmployeeAccessControlDemo {
    public static void main(String[] args) {
        DepartmentManager manager = new DepartmentManager(
                501, "Engineering", 85000, "Backend Development");

        manager.displayManagerDetails();

        // Update private salary through a public method
        manager.setSalary(95000);

        System.out.println("\nAfter Salary Update:");
        System.out.println("Updated Salary: INR " + manager.getSalary());
    }
}