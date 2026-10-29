import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {

    interface Insurable {
        double calculateInsurance();
        String getInsuranceDetails();
    }

    static abstract class Vehicle {
        private String vehicleNumber;
        private String type;
        private double rentalRate;

        Vehicle(String vehicleNumber, String type, double rentalRate) {
            this.vehicleNumber = vehicleNumber;
            this.type = type;
            setRentalRate(rentalRate);
        }

        abstract double calculateRentalCost(int days);

        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public String getType() {
            return type;
        }

        public double getRentalRate() {
            return rentalRate;
        }

        public void setRentalRate(double rentalRate) {
            if (rentalRate >= 0) {
                this.rentalRate = rentalRate;
            }
        }

        void displayDetails(int days) {
            System.out.println("Vehicle Number: " + vehicleNumber);
            System.out.println("Type: " + type);
            System.out.println("Rental Cost: " + calculateRentalCost(days));

            if (this instanceof Insurable) {
                Insurable insurance = (Insurable) this;
                System.out.println("Insurance Cost: "
                        + insurance.calculateInsurance());
                System.out.println(insurance.getInsuranceDetails());
            }
        }
    }

    static class Car extends Vehicle implements Insurable {
        private String policyNumber;

        Car(String number, double rate, String policyNumber) {
            super(number, "Car", rate);
            this.policyNumber = policyNumber;
        }

        @Override
        double calculateRentalCost(int days) {
            return days > 0 ? getRentalRate() * days : 0;
        }

        @Override
        public double calculateInsurance() {
            return 500;
        }

        @Override
        public String getInsuranceDetails() {
            return "Car insurance policy: " + maskPolicyNumber();
        }

        private String maskPolicyNumber() {
            return "****" + policyNumber.substring(
                    Math.max(0, policyNumber.length() - 4));
        }
    }

    static class Bike extends Vehicle implements Insurable {
        private String policyNumber;

        Bike(String number, double rate, String policyNumber) {
            super(number, "Bike", rate);
            this.policyNumber = policyNumber;
        }

        @Override
        double calculateRentalCost(int days) {
            return days > 0 ? getRentalRate() * days : 0;
        }

        @Override
        public double calculateInsurance() {
            return 150;
        }

        @Override
        public String getInsuranceDetails() {
            return "Bike insurance policy: ****"
                    + policyNumber.substring(
                    Math.max(0, policyNumber.length() - 4));
        }
    }

    static class Truck extends Vehicle implements Insurable {
        private String policyNumber;

        Truck(String number, double rate, String policyNumber) {
            super(number, "Truck", rate);
            this.policyNumber = policyNumber;
        }

        @Override
        double calculateRentalCost(int days) {
            return days > 0 ? getRentalRate() * days : 0;
        }

        @Override
        public double calculateInsurance() {
            return 1000;
        }

        @Override
        public String getInsuranceDetails() {
            return "Truck insurance policy: ****"
                    + policyNumber.substring(
                    Math.max(0, policyNumber.length() - 4));
        }
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("TN01AB1234", 2000, "CAR12345"));
        vehicles.add(new Bike("TN02CD5678", 500, "BIKE5678"));
        vehicles.add(new Truck("TN03EF9012", 4000, "TRUCK9012"));

        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails(3);
            System.out.println("-------------------");
        }
    }
}