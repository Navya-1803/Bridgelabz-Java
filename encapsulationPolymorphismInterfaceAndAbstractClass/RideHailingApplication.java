import java.util.ArrayList;
import java.util.List;

public class RideHailingApplication {

    interface GPS {
        String getCurrentLocation();
        void updateLocation(String location);
    }

    static abstract class Vehicle implements GPS {
        private String vehicleId;
        private String driverName;
        private double ratePerKm;
        private String currentLocation;

        Vehicle(String vehicleId, String driverName, double ratePerKm,
                String currentLocation) {
            this.vehicleId = vehicleId;
            this.driverName = driverName;
            this.ratePerKm = Math.max(0, ratePerKm);
            this.currentLocation = currentLocation;
        }

        abstract double calculateFare(double distance);

        void getVehicleDetails() {
            System.out.println("Vehicle ID: " + vehicleId);
            System.out.println("Driver: " + driverName);
            System.out.println("Location: " + getCurrentLocation());
            System.out.println("Rate per km: " + ratePerKm);
        }

        public double getRatePerKm() {
            return ratePerKm;
        }

        @Override
        public String getCurrentLocation() {
            return currentLocation;
        }

        @Override
        public void updateLocation(String location) {
            if (location != null && !location.isBlank()) {
                currentLocation = location;
            }
        }
    }

    static class Car extends Vehicle {
        Car(String id, String driver, double rate, String location) {
            super(id, driver, rate, location);
        }

        @Override
        double calculateFare(double distance) {
            return distance > 0 ? distance * getRatePerKm() + 50 : 0;
        }
    }

    static class Bike extends Vehicle {
        Bike(String id, String driver, double rate, String location) {
            super(id, driver, rate, location);
        }

        @Override
        double calculateFare(double distance) {
            return distance > 0 ? distance * getRatePerKm() + 10 : 0;
        }
    }

    static class Auto extends Vehicle {
        Auto(String id, String driver, double rate, String location) {
            super(id, driver, rate, location);
        }

        @Override
        double calculateFare(double distance) {
            return distance > 0 ? distance * getRatePerKm() + 20 : 0;
        }
    }

    static void calculateRideFares(List<Vehicle> vehicles,
                                   double distance) {
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            System.out.println("Ride Distance: " + distance + " km");
            System.out.println("Estimated Fare: "
                    + vehicle.calculateFare(distance));
            System.out.println("-------------------");
        }
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR101", "Aarav", 18, "Chennai Central"));
        vehicles.add(new Bike("BIKE102", "Priya", 8, "Guindy"));
        vehicles.add(new Auto("AUTO103", "Ravi", 12, "Tambaram"));

        calculateRideFares(vehicles, 10);

        // Demonstrate GPS location update.
        vehicles.get(0).updateLocation("Koyambedu");
        System.out.println("Updated Location: "
                + vehicles.get(0).getCurrentLocation());
    }
}