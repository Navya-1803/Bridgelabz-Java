package level2;

public class MovieTicketBookingSystem {

    static class MovieTicket {
        String movieName;
        String seatNumber;
        double price;

        // Initialize movie ticket details
        MovieTicket(String movieName) {
            this.movieName = movieName;
            this.seatNumber = "Not Assigned";
            this.price = 0.0;
        }

        // Book a ticket by assigning a seat and price
        void bookTicket(String seatNumber, double price) {
            if (seatNumber == null || seatNumber.trim().isEmpty()) {
                System.out.println("Invalid seat number.");
                return;
            }

            if (price <= 0) {
                System.out.println("Ticket price must be positive.");
                return;
            }

            this.seatNumber = seatNumber;
            this.price = price;

            System.out.println("Ticket booked successfully!");
        }

        // Display ticket details
        void displayTicketDetails() {
            System.out.println("Movie Name: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.printf("Ticket Price: INR %.2f%n", price);
        }
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Interstellar");

        ticket.bookTicket("A12", 250.00);
        ticket.displayTicketDetails();
    }
}
