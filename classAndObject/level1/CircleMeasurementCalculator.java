package level1;

class Circle {
    double radius;

    // Constructor to initialize radius
    Circle(double radius) {
        this.radius = radius;
    }

    // Calculate the area
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Calculate the circumference
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Display both measurements
    void displayMeasurements() {
        System.out.printf("Radius: %.2f%n", radius);
        System.out.printf("Area: %.2f%n", calculateArea());
        System.out.printf("Circumference: %.2f%n",
                calculateCircumference());
    }
}

public class CircleMeasurementCalculator {
    public static void main(String[] args) {
        Circle circle = new Circle(7.0);

        circle.displayMeasurements();
    }
}
