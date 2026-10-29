public class LibraryManagementDemo {

    static class LibraryBookRecord {
        static String libraryName = "Central Public Library";

        private String title;
        private String author;
        private final String isbn;

        LibraryBookRecord(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        static void displayLibraryName() {
            System.out.println("Library: " + libraryName);
        }

        void displayDetails() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    public static void main(String[] args) {
        LibraryBookRecord book =
                new LibraryBookRecord(
                        "The Alchemist", "Paulo Coelho", "ISBN101");

        LibraryBookRecord.displayLibraryName();

        Object item = book;

        if (item instanceof LibraryBookRecord) {
            ((LibraryBookRecord) item).displayDetails();
        }
    }
}