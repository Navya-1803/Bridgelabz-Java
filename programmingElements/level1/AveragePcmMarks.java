package level1;

public class AveragePcmMarks {
    public static void main(String[] args) {
        int mathsMarks = 94;
        int physicsMarks = 95;
        int chemistryMarks = 96;

        // Calculate the average marks
        double averageMarks =
                (mathsMarks + physicsMarks + chemistryMarks) / 3.0;

        System.out.println("Sam's average mark in PCM is "
                + averageMarks + "%");
    }
}