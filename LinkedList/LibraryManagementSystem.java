public class LibraryManagementSystem {

    static class Book {
        String title;
        String author;
        String genre;
        int bookId;
        boolean available;
        Book prev;
        Book next;

        Book(String title, String author, String genre, int bookId) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.available = true;
        }
    }

    static class BookList {
        private Book head;
        private Book tail;
        private int size;

        void addFirst(String title, String author, String genre, int id) {
            Book book = new Book(title, author, genre, id);

            if (head == null) {
                head = tail = book;
            } else {
                book.next = head;
                head.prev = book;
                head = book;
            }

            size++;
        }

        void addLast(String title, String author, String genre, int id) {
            Book book = new Book(title, author, genre, id);

            if (tail == null) {
                head = tail = book;
            } else {
                tail.next = book;
                book.prev = tail;
                tail = book;
            }

            size++;
        }

        // Positions are 1-based.
        void addAtPosition(int position, String title, String author,
                           String genre, int id) {
            if (position < 1 || position > size + 1) {
                System.out.println("Invalid position.");
                return;
            }

            if (position == 1) {
                addFirst(title, author, genre, id);
                return;
            }

            if (position == size + 1) {
                addLast(title, author, genre, id);
                return;
            }

            Book current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }

            Book book = new Book(title, author, genre, id);
            book.prev = current.prev;
            book.next = current;
            current.prev.next = book;
            current.prev = book;
            size++;
        }

        void removeById(int id) {
            Book book = head;

            while (book != null && book.bookId != id) {
                book = book.next;
            }

            if (book == null) {
                System.out.println("Book not found.");
                return;
            }

            if (book.prev != null) {
                book.prev.next = book.next;
            } else {
                head = book.next;
            }

            if (book.next != null) {
                book.next.prev = book.prev;
            } else {
                tail = book.prev;
            }

            size--;
            System.out.println("Book removed.");
        }

        void searchByTitle(String title) {
            boolean found = false;

            for (Book book = head; book != null; book = book.next) {
                if (book.title.equalsIgnoreCase(title)) {
                    printBook(book);
                    found = true;
                }
            }

            if (!found) System.out.println("Book not found.");
        }

        void searchByAuthor(String author) {
            boolean found = false;

            for (Book book = head; book != null; book = book.next) {
                if (book.author.equalsIgnoreCase(author)) {
                    printBook(book);
                    found = true;
                }
            }

            if (!found) System.out.println("No books found for this author.");
        }

        void updateAvailability(int id, boolean available) {
            Book book = head;

            while (book != null && book.bookId != id) {
                book = book.next;
            }

            if (book == null) {
                System.out.println("Book not found.");
            } else {
                book.available = available;
                System.out.println("Availability updated.");
            }
        }

        int countBooks() {
            return size;
        }

        void displayForward() {
            for (Book book = head; book != null; book = book.next) {
                printBook(book);
            }
        }

        void displayReverse() {
            for (Book book = tail; book != null; book = book.prev) {
                printBook(book);
            }
        }

        private void printBook(Book book) {
            System.out.println(
                    "ID: " + book.bookId
                            + ", Title: " + book.title
                            + ", Author: " + book.author
                            + ", Genre: " + book.genre
                            + ", Available: " + book.available
            );
        }
    }

    public static void main(String[] args) {
        BookList library = new BookList();

        library.addFirst("The Hobbit", "J.R.R. Tolkien", "Fantasy", 101);
        library.addLast("1984", "George Orwell", "Dystopian", 102);
        library.addAtPosition(2, "Dune", "Frank Herbert", "Sci-Fi", 103);

        System.out.println("Forward:");
        library.displayForward();

        System.out.println("\nReverse:");
        library.displayReverse();

        System.out.println("\nSearch by author:");
        library.searchByAuthor("George Orwell");

        library.updateAvailability(101, false);
        library.removeById(103);

        System.out.println("\nTotal books: " + library.countBooks());
    }
}