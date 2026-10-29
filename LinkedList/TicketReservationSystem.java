import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketReservationSystem {

    static class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        Ticket(int ticketId, String customerName, String movieName,
               String seatNumber) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;

            // Record the booking time automatically.
            this.bookingTime = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );
        }
    }

    static class TicketList {
        private Ticket head;
        private Ticket tail;
        private int size;

        // Add a ticket at the end of the circular list.
        void bookTicket(int id, String customer, String movie, String seat) {
            if (findById(id) != null) {
                System.out.println("Ticket ID already exists.");
                return;
            }

            Ticket ticket = new Ticket(id, customer, movie, seat);

            if (head == null) {
                head = tail = ticket;
                ticket.next = head;
            } else {
                ticket.next = head;
                tail.next = ticket;
                tail = ticket;
            }

            size++;
            System.out.println("Ticket booked successfully.");
        }

        void cancelTicket(int id) {
            if (head == null) {
                System.out.println("No tickets booked.");
                return;
            }

            Ticket previous = tail;
            Ticket current = head;

            do {
                if (current.ticketId == id) {
                    if (size == 1) {
                        head = tail = null;
                    } else {
                        previous.next = current.next;

                        if (current == head) {
                            head = current.next;
                        }

                        if (current == tail) {
                            tail = previous;
                        }

                        tail.next = head;
                    }

                    size--;
                    System.out.println("Ticket cancelled.");
                    return;
                }

                previous = current;
                current = current.next;
            } while (current != head);

            System.out.println("Ticket not found.");
        }

        Ticket findById(int id) {
            if (head == null) return null;

            Ticket current = head;

            do {
                if (current.ticketId == id) return current;
                current = current.next;
            } while (current != head);

            return null;
        }

        void searchByCustomer(String customerName) {
            if (head == null) {
                System.out.println("No bookings.");
                return;
            }

            boolean found = false;
            Ticket current = head;

            do {
                if (current.customerName.equalsIgnoreCase(customerName)) {
                    printTicket(current);
                    found = true;
                }

                current = current.next;
            } while (current != head);

            if (!found) System.out.println("No tickets for this customer.");
        }

        void searchByMovie(String movieName) {
            if (head == null) {
                System.out.println("No bookings.");
                return;
            }

            boolean found = false;
            Ticket current = head;

            do {
                if (current.movieName.equalsIgnoreCase(movieName)) {
                    printTicket(current);
                    found = true;
                }

                current = current.next;
            } while (current != head);

            if (!found) System.out.println("No bookings for this movie.");
        }

        void displayTickets() {
            if (head == null) {
                System.out.println("No tickets booked.");
                return;
            }

            Ticket current = head;

            do {
                printTicket(current);
                current = current.next;
            } while (current != head);
        }

        int countTickets() {
            return size;
        }

        private void printTicket(Ticket ticket) {
            System.out.println(
                    "Ticket ID: " + ticket.ticketId
                            + ", Customer: " + ticket.customerName
                            + ", Movie: " + ticket.movieName
                            + ", Seat: " + ticket.seatNumber
                            + ", Booking Time: " + ticket.bookingTime
            );
        }
    }

    public static void main(String[] args) {
        TicketList tickets = new TicketList();

        tickets.bookTicket(101, "Ananya", "Inception", "A1");
        tickets.bookTicket(102, "Rahul", "Interstellar", "B3");
        tickets.bookTicket(103, "Priya", "Inception", "A2");

        System.out.println("\nAll tickets:");
        tickets.displayTickets();

        System.out.println("\nSearch by customer:");
        tickets.searchByCustomer("Ananya");

        System.out.println("\nSearch by movie:");
        tickets.searchByMovie("Inception");

        System.out.println("\nTotal booked tickets: "
                + tickets.countTickets());

        tickets.cancelTicket(102);

        System.out.println("\nTickets after cancellation:");
        tickets.displayTickets();

        System.out.println("\nUpdated count: " + tickets.countTickets());
    }
}