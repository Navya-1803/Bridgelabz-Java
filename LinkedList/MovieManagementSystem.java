public class MovieManagementSystem {

    static class Movie {
        String title;
        String director;
        int year;
        double rating;
        Movie prev;
        Movie next;

        Movie(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    static class MovieList {
        private Movie head;
        private Movie tail;
        private int size;

        private void linkBetween(Movie node, Movie before, Movie after) {
            node.prev = before;
            node.next = after;

            if (before != null) {
                before.next = node;
            } else {
                head = node;
            }

            if (after != null) {
                after.prev = node;
            } else {
                tail = node;
            }

            size++;
        }

        void addFirst(String title, String director,
                      int year, double rating) {
            linkBetween(new Movie(title, director, year, rating),
                    null, head);
        }

        void addLast(String title, String director,
                     int year, double rating) {
            linkBetween(new Movie(title, director, year, rating),
                    tail, null);
        }

        // Positions are 1-based.
        void addAtPosition(int position, String title, String director,
                           int year, double rating) {
            if (position < 1 || position > size + 1) {
                System.out.println("Invalid position.");
                return;
            }

            if (position == 1) {
                addFirst(title, director, year, rating);
                return;
            }

            if (position == size + 1) {
                addLast(title, director, year, rating);
                return;
            }

            Movie current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }

            linkBetween(new Movie(title, director, year, rating),
                    current.prev, current);
        }

        void removeByTitle(String title) {
            Movie movie = findByTitle(title);

            if (movie == null) {
                System.out.println("Movie not found.");
                return;
            }

            if (movie.prev != null) {
                movie.prev.next = movie.next;
            } else {
                head = movie.next;
            }

            if (movie.next != null) {
                movie.next.prev = movie.prev;
            } else {
                tail = movie.prev;
            }

            size--;
            System.out.println("Movie removed.");
        }

        private Movie findByTitle(String title) {
            Movie current = head;

            while (current != null) {
                if (current.title.equalsIgnoreCase(title)) {
                    return current;
                }
                current = current.next;
            }

            return null;
        }

        void searchByDirector(String director) {
            boolean found = false;

            for (Movie current = head; current != null;
                 current = current.next) {
                if (current.director.equalsIgnoreCase(director)) {
                    printMovie(current);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No movies found for this director.");
            }
        }

        void searchByRating(double rating) {
            boolean found = false;

            for (Movie current = head; current != null;
                 current = current.next) {
                if (Double.compare(current.rating, rating) == 0) {
                    printMovie(current);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No movies found with this rating.");
            }
        }

        void updateRating(String title, double rating) {
            if (rating < 0 || rating > 10) {
                System.out.println("Rating must be between 0 and 10.");
                return;
            }

            Movie movie = findByTitle(title);

            if (movie == null) {
                System.out.println("Movie not found.");
            } else {
                movie.rating = rating;
                System.out.println("Rating updated.");
            }
        }

        private void printMovie(Movie movie) {
            System.out.println(
                    movie.title + " | " + movie.director
                            + " | " + movie.year + " | Rating: " + movie.rating
            );
        }

        void displayForward() {
            for (Movie current = head; current != null;
                 current = current.next) {
                printMovie(current);
            }
        }

        void displayReverse() {
            for (Movie current = tail; current != null;
                 current = current.prev) {
                printMovie(current);
            }
        }
    }

    public static void main(String[] args) {
        MovieList movies = new MovieList();

        movies.addFirst("Inception", "Christopher Nolan", 2010, 8.8);
        movies.addLast("Interstellar", "Christopher Nolan", 2014, 8.7);
        movies.addAtPosition(2, "Joker", "Todd Phillips", 2019, 8.4);

        System.out.println("Forward:");
        movies.displayForward();

        System.out.println("\nReverse:");
        movies.displayReverse();

        System.out.println("\nSearch by director:");
        movies.searchByDirector("Christopher Nolan");

        movies.updateRating("Joker", 8.5);
        movies.removeByTitle("Inception");

        System.out.println("\nAfter modifications:");
        movies.displayForward();
    }
}