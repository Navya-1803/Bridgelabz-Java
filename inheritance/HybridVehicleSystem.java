public class HybridVehicleSystem {

    interface Refuelable {
        void refuel();
    }

    static class TransportVehicle {
        protected int maxSpeed;
        protected String model;

        TransportVehicle(int maxSpeed, String model) {
            this.maxSpeed = maxSpeed;
            this.model = model;
        }

        void displayInfo() {
            System.out.println("Model: " + model);
            System.out.println("Maximum Speed: " + maxSpeed + " km/h");
        }
    }

    static class ElectricVehicle extends TransportVehicle {
        private int batteryCapacity;

        ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
            super(maxSpeed, model);
            this.batteryCapacity = batteryCapacity;
        }

        void charge() {
            System.out.println("Charging the electric vehicle.");
            System.out.println("Battery Capacity: "
                    + batteryCapacity + " kWh");
        }
    }

    static class PetrolVehicle extends TransportVehicle
            implements Refuelable {
        private double fuelCapacity;

        PetrolVehicle(String model, int maxSpeed, double fuelCapacity) {
            super(maxSpeed, model);
            this.fuelCapacity = fuelCapacity;
        }

        @Override
        public void refuel() {
            System.out.println("Refueling the petrol vehicle.");
            System.out.println("Fuel Capacity: " + fuelCapacity + " litres");
        }
    }

    public static void main(String[] args) {
        ElectricVehicle electricCar =
                new ElectricVehicle("EV-X", 160, 75);

        PetrolVehicle petrolCar =
                new PetrolVehicle("Petrol-Z", 180, 50);

        System.out.println("Electric Vehicle:");
        electricCar.displayInfo();
        electricCar.charge();

        System.out.println("\nPetrol Vehicle:");
        petrolCar.displayInfo();

        // Interface reference invokes the implementation in PetrolVehicle.
        Refuelable refuelableVehicle = petrolCar;
        refuelableVehicle.refuel();
    }
}