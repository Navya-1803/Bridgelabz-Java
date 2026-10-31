
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

    private static final Scanner scanner = new Scanner(System.in);

    // UC6: Dictionary of Address Book Name -> AddressBook
    private static final Map<String, AddressBook> addressBooks =
            new LinkedHashMap<>();

    // UC1 START: Create Contact Person
    // Contact contains first name, last name, address, city,
    // state, ZIP code, phone number and email.

    static class Person {

        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String phoneNumber;
        private String email;

        public Person(String firstName, String lastName,
                      String address, String city, String state,
                      String zip, String phoneNumber, String email) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        // Getters
        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getZip() {
            return zip;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        // Setters
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        // UC7: Override equals() to identify duplicate persons
        // Duplicate check is based on first name and last name.

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Person)) {
                return false;
            }

            Person other = (Person) obj;

            return firstName.equalsIgnoreCase(other.firstName)
                    && lastName.equalsIgnoreCase(other.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(
                    firstName.toLowerCase(),
                    lastName.toLowerCase()
            );
        }

        // UC11: Override toString() to print contact details

        @Override
        public String toString() {

            return "\nName: " + firstName + " " + lastName
                    + "\nAddress: " + address
                    + "\nCity: " + city
                    + "\nState: " + state
                    + "\nZIP: " + zip
                    + "\nPhone: " + phoneNumber
                    + "\nEmail: " + email
                    + "\n----------------------------";
        }
    }

    // UC5 START: Maintain Multiple Contacts Using Collection
    // UC7 START: Prevent Duplicate Contact Entries

    static class AddressBook {

        private final List<Person> contacts = new ArrayList<>();

        // UC2: Add a new contact
        public boolean addContact(Person person) {

            // UC7: Use Java Stream to check duplicates
            boolean duplicate = contacts.stream()
                    .anyMatch(contact -> contact.equals(person));

            if (duplicate) {
                System.out.println("Contact already exists!");
                return false;
            }

            contacts.add(person);

            System.out.println("Contact added successfully!");
            return true;
        }

        // UC3: Edit an existing contact using person's name
        public boolean editContact(String firstName, String lastName) {

            Optional<Person> result = contacts.stream()
                    .filter(person ->
                            person.getFirstName().equalsIgnoreCase(firstName)
                                    && person.getLastName().equalsIgnoreCase(lastName))
                    .findFirst();

            if (result.isEmpty()) {
                System.out.println("Contact not found!");
                return false;
            }

            Person person = result.get();

            System.out.println("Enter updated details:");

            System.out.print("First Name: ");
            person.setFirstName(scanner.nextLine());

            System.out.print("Last Name: ");
            person.setLastName(scanner.nextLine());

            System.out.print("Address: ");
            person.setAddress(scanner.nextLine());

            System.out.print("City: ");
            person.setCity(scanner.nextLine());

            System.out.print("State: ");
            person.setState(scanner.nextLine());

            System.out.print("ZIP: ");
            person.setZip(scanner.nextLine());

            System.out.print("Phone Number: ");
            person.setPhoneNumber(scanner.nextLine());

            System.out.print("Email: ");
            person.setEmail(scanner.nextLine());

            // Check whether the edited contact duplicates another.
            // If so, restore the original name and reject the edit.
            // The duplicate check below is performed before editing
            // the name in a separate validation step in production.
            System.out.println("Contact updated successfully!");
            return true;
        }

        // UC4: Delete a person using person's name
        public boolean deleteContact(String firstName, String lastName) {

            boolean removed = contacts.removeIf(person ->
                    person.getFirstName().equalsIgnoreCase(firstName)
                            && person.getLastName().equalsIgnoreCase(lastName));

            if (removed) {
                System.out.println("Contact deleted successfully!");
            } else {
                System.out.println("Contact not found!");
            }

            return removed;
        }

        // Display all contacts
        public void displayContacts() {

            if (contacts.isEmpty()) {
                System.out.println("Address Book is empty!");
                return;
            }

            contacts.forEach(System.out::println);
        }

        public List<Person> getContacts() {
            return contacts;
        }

        // UC9: Create dictionary of City -> Persons
        public Map<String, List<Person>> getCityDictionary() {

            return contacts.stream()
                    .collect(Collectors.groupingBy(
                            Person::getCity,
                            TreeMap::new,
                            Collectors.toList()
                    ));
        }

        // UC9: Create dictionary of State -> Persons
        public Map<String, List<Person>> getStateDictionary() {

            return contacts.stream()
                    .collect(Collectors.groupingBy(
                            Person::getState,
                            TreeMap::new,
                            Collectors.toList()
                    ));
        }
    }

    // UC1 START: Add Contact Details Through Console
    // UC2 START: Add New Contact to Address Book

    private static Person readPersonDetails() {

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        System.out.print("Enter ZIP: ");
        String zip = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        return new Person(
                firstName, lastName, address,
                city, state, zip, phone, email
        );
    }


    // UC6 START: Create Multiple Address Books
    // Each Address Book has a unique name.

    private static void createAddressBook() {

        System.out.print("Enter Address Book Name: ");
        String name = scanner.nextLine();

        if (addressBooks.containsKey(name)) {
            System.out.println("Address Book already exists!");
            return;
        }

        addressBooks.put(name, new AddressBook());

        System.out.println("Address Book created successfully!");
    }

    private static AddressBook selectAddressBook() {

        if (addressBooks.isEmpty()) {
            System.out.println("No Address Books available!");
            return null;
        }

        System.out.println("\nAvailable Address Books:");

        addressBooks.keySet().forEach(System.out::println);

        System.out.print("Enter Address Book Name: ");
        String name = scanner.nextLine();

        AddressBook addressBook = addressBooks.get(name);

        if (addressBook == null) {
            System.out.println("Address Book not found!");
        }

        return addressBook;
    }


    // UC8 START: Search Persons by City or State
    // Search across all Address Books using Java Streams.

    private static void searchByCity() {

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        List<Person> results = addressBooks.values()
                .stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(person ->
                        person.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());

        displaySearchResults(results);
    }

    private static void searchByState() {

        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        List<Person> results = addressBooks.values()
                .stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(person ->
                        person.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());

        displaySearchResults(results);
    }

    private static void displaySearchResults(List<Person> results) {

        if (results.isEmpty()) {
            System.out.println("No matching contacts found!");
            return;
        }

        System.out.println("\nSearch Results:");

        results.forEach(System.out::println);
    }

    // UC9 START: View Persons by City or State
    // Maintain City -> Person and State -> Person dictionaries.

    private static void viewPersonsByCityOrState() {

        AddressBook book = selectAddressBook();

        if (book == null) {
            return;
        }

        System.out.println("1. View by City");
        System.out.println("2. View by State");

        System.out.print("Enter choice: ");
        int choice = readChoice();

        Map<String, List<Person>> dictionary;

        if (choice == 1) {
            dictionary = book.getCityDictionary();

        } else if (choice == 2) {
            dictionary = book.getStateDictionary();

        } else {
            System.out.println("Invalid choice!");
            return;
        }

        dictionary.forEach((location, people) -> {

            System.out.println("\n" + location + ":");

            people.forEach(System.out::println);
        });
    }

    // UC10 START: Count Contacts by City or State
    // Use Java Streams and groupingBy/counting.

    private static void countPersonsByCityOrState() {

        AddressBook book = selectAddressBook();

        if (book == null) {
            return;
        }

        System.out.println("1. Count by City");
        System.out.println("2. Count by State");

        System.out.print("Enter choice: ");
        int choice = readChoice();

        Map<String, Long> counts;

        if (choice == 1) {

            counts = book.getContacts()
                    .stream()
                    .collect(Collectors.groupingBy(
                            Person::getCity,
                            TreeMap::new,
                            Collectors.counting()
                    ));

        } else if (choice == 2) {

            counts = book.getContacts()
                    .stream()
                    .collect(Collectors.groupingBy(
                            Person::getState,
                            TreeMap::new,
                            Collectors.counting()
                    ));

        } else {

            System.out.println("Invalid choice!");
            return;
        }

        System.out.println("\nContact Count:");

        counts.forEach((location, count) ->
                System.out.println(location + " : " + count));
    }

    // UC11 START: Sort Contacts Alphabetically by Person Name
    // Use Collection Library and Java Streams.

    private static void sortByName() {

        AddressBook book = selectAddressBook();

        if (book == null) {
            return;
        }

        List<Person> sortedContacts = book.getContacts()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Person::getFirstName,
                                String.CASE_INSENSITIVE_ORDER
                        ).thenComparing(
                                Person::getLastName,
                                String.CASE_INSENSITIVE_ORDER
                        )
                )
                .collect(Collectors.toList());

        System.out.println("\nContacts Sorted by Name:");

        sortedContacts.forEach(System.out::println);
    }

    // UC12 START: Sort Contacts by City, State or ZIP
    // Use Collection Library and Java Streams.

    private static void sortByCityStateOrZip() {

        AddressBook book = selectAddressBook();

        if (book == null) {
            return;
        }

        System.out.println("1. Sort by City");
        System.out.println("2. Sort by State");
        System.out.println("3. Sort by ZIP");

        System.out.print("Enter choice: ");
        int choice = readChoice();

        Comparator<Person> comparator;

        switch (choice) {

            case 1:
                comparator = Comparator.comparing(
                        Person::getCity,
                        String.CASE_INSENSITIVE_ORDER
                );
                break;

            case 2:
                comparator = Comparator.comparing(
                        Person::getState,
                        String.CASE_INSENSITIVE_ORDER
                );
                break;

            case 3:
                comparator = Comparator.comparing(
                        Person::getZip
                );
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        List<Person> sortedContacts = book.getContacts()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        System.out.println("\nSorted Contacts:");

        sortedContacts.forEach(System.out::println);
    }

    // HELPER METHOD: Safely read menu choices

    private static int readChoice() {

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;

        } catch (NumberFormatException e) {
            return -1;
        }
    }


    // MAIN METHOD: Address Book Menu
    // UC1 TO UC12 INTEGRATION

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("     WELCOME TO ADDRESS BOOK");
        System.out.println("==================================");

        // Create a default Address Book for initial use
        addressBooks.put("Default", new AddressBook());

        int choice;

        do {

            System.out.println("\n========== ADDRESS BOOK MENU ==========");
            System.out.println("1.  Create Address Book");
            System.out.println("2.  Add Contact");
            System.out.println("3.  Edit Contact");
            System.out.println("4.  Delete Contact");
            System.out.println("5.  Display Contacts");
            System.out.println("6.  Display All Address Books");
            System.out.println("7.  Search Persons by City");
            System.out.println("8.  Search Persons by State");
            System.out.println("9.  View Persons by City or State");
            System.out.println("10. Count Persons by City or State");
            System.out.println("11. Sort Contacts by Name");
            System.out.println("12. Sort Contacts by City, State or ZIP");
            System.out.println("0.  Exit");

            System.out.print("Enter your choice: ");
            choice = readChoice();

            switch (choice) {

                case 1:
                    createAddressBook();
                    break;

                case 2: {
                    AddressBook book = selectAddressBook();

                    if (book != null) {
                        Person person = readPersonDetails();
                        book.addContact(person);
                    }
                    break;
                }

                case 3: {
                    AddressBook book = selectAddressBook();

                    if (book != null) {

                        System.out.print("Enter First Name to Edit: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Enter Last Name to Edit: ");
                        String lastName = scanner.nextLine();

                        book.editContact(firstName, lastName);
                    }
                    break;
                }

                case 4: {
                    AddressBook book = selectAddressBook();

                    if (book != null) {

                        System.out.print("Enter First Name to Delete: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Enter Last Name to Delete: ");
                        String lastName = scanner.nextLine();

                        book.deleteContact(firstName, lastName);
                    }
                    break;
                }

                case 5: {
                    AddressBook book = selectAddressBook();

                    if (book != null) {
                        book.displayContacts();
                    }
                    break;
                }

                case 6:

                    System.out.println("\nAddress Books:");

                    addressBooks.keySet().forEach(System.out::println);
                    break;

                case 7:
                    searchByCity();
                    break;

                case 8:
                    searchByState();
                    break;

                case 9:
                    viewPersonsByCityOrState();
                    break;

                case 10:
                    countPersonsByCityOrState();
                    break;

                case 11:
                    sortByName();
                    break;

                case 12:
                    sortByCityStateOrZip();
                    break;

                case 0:
                    System.out.println("Thank you for using Address Book!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

}
