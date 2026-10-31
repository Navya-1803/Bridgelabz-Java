package DesignPattern.creational;

public class PrototypePattern {

    static class Employee implements Cloneable {

        private int id;
        private String name;
        private String department;

        public Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        @Override
        public Employee clone() {

            try {
                return (Employee) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        public void displayDetails() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Department: " + department);
        }
    }

    public static void main(String[] args) {

        Employee original = new Employee(
                101, "Rahul", "Engineering");

        Employee cloned = original.clone();

        System.out.println("Original Employee:");
        original.displayDetails();

        System.out.println("\nCloned Employee:");
        cloned.displayDetails();

        System.out.println("\nAre both objects same? "
                + (original == cloned));
    }
}