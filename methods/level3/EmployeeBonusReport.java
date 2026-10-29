package level3;

public class EmployeeBonusReport {

    private static final int EMPLOYEE_COUNT = 10;

    // Generate five-digit salaries and years of service.
    // Column 0 = old salary, column 1 = years of service.
    public static int[][] generateEmployeeData(int size) {
        int[][] employees = new int[size][2];

        for (int i = 0; i < size; i++) {
            // Generate a salary from 10000 to 99999
            employees[i][0] = (int) (Math.random() * 90000) + 10000;

            // Generate years of service from 1 to 10
            employees[i][1] = (int) (Math.random() * 10) + 1;
        }

        return employees;
    }

    // Calculate bonus and new salary.
    // Column 0 = new salary, column 1 = bonus.
    public static double[][] calculateBonusAndSalary(int[][] employees) {
        double[][] results = new double[employees.length][2];

        for (int i = 0; i < employees.length; i++) {
            double oldSalary = employees[i][0];
            int yearsOfService = employees[i][1];

            // Apply the bonus rate based on years of service
            double bonusRate = yearsOfService > 5 ? 0.05 : 0.02;
            double bonus = oldSalary * bonusRate;
            double newSalary = oldSalary + bonus;

            results[i][0] = newSalary;
            results[i][1] = bonus;
        }

        return results;
    }

    // Display employee data and calculate totals
    public static void displayReport(
            int[][] employees, double[][] results) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-10s %-12s %-10s %-12s %-12s%n",
                "Employee", "Old Salary", "Years", "Bonus", "New Salary");

        for (int i = 0; i < employees.length; i++) {
            double oldSalary = employees[i][0];
            int years = employees[i][1];
            double newSalary = results[i][0];
            double bonus = results[i][1];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-10d %-12.2f %-10d %-12.2f %-12.2f%n",
                    i + 1, oldSalary, years, bonus, newSalary);
        }

        System.out.println("\nCompany Totals");
        System.out.printf("Total old salaries: INR %.2f%n", totalOldSalary);
        System.out.printf("Total bonuses: INR %.2f%n", totalBonus);
        System.out.printf("Total new salaries: INR %.2f%n", totalNewSalary);
    }

    public static void main(String[] args) {
        int[][] employees = generateEmployeeData(EMPLOYEE_COUNT);

        double[][] results = calculateBonusAndSalary(employees);

        displayReport(employees, results);
    }
}
