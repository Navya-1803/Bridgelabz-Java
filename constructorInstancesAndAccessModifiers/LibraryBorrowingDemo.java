class LibraryBook {
    String title;
    String author;
    double price;
    boolean availability;

    LibraryBook(String title, String author, double price,
                boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    // Borrow the book only if it is available
    void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is currently unavailable.");
        }
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: INR " + price);
        System.out.println("Available: " + availability);
    }
}

public class LibraryBorrowingDemo {
    public static void main(String[] args) {
        LibraryBook book = new LibraryBook(
                "The Alchemist", "Paulo Coelho", 299.0, true);

        book.displayDetails();

        System.out.println("\nBorrowing book:");
        book.borrowBook();

        System.out.println("\nUpdated Details:");
        book.displayDetails();
    }
}