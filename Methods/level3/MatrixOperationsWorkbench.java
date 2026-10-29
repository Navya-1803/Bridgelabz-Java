package level3;

import java.util.Random;

public class MatrixOperationsWorkbench {

    private static final Random RANDOM = new Random();

    // Create a random matrix with values between 1 and 9
    public static double[][] createRandomMatrix(int rows, int columns) {
        double[][] matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = RANDOM.nextInt(9) + 1;
            }
        }

        return matrix;
    }

    // Display a matrix
    public static void displayMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix is not available.");
            return;
        }

        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%10.3f", value);
            }
            System.out.println();
        }
    }

    // Check whether two matrices have the same dimensions
    private static boolean haveSameDimensions(
            double[][] first, double[][] second) {

        return first.length == second.length
                && first[0].length == second[0].length;
    }

    // Add two matrices of equal dimensions
    public static double[][] addMatrices(
            double[][] first, double[][] second) {

        if (!haveSameDimensions(first, second)) {
            throw new IllegalArgumentException(
                    "Addition requires matrices of equal dimensions.");
        }

        int rows = first.length;
        int columns = first[0].length;
        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }

        return result;
    }

    // Subtract the second matrix from the first
    public static double[][] subtractMatrices(
            double[][] first, double[][] second) {

        if (!haveSameDimensions(first, second)) {
            throw new IllegalArgumentException(
                    "Subtraction requires matrices of equal dimensions.");
        }

        int rows = first.length;
        int columns = first[0].length;
        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = first[i][j] - second[i][j];
            }
        }

        return result;
    }

    // Multiply two matrices when columns of A equal rows of B
    public static double[][] multiplyMatrices(
            double[][] first, double[][] second) {

        if (first[0].length != second.length) {
            throw new IllegalArgumentException(
                    "Columns of the first matrix must equal rows of the second.");
        }

        int rows = first.length;
        int columns = second[0].length;
        int commonDimension = second.length;

        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < commonDimension; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }

        return result;
    }

    // Find the transpose by swapping rows and columns
    public static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[][] transpose = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    // Calculate the determinant of a 2x2 matrix
    public static double determinant2x2(double[][] matrix) {
        if (matrix.length != 2
                || matrix[0].length != 2
                || matrix[1].length != 2) {
            throw new IllegalArgumentException(
                    "A 2x2 matrix is required.");
        }

        return matrix[0][0] * matrix[1][1]
                - matrix[0][1] * matrix[1][0];
    }

    // Calculate the determinant of a 3x3 matrix
    public static double determinant3x3(double[][] matrix) {
        if (matrix.length != 3
                || matrix[0].length != 3
                || matrix[1].length != 3
                || matrix[2].length != 3) {
            throw new IllegalArgumentException(
                    "A 3x3 matrix is required.");
        }

        double a = matrix[0][0];
        double b = matrix[0][1];
        double c = matrix[0][2];

        double d = matrix[1][0];
        double e = matrix[1][1];
        double f = matrix[1][2];

        double g = matrix[2][0];
        double h = matrix[2][1];
        double i = matrix[2][2];

        return a * (e * i - f * h)
                - b * (d * i - f * g)
                + c * (d * h - e * g);
    }

    // Find the inverse of a 2x2 matrix
    public static double[][] inverse2x2(double[][] matrix) {
        double determinant = determinant2x2(matrix);

        // An inverse does not exist if the determinant is zero
        if (Math.abs(determinant) < 1e-10) {
            return null;
        }

        double[][] inverse = new double[2][2];

        inverse[0][0] = matrix[1][1] / determinant;
        inverse[0][1] = -matrix[0][1] / determinant;
        inverse[1][0] = -matrix[1][0] / determinant;
        inverse[1][1] = matrix[0][0] / determinant;

        return inverse;
    }

    // Find the inverse of a 3x3 matrix using cofactors
    public static double[][] inverse3x3(double[][] matrix) {
        double determinant = determinant3x3(matrix);

        if (Math.abs(determinant) < 1e-10) {
            return null;
        }

        double[][] cofactors = new double[3][3];

        // Calculate every cofactor
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Find the remaining 2x2 minor
                double[] minorValues = new double[4];
                int index = 0;

                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        if (r != i && c != j) {
                            minorValues[index++] = matrix[r][c];
                        }
                    }
                }

                double minorDeterminant =
                        minorValues[0] * minorValues[3]
                                - minorValues[1] * minorValues[2];

                // Apply the alternating cofactor sign
                cofactors[i][j] =
                        ((i + j) % 2 == 0 ? 1 : -1)
                                * minorDeterminant;
            }
        }

        // Transpose the cofactor matrix to obtain the adjugate
        double[][] adjugate = transposeMatrix(cofactors);
        double[][] inverse = new double[3][3];

        // Divide each adjugate element by the determinant
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverse[i][j] = adjugate[i][j] / determinant;
            }
        }

        return inverse;
    }

    public static void main(String[] args) {
        // Generate two random 3x3 matrices
        double[][] matrixA = createRandomMatrix(3, 3);
        double[][] matrixB = createRandomMatrix(3, 3);

        System.out.println("Matrix A:");
        displayMatrix(matrixA);

        System.out.println("\nMatrix B:");
        displayMatrix(matrixB);

        // Addition
        System.out.println("\nA + B:");
        displayMatrix(addMatrices(matrixA, matrixB));

        // Subtraction
        System.out.println("\nA - B:");
        displayMatrix(subtractMatrices(matrixA, matrixB));

        // Multiplication
        System.out.println("\nA x B:");
        displayMatrix(multiplyMatrices(matrixA, matrixB));

        // Transpose
        System.out.println("\nTranspose of A:");
        displayMatrix(transposeMatrix(matrixA));

        // Determinant of A
        double determinant = determinant3x3(matrixA);
        System.out.println("\nDeterminant of A: " + determinant);

        // Inverse of A
        System.out.println("\nInverse of A:");
        double[][] inverseA = inverse3x3(matrixA);

        if (inverseA == null) {
            System.out.println("A is singular; its inverse does not exist.");
        } else {
            displayMatrix(inverseA);
        }

        // Demonstrate 2x2 determinant and inverse
        double[][] matrixC = createRandomMatrix(2, 2);

        System.out.println("\nMatrix C (2x2):");
        displayMatrix(matrixC);

        System.out.println("Determinant of C: "
                + determinant2x2(matrixC));

        System.out.println("Inverse of C:");
        double[][] inverseC = inverse2x2(matrixC);

        if (inverseC == null) {
            System.out.println("C is singular; its inverse does not exist.");
        } else {
            displayMatrix(inverseC);
        }
    }
}
