import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {

    interface Reservable {
        void reserveItem(String borrowerName);
        boolean checkAvailability();
    }

    static abstract class LibraryItem implements Reservable {
        private String itemId;
        private String title;
        private String author;
        private boolean available = true;
        private String borrowerName;

        LibraryItem(String itemId, String title, String author) {
            this.itemId = itemId;
            this.title = title;
            this.author = author;
        }

        abstract int getLoanDuration();

        void getItemDetails() {
            System.out.println("Item ID: " + itemId);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Loan Duration: "
                    + getLoanDuration() + " days");
            System.out.println("Available: " + available);
        }

        @Override
        public void reserveItem(String borrowerName) {
            if (available && borrowerName != null
                    && !borrowerName.isBlank()) {
                this.borrowerName = borrowerName;
                available = false;
                System.out.println("Item reserved successfully.");
            } else {
                System.out.println("Item unavailable or invalid borrower.");
            }
        }

        @Override
        public boolean checkAvailability() {
            return available;
        }

        public String getBorrowerName() {
            return borrowerName;
        }
    }

    static class Book extends LibraryItem {
        Book(String id, String title, String author) {
            super(id, title, author);
        }

        @Override
        int getLoanDuration() {
            return 14;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String id, String title, String author) {
            super(id, title, author);
        }

        @Override
        int getLoanDuration() {
            return 7;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String id, String title, String author) {
            super(id, title, author);
        }

        @Override
        int getLoanDuration() {
            return 3;
        }
    }

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book("B101", "Java Basics", "R. Kumar"));
        items.add(new Magazine("M201", "Science Today", "Editorial Team"));
        items.add(new DVD("D301", "Nature Film", "Documentary Studio"));

        for (LibraryItem item : items) {
            item.getItemDetails();
            item.reserveItem("Reader A");
            System.out.println("Available now: "
                    + item.checkAvailability());
            System.out.println("-------------------");
        }
    }
}