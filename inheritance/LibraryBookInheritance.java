public class LibraryBookInheritance {

    static class BookRecord {
        protected String title;
        protected int publicationYear;

        BookRecord(String title, int publicationYear) {
            this.title = title;
            this.publicationYear = publicationYear;
        }

        void displayInfo() {
            System.out.println("Book Title: " + title);
            System.out.println("Publication Year: " + publicationYear);
        }
    }

    static class AuthoredBook extends BookRecord {
        private String authorName;
        private String bio;

        AuthoredBook(String title, int publicationYear,
                     String authorName, String bio) {
            super(title, publicationYear);
            this.authorName = authorName;
            this.bio = bio;
        }

        @Override
        void displayInfo() {
            super.displayInfo();
            System.out.println("Author: " + authorName);
            System.out.println("Author Bio: " + bio);
        }
    }

    public static void main(String[] args) {
        AuthoredBook book = new AuthoredBook(
                "The Alchemist",
                1988,
                "Paulo Coelho",
                "A Brazilian novelist."
        );

        book.displayInfo();
    }
}