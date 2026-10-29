package level1;

class Employee {
    String name;
    int id;
    double salary;

    // Constructor to initialize employee details
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Display employee details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: INR " + salary);
    }
}

public class EmployeeDetailsDisplay {
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee("Navya", 101, 45000);

        employee.displayDetails();
    }
}
