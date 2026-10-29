import java.util.Scanner;

class BMIMultiPerson {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read number of persons
        int number = sc.nextInt(); // number of persons

        // 2D array to store weight, height, and BMI
        double[][] personData = new double[number][3];

        // Array to store BMI status of each person
        String[] weightStatus = new String[number];

        // Read weight and height for each person with validation
        for (int i = 0; i < number; i++) {

            // Input weight in kilograms
            System.out.println("Enter weight (kg) for person " + (i + 1));
            personData[i][0] = sc.nextDouble();
            if (personData[i][0] <= 0) {
                System.out.println("Invalid weight. Enter again.");
                i--;
                continue;
            }

            // Input height in centimeters
            System.out.println("Enter height (cm) for person " + (i + 1));
            personData[i][1] = sc.nextDouble();
            if (personData[i][1] <= 0) {
                System.out.println("Invalid height. Enter again.");
                i--;
                continue;
            }
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < number; i++) {
            double heightMeter = personData[i][1] / 100;
            personData[i][2] = personData[i][0] / (heightMeter * heightMeter);

            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display BMI details of each person
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Weight: " + personData[i][0] + " kg");
            System.out.println("Height: " + personData[i][1] + " cm");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println();
        }
    }
}