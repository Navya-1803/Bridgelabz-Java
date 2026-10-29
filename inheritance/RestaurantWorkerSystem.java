public class RestaurantWorkerSystem {

    // Interface defines a behavior that implementing classes must provide.
    interface Worker {
        void performDuties();
    }

    static class RestaurantPerson {
        protected String name;
        protected int id;

        RestaurantPerson(String name, int id) {
            this.name = name;
            this.id = id;
        }

        void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
        }
    }

    static class Chef extends RestaurantPerson implements Worker {
        private String specialty;

        Chef(String name, int id, String specialty) {
            super(name, id);
            this.specialty = specialty;
        }

        @Override
        public void performDuties() {
            System.out.println("Chef prepares food.");
            System.out.println("Specialty: " + specialty);
        }
    }

    static class Waiter extends RestaurantPerson implements Worker {
        private int tablesAssigned;

        Waiter(String name, int id, int tablesAssigned) {
            super(name, id);
            this.tablesAssigned = tablesAssigned;
        }

        @Override
        public void performDuties() {
            System.out.println("Waiter serves customers.");
            System.out.println("Tables Assigned: " + tablesAssigned);
        }
    }

    public static void main(String[] args) {
        Worker[] workers = {
                new Chef("Aman", 101, "Italian Cuisine"),
                new Waiter("Neha", 102, 5)
        };

        for (Worker worker : workers) {
            // Both objects implement Worker but perform different duties.
            if (worker instanceof RestaurantPerson) {
                ((RestaurantPerson) worker).displayDetails();
            }

            worker.performDuties();
            System.out.println("-------------------");
        }
    }
}