class LibraryAccessBook {
    public String ISBN;
    protected String title;
    private String author;

    LibraryAccessBook(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Getter for private author field
    public String getAuthor() {
        return author;
    }

    // Setter for private author field
    public void setAuthor(String author) {
        this.author = author;
    }
}

// Subclass accesses public ISBN and protected title
class ElectronicBook extends LibraryAccessBook {
    String fileFormat;

    ElectronicBook(String ISBN, String title, String author,
                   String fileFormat) {
        super(ISBN, title, author);
        this.fileFormat = fileFormat;
    }

    void displayEBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
        System.out.println("Format: " + fileFormat);
    }
}

public class BookLibraryAccessDemo {
    public static void main(String[] args) {
        ElectronicBook book = new ElectronicBook(
                "9781234567890",
                "Java Basics",
                "R. Sharma",
                "PDF"
        );

        book.displayEBookDetails();

        // Update private author through the public setter
        book.setAuthor("R. Kumar");

        System.out.println("\nAfter updating author:");
        System.out.println("Author: " + book.getAuthor());
    }
}