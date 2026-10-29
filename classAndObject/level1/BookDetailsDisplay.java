package level1;

class Book {
    String title;
    String author;
    double price;

    // Constructor to initialize book details
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Display book information
    void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: INR " + price);
    }
}

public class BookDetailsDisplay {
    public static void main(String[] args) {
        Book book = new Book(
                "Wings of Fire",
                "A. P. J. Abdul Kalam",
                350.00
        );

        book.displayDetails();
    }
}
