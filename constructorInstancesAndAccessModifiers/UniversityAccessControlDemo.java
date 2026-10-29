class UniversityStudent {
    public int rollNumber;
    protected String name;
    private double CGPA;

    UniversityStudent(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        setCGPA(CGPA);
    }

    // Public getter for private CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public setter with validation
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("CGPA must be between 0 and 10.");
        }
    }

    void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass demonstrates access to protected name
class PostgraduateStudent extends UniversityStudent {
    String specialization;

    PostgraduateStudent(int rollNumber, String name, double CGPA,
                        String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    void displayPostgraduateDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Specialization: " + specialization);
        System.out.println("CGPA: " + getCGPA());
    }
}

public class UniversityAccessControlDemo {
    public static void main(String[] args) {
        PostgraduateStudent student =
                new PostgraduateStudent(101, "Priya", 9.2, "Computer Science");

        student.displayPostgraduateDetails();

        // Modify private CGPA through the public setter
        student.setCGPA(9.5);
        System.out.println("Updated CGPA: " + student.getCGPA());

        // Public member can be accessed directly
        System.out.println("Roll Number: " + student.rollNumber);
    }
}