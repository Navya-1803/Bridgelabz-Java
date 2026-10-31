package TDD;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabInvoiceGenerator {

    // Step 5: Define the two ride categories.
    public enum RideType {
        NORMAL,
        PREMIUM
    }

    // Step 1: Store the distance, time and ride category.
    public static class Ride {

        private final double distance;
        private final int time;
        private final RideType rideType;

        public Ride(double distance, int time) {
            this(distance, time, RideType.NORMAL);
        }

        public Ride(double distance, int time, RideType rideType) {

            if (distance < 0 || time < 0) {
                throw new IllegalArgumentException(
                        "Distance and time cannot be negative."
                );
            }

            if (rideType == null) {
                throw new IllegalArgumentException(
                        "Ride type cannot be null."
                );
            }

            this.distance = distance;
            this.time = time;
            this.rideType = rideType;
        }

        public double getDistance() {
            return distance;
        }

        public int getTime() {
            return time;
        }

        public RideType getRideType() {
            return rideType;
        }
    }

    // Step 3: Store the invoice summary.
    public static class InvoiceSummary {

        private final int numberOfRides;
        private final double totalFare;
        private final double averageFare;

        public InvoiceSummary(
                int numberOfRides,
                double totalFare,
                double averageFare) {

            this.numberOfRides = numberOfRides;
            this.totalFare = totalFare;
            this.averageFare = averageFare;
        }

        public int getNumberOfRides() {
            return numberOfRides;
        }

        public double getTotalFare() {
            return totalFare;
        }

        public double getAverageFare() {
            return averageFare;
        }

        @Override
        public String toString() {

            return "Invoice Summary"
                    + "\nTotal Number of Rides: " + numberOfRides
                    + "\nTotal Fare: Rs. " + totalFare
                    + "\nAverage Fare Per Ride: Rs. " + averageFare;
        }
    }

    // Step 1, 2 and 5: Calculate fares for individual and multiple rides.
    public static class InvoiceGenerator {

        private static final double NORMAL_COST_PER_KM = 10.0;
        private static final double NORMAL_COST_PER_MINUTE = 1.0;
        private static final double NORMAL_MINIMUM_FARE = 5.0;

        private static final double PREMIUM_COST_PER_KM = 15.0;
        private static final double PREMIUM_COST_PER_MINUTE = 2.0;
        private static final double PREMIUM_MINIMUM_FARE = 20.0;

        // Calculate fare for a single ride.
        public double calculateFare(double distance, int time) {

            Ride ride = new Ride(distance, time);

            return calculateFare(ride);
        }

        // Calculate fare according to the ride category.
        public double calculateFare(Ride ride) {

            double costPerKm;
            double costPerMinute;
            double minimumFare;

            if (ride.getRideType() == RideType.PREMIUM) {

                costPerKm = PREMIUM_COST_PER_KM;
                costPerMinute = PREMIUM_COST_PER_MINUTE;
                minimumFare = PREMIUM_MINIMUM_FARE;

            } else {

                costPerKm = NORMAL_COST_PER_KM;
                costPerMinute = NORMAL_COST_PER_MINUTE;
                minimumFare = NORMAL_MINIMUM_FARE;
            }

            double totalFare =
                    ride.getDistance() * costPerKm
                            + ride.getTime() * costPerMinute;

            return Math.max(totalFare, minimumFare);
        }

        // Step 2: Calculate the total fare for multiple rides.
        public double calculateTotalFare(List<Ride> rides) {

            if (rides == null) {
                throw new IllegalArgumentException(
                        "Ride list cannot be null."
                );
            }

            double totalFare = 0;

            for (Ride ride : rides) {
                totalFare += calculateFare(ride);
            }

            return totalFare;
        }

        // Step 3: Generate an invoice summary for multiple rides.
        public InvoiceSummary calculateInvoice(List<Ride> rides) {

            if (rides == null) {
                throw new IllegalArgumentException(
                        "Ride list cannot be null."
                );
            }

            int numberOfRides = rides.size();

            if (numberOfRides == 0) {
                return new InvoiceSummary(0, 0, 0);
            }

            double totalFare = calculateTotalFare(rides);

            double averageFare = totalFare / numberOfRides;

            return new InvoiceSummary(
                    numberOfRides,
                    totalFare,
                    averageFare
            );
        }
    }

    // Step 4: Repository stores rides against a user ID.
    public static class RideRepository {

        private final Map<String, List<Ride>> userRides =
                new HashMap<>();

        // Add a ride for a particular user.
        public void addRide(String userId, Ride ride) {

            if (userId == null || userId.isBlank()) {
                throw new IllegalArgumentException(
                        "User ID cannot be empty."
                );
            }

            if (ride == null) {
                throw new IllegalArgumentException(
                        "Ride cannot be null."
                );
            }

            userRides.computeIfAbsent(
                    userId,
                    key -> new ArrayList<>()
            ).add(ride);
        }

        // Return all rides belonging to a particular user.
        public List<Ride> getRides(String userId) {

            if (userId == null || userId.isBlank()) {
                throw new IllegalArgumentException(
                        "User ID cannot be empty."
                );
            }

            return new ArrayList<>(
                    userRides.getOrDefault(userId, new ArrayList<>())
            );
        }
    }

    // Step 4: Invoice service gets rides from the repository.
    public static class InvoiceService {

        private final RideRepository rideRepository;
        private final InvoiceGenerator invoiceGenerator;

        public InvoiceService(
                RideRepository rideRepository,
                InvoiceGenerator invoiceGenerator) {

            if (rideRepository == null || invoiceGenerator == null) {
                throw new IllegalArgumentException(
                        "Repository and generator cannot be null."
                );
            }

            this.rideRepository = rideRepository;
            this.invoiceGenerator = invoiceGenerator;
        }

        // Generate an invoice for a particular user.
        public InvoiceSummary getInvoice(String userId) {

            List<Ride> rides = rideRepository.getRides(userId);

            return invoiceGenerator.calculateInvoice(rides);
        }
    }

    public static void main(String[] args) {

        InvoiceGenerator generator = new InvoiceGenerator();

        RideRepository repository = new RideRepository();

        InvoiceService invoiceService =
                new InvoiceService(repository, generator);

        // Add normal and premium rides for a user.
        repository.addRide(
                "USER101",
                new Ride(5.0, 10, RideType.NORMAL)
        );

        repository.addRide(
                "USER101",
                new Ride(10.0, 15, RideType.PREMIUM)
        );

        repository.addRide(
                "USER101",
                new Ride(2.0, 5, RideType.NORMAL)
        );

        // Generate and display the user's invoice.
        InvoiceSummary invoice =
                invoiceService.getInvoice("USER101");

        System.out.println(invoice);
    }
}

