class CarRental {
    String customerName;
    String carModel;
    int rentalDays;

    // Default constructor
    CarRental() {
        this("Guest", "Not Selected", 0);
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Calculate rental cost using the assumed daily rate
    double calculateTotalCost() {
        double dailyRate = 2000.0;
        return dailyRate * rentalDays;
    }

    void displayDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.printf("Total Cost: INR %.2f%n", calculateTotalCost());
    }
}

public class CarRentalCostDemo {
    public static void main(String[] args) {
        CarRental rental = new CarRental("Aman", "Honda City", 4);
        rental.displayDetails();
    }
}