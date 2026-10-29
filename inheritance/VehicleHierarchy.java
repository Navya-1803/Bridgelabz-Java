public class VehicleHierarchy {

    static class Vehicle {
        protected int maxSpeed;
        protected String fuelType;

        Vehicle(int maxSpeed, String fuelType) {
            this.maxSpeed = maxSpeed;
            this.fuelType = fuelType;
        }

        void displayInfo() {
            System.out.println("Maximum Speed: " + maxSpeed + " km/h");
            System.out.println("Fuel Type: " + fuelType);
        }
    }

    static class Car extends Vehicle {
        private int seatCapacity;

        Car(int maxSpeed, String fuelType, int seatCapacity) {
            super(maxSpeed, fuelType);
            this.seatCapacity = seatCapacity;
        }

        @Override
        void displayInfo() {
            super.displayInfo();
            System.out.println("Vehicle: Car");
            System.out.println("Seats: " + seatCapacity);
        }
    }

    static class Truck extends Vehicle {
        private double loadCapacity;

        Truck(int maxSpeed, String fuelType, double loadCapacity) {
            super(maxSpeed, fuelType);
            this.loadCapacity = loadCapacity;
        }

        @Override
        void displayInfo() {
            super.displayInfo();
            System.out.println("Vehicle: Truck");
            System.out.println("Load Capacity: " + loadCapacity + " tonnes");
        }
    }

    static class Motorcycle extends Vehicle {
        private boolean hasSidecar;

        Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
            super(maxSpeed, fuelType);
            this.hasSidecar = hasSidecar;
        }

        @Override
        void displayInfo() {
            super.displayInfo();
            System.out.println("Vehicle: Motorcycle");
            System.out.println("Has Sidecar: " + hasSidecar);
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(180, "Petrol", 5),
                new Truck(120, "Diesel", 15.5),
                new Motorcycle(140, "Petrol", false)
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println("-------------------");
        }
    }
}