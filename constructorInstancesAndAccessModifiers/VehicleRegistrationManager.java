class RegisteredVehicle {
    String ownerName;
    String vehicleType;

    // Shared registration fee
    static double registrationFee = 5000.0;

    RegisteredVehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Display vehicle-specific details and the shared fee
    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: INR " + registrationFee);
    }

    // Update the registration fee for the class
    static void updateRegistrationFee(double newFee) {
        if (newFee >= 0) {
            registrationFee = newFee;
        } else {
            System.out.println("Registration fee cannot be negative.");
        }
    }
}

public class VehicleRegistrationManager {
    public static void main(String[] args) {
        RegisteredVehicle first =
                new RegisteredVehicle("Ananya", "Car");

        RegisteredVehicle second =
                new RegisteredVehicle("Rahul", "Motorcycle");

        first.displayVehicleDetails();
        System.out.println();

        RegisteredVehicle.updateRegistrationFee(6500.0);

        second.displayVehicleDetails();
    }
}