class Book {
    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Display book details
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: INR " + price);
    }
}

public class BookConstructorDemo {
    public static void main(String[] args) {
        Book defaultBook = new Book();
        Book customBook = new Book("Wings of Fire", "A. P. J. Abdul Kalam", 350);

        System.out.println("Default Book:");
        defaultBook.displayDetails();

        System.out.println("\nParameterized Book:");
        customBook.displayDetails();
    }
}