class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        this("Guest", "Standard", 1);
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking other) {
        this(other.guestName, other.roomType, other.nights);
    }

    void displayBooking() {
        System.out.println("Guest: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }
}

public class HotelBookingConstructorDemo {
    public static void main(String[] args) {
        HotelBooking defaultBooking = new HotelBooking();
        HotelBooking booking = new HotelBooking("Riya", "Deluxe", 3);
        HotelBooking copiedBooking = new HotelBooking(booking);

        System.out.println("Default Booking:");
        defaultBooking.displayBooking();

        System.out.println("\nOriginal Booking:");
        booking.displayBooking();

        System.out.println("\nCopied Booking:");
        copiedBooking.displayBooking();
    }
}
