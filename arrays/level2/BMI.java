import java.util.Scanner;

class BMI {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read number of persons
        int num = sc.nextInt();

        // 2D array to store height, weight, and BMI value
        int[][] BMI = new int[num][3];

        // Array to store BMI status of each person
        String[] BMIstatus = new String[num];

        // Read height and weight, calculate BMI, and determine status
        for (int i = 0; i < num; i++) {
            BMI[i][0] = sc.nextInt();
            BMI[i][1] = sc.nextInt();

            // Calculate BMI
            BMI[i][2] = BMI[i][1] / (BMI[i][0] * BMI[i][0]);

            // Determine BMI category
            if (BMI[i][2] <= 18) {
                BMIstatus[i] = "Underweight";
            } else if (BMI[i][2] > 18 && BMI[i][2] <= 25) {
                BMIstatus[i] = "Normal";
            } else if (BMI[i][2] > 25 && BMI[i][2] <= 40) {
                BMIstatus[i] = "Overwieght";
            } else {
                BMIstatus[i] = "Obese";
            }
        }

        // Print BMI status of each person
        for (int i = 0; i < num; i++) {
            System.out.println(BMIstatus[i]);
        }
    }
}