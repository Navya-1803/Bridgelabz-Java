package level1;

public class PenDistribution {
    public static void main(String[] args) {
        int totalPens = 14;
        int numberOfStudents = 3;

        // Calculate pens each student receives
        int pensPerStudent = totalPens / numberOfStudents;

        // Calculate the remaining pens
        int remainingPens = totalPens % numberOfStudents;

        System.out.println("The Pen Per Student is " + pensPerStudent
                + " and the remaining pen not distributed is "
                + remainingPens);
    }
}
