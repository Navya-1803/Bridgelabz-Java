package level1;

import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee salary in INR: ");
        double salary = input.nextDouble();

        System.out.print("Enter years of service: ");
        int yearsOfService = input.nextInt();

        double bonus = 0.0;

        // Award a 5% bonus only when service exceeds 5 years
        if (salary >= 0 && yearsOfService >= 0) {
            if (yearsOfService > 5) {
                bonus = salary * 5 / 100;
            }

            System.out.printf("Employee salary: INR %.2f%n", salary);
            System.out.printf("Bonus amount: INR %.2f%n", bonus);
        } else {
            System.out.println("Salary and years of service cannot be negative.");
        }

        input.close();
    }
}
