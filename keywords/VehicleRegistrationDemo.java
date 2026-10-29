public class VehicleRegistrationDemo {

    static class RegisteredVehicleRecord {
        static double registrationFee = 5000.0;

        private String ownerName;
        private String vehicleType;
        private final String registrationNumber;

        RegisteredVehicleRecord(
                String ownerName, String vehicleType,
                String registrationNumber) {
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
            this.registrationNumber = registrationNumber;
        }

        static void updateRegistrationFee(double newFee) {
            if (newFee >= 0) {
                registrationFee = newFee;
            } else {
                System.out.println("Registration fee cannot be negative.");
            }
        }

        void displayDetails() {
            System.out.println("Owner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: "
                    + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        RegisteredVehicleRecord vehicle =
                new RegisteredVehicleRecord(
                        "Rahul", "Car", "TN01AB1234");

        RegisteredVehicleRecord.updateRegistrationFee(6000.0);

        Object obj = vehicle;

        if (obj instanceof RegisteredVehicleRecord) {
            ((RegisteredVehicleRecord) obj).displayDetails();
        }
    }
}