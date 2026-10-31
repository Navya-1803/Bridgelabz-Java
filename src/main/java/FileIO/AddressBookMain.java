package FileIO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AddressBookMain {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String DEFAULT_FILE = "addressbook-data.txt";

    private final Map<String, AddressBook> addressBooks =
            new LinkedHashMap<>();

    // UC1: Create a contact person with all required details.
    public static class ContactPerson {

        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String phoneNumber;
        private String email;

        public ContactPerson(
                String firstName,
                String lastName,
                String address,
                String city,
                String state,
                String zip,
                String phoneNumber,
                String email) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

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

        // UC7: Compare contacts by first name and last name.
        @Override
        public boolean equals(Object object) {

            if (this == object) {
                return true;
            }

            if (!(object instanceof ContactPerson)) {
                return false;
            }

            ContactPerson other = (ContactPerson) object;

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

        // UC11: Display contact details in a readable format.
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

    // UC5: Maintain multiple contacts in one address book.
    public static class AddressBook {

        private final List<ContactPerson> contacts = new ArrayList<>();

        // UC2 and UC7: Add a contact after checking for duplicates.
        public boolean addContact(ContactPerson person) {

            boolean exists = contacts.stream()
                    .anyMatch(contact -> contact.equals(person));

            if (exists) {
                return false;
            }

            contacts.add(person);
            return true;
        }

        // UC3: Find a contact by name and update its details.
        public boolean editContact(
                String firstName,
                String lastName,
                ContactPerson updatedPerson) {

            for (int i = 0; i < contacts.size(); i++) {

                ContactPerson existing = contacts.get(i);

                if (existing.getFirstName().equalsIgnoreCase(firstName)
                        && existing.getLastName().equalsIgnoreCase(lastName)) {

                    boolean duplicate = contacts.stream()
                            .filter(contact -> contact != existing)
                            .anyMatch(contact -> contact.equals(updatedPerson));

                    if (duplicate) {
                        return false;
                    }

                    contacts.set(i, updatedPerson);
                    return true;
                }
            }

            return false;
        }

        // UC4: Delete a contact using the person's name.
        public boolean deleteContact(String firstName, String lastName) {

            return contacts.removeIf(person ->
                    person.getFirstName().equalsIgnoreCase(firstName)
                            && person.getLastName().equalsIgnoreCase(lastName));
        }

        public List<ContactPerson> getContacts() {
            return new ArrayList<>(contacts);
        }

        // UC8: Search contacts by city.
        public List<ContactPerson> searchByCity(String city) {

            return contacts.stream()
                    .filter(person ->
                            person.getCity().equalsIgnoreCase(city))
                    .collect(Collectors.toList());
        }

        // UC8: Search contacts by state.
        public List<ContactPerson> searchByState(String state) {

            return contacts.stream()
                    .filter(person ->
                            person.getState().equalsIgnoreCase(state))
                    .collect(Collectors.toList());
        }

        // UC9: Create a dictionary of city and associated contacts.
        public Map<String, List<ContactPerson>> getCityDictionary() {

            return contacts.stream()
                    .collect(Collectors.groupingBy(
                            ContactPerson::getCity,
                            TreeMap::new,
                            Collectors.toList()
                    ));
        }

        // UC9: Create a dictionary of state and associated contacts.
        public Map<String, List<ContactPerson>> getStateDictionary() {

            return contacts.stream()
                    .collect(Collectors.groupingBy(
                            ContactPerson::getState,
                            TreeMap::new,
                            Collectors.toList()
                    ));
        }

        // UC10: Count contacts grouped by city.
        public Map<String, Long> countByCity() {

            return contacts.stream()
                    .collect(Collectors.groupingBy(
                            ContactPerson::getCity,
                            TreeMap::new,
                            Collectors.counting()
                    ));
        }

        // UC10: Count contacts grouped by state.
        public Map<String, Long> countByState() {

            return contacts.stream()
                    .collect(Collectors.groupingBy(
                            ContactPerson::getState,
                            TreeMap::new,
                            Collectors.counting()
                    ));
        }

        // UC11: Sort contacts alphabetically by first and last name.
        public List<ContactPerson> sortByName() {

            return contacts.stream()
                    .sorted(
                            Comparator.comparing(
                                    ContactPerson::getFirstName,
                                    String.CASE_INSENSITIVE_ORDER
                            ).thenComparing(
                                    ContactPerson::getLastName,
                                    String.CASE_INSENSITIVE_ORDER
                            )
                    )
                    .collect(Collectors.toList());
        }

        // UC12: Sort contacts by city.
        public List<ContactPerson> sortByCity() {

            return contacts.stream()
                    .sorted(Comparator.comparing(
                            ContactPerson::getCity,
                            String.CASE_INSENSITIVE_ORDER
                    ))
                    .collect(Collectors.toList());
        }

        // UC12: Sort contacts by state.
        public List<ContactPerson> sortByState() {

            return contacts.stream()
                    .sorted(Comparator.comparing(
                            ContactPerson::getState,
                            String.CASE_INSENSITIVE_ORDER
                    ))
                    .collect(Collectors.toList());
        }

        // UC12: Sort contacts by ZIP code.
        public List<ContactPerson> sortByZip() {

            return contacts.stream()
                    .sorted(Comparator.comparing(ContactPerson::getZip))
                    .collect(Collectors.toList());
        }
    }

    // UC6: Create a new address book with a unique name.
    public boolean createAddressBook(String name) {

        if (name == null || name.isBlank()
                || addressBooks.containsKey(name)) {
            return false;
        }

        addressBooks.put(name, new AddressBook());
        return true;
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public Map<String, AddressBook> getAddressBooks() {
        return new LinkedHashMap<>(addressBooks);
    }

    // UC7: Add a contact to a particular address book.
    public boolean addContact(String bookName, ContactPerson person) {

        AddressBook book = addressBooks.get(bookName);

        if (book == null) {
            return false;
        }

        return book.addContact(person);
    }

    // UC8: Search contacts by city across all address books.
    public List<ContactPerson> searchAcrossBooksByCity(String city) {

        return addressBooks.values()
                .stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(person ->
                        person.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    // UC8: Search contacts by state across all address books.
    public List<ContactPerson> searchAcrossBooksByState(String state) {

        return addressBooks.values()
                .stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(person ->
                        person.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    // UC13: Encode contact fields so that delimiters and special
    // characters in names or addresses do not break the file format.
    private String encode(String value) {

        return Base64.getEncoder().encodeToString(
                value.getBytes(StandardCharsets.UTF_8)
        );
    }

    private String decode(String value) {

        return new String(
                Base64.getDecoder().decode(value),
                StandardCharsets.UTF_8
        );
    }

    // UC13: Write all address books and their contacts to a file.
    public void writeAddressBooksToFile(String filePath)
            throws IOException {

        List<String> lines = new ArrayList<>();

        for (Map.Entry<String, AddressBook> entry :
                addressBooks.entrySet()) {

            String bookName = encode(entry.getKey());

            for (ContactPerson person : entry.getValue().getContacts()) {

                String line = String.join("|",
                        bookName,
                        encode(person.getFirstName()),
                        encode(person.getLastName()),
                        encode(person.getAddress()),
                        encode(person.getCity()),
                        encode(person.getState()),
                        encode(person.getZip()),
                        encode(person.getPhoneNumber()),
                        encode(person.getEmail())
                );

                lines.add(line);
            }
        }

        Path path = Paths.get(filePath);

        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    // UC13: Read address books and contacts from a file.
    // Existing in-memory address books are replaced by file contents.
    public void readAddressBooksFromFile(String filePath)
            throws IOException {

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            throw new IOException("Address book file does not exist.");
        }

        Map<String, AddressBook> loadedBooks = new LinkedHashMap<>();

        List<String> lines = Files.readAllLines(
                path,
                StandardCharsets.UTF_8
        );

        for (String line : lines) {

            if (line.isBlank()) {
                continue;
            }

            String[] fields = line.split("\\|", -1);

            if (fields.length != 9) {
                throw new IOException("Invalid address book file format.");
            }

            try {

                String bookName = decode(fields[0]);

                ContactPerson person = new ContactPerson(
                        decode(fields[1]),
                        decode(fields[2]),
                        decode(fields[3]),
                        decode(fields[4]),
                        decode(fields[5]),
                        decode(fields[6]),
                        decode(fields[7]),
                        decode(fields[8])
                );

                loadedBooks.putIfAbsent(bookName, new AddressBook());

                loadedBooks.get(bookName).addContact(person);

            } catch (IllegalArgumentException e) {
                throw new IOException("Unable to decode address book data.", e);
            }
        }

        addressBooks.clear();
        addressBooks.putAll(loadedBooks);
    }

    // Read contact details from the console.
    private static ContactPerson readContactFromConsole() {

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("State: ");
        String state = scanner.nextLine();

        System.out.print("ZIP: ");
        String zip = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new ContactPerson(
                firstName, lastName, address,
                city, state, zip, phone, email
        );
    }

    // Select an address book from the available address books.
    private String selectAddressBook() {

        if (addressBooks.isEmpty()) {
            System.out.println("No address books available.");
            return null;
        }

        System.out.println("Available Address Books:");

        addressBooks.keySet().forEach(System.out::println);

        System.out.print("Enter address book name: ");
        String name = scanner.nextLine();

        if (!addressBooks.containsKey(name)) {
            System.out.println("Address book not found.");
            return null;
        }

        return name;
    }

    private static int readChoice() {

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Display a list of contacts.
    private void displayContacts(List<ContactPerson> contacts) {

        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        contacts.forEach(System.out::println);
    }

    // Console menu integrating UC1 to UC13.
    public void run() {

        int choice;

        do {

            System.out.println("\n===== ADDRESS BOOK SYSTEM =====");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display Contacts");
            System.out.println("6. Display Address Books");
            System.out.println("7. Search by City Across Address Books");
            System.out.println("8. Search by State Across Address Books");
            System.out.println("9. View Contacts Grouped by City or State");
            System.out.println("10. Count Contacts by City or State");
            System.out.println("11. Sort Contacts by Name");
            System.out.println("12. Sort Contacts by City, State or ZIP");
            System.out.println("13. Save Address Books to File");
            System.out.println("14. Load Address Books from File");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = readChoice();

            switch (choice) {

                case 1: {
                    System.out.print("Enter address book name: ");
                    String name = scanner.nextLine();

                    System.out.println(
                            createAddressBook(name)
                                    ? "Address book created."
                                    : "Invalid or duplicate address book name."
                    );
                    break;
                }

                case 2: {
                    String bookName = selectAddressBook();

                    if (bookName != null) {
                        ContactPerson person = readContactFromConsole();

                        System.out.println(
                                addContact(bookName, person)
                                        ? "Contact added successfully."
                                        : "Duplicate contact found."
                        );
                    }
                    break;
                }

                case 3: {
                    String bookName = selectAddressBook();

                    if (bookName != null) {

                        System.out.print("First name of contact to edit: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Last name of contact to edit: ");
                        String lastName = scanner.nextLine();

                        ContactPerson updated = readContactFromConsole();

                        boolean edited = addressBooks.get(bookName)
                                .editContact(firstName, lastName, updated);

                        System.out.println(
                                edited ? "Contact updated."
                                        : "Contact not found or duplicate details."
                        );
                    }
                    break;
                }

                case 4: {
                    String bookName = selectAddressBook();

                    if (bookName != null) {

                        System.out.print("First name: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Last name: ");
                        String lastName = scanner.nextLine();

                        boolean deleted = addressBooks.get(bookName)
                                .deleteContact(firstName, lastName);

                        System.out.println(
                                deleted ? "Contact deleted."
                                        : "Contact not found."
                        );
                    }
                    break;
                }

                case 5: {
                    String bookName = selectAddressBook();

                    if (bookName != null) {
                        displayContacts(
                                addressBooks.get(bookName).getContacts()
                        );
                    }
                    break;
                }

                case 6:
                    addressBooks.keySet().forEach(System.out::println);
                    break;

                case 7: {
                    System.out.print("Enter city: ");
                    displayContacts(
                            searchAcrossBooksByCity(scanner.nextLine())
                    );
                    break;
                }

                case 8: {
                    System.out.print("Enter state: ");
                    displayContacts(
                            searchAcrossBooksByState(scanner.nextLine())
                    );
                    break;
                }

                case 9: {
                    String bookName = selectAddressBook();

                    if (bookName != null) {

                        AddressBook book = addressBooks.get(bookName);

                        System.out.println("1. Group by City");
                        System.out.println("2. Group by State");

                        int groupChoice = readChoice();

                        Map<String, List<ContactPerson>> groups =
                                groupChoice == 1
                                        ? book.getCityDictionary()
                                        : groupChoice == 2
                                          ? book.getStateDictionary()
                                          : null;

                        if (groups != null) {
                            groups.forEach((location, people) -> {
                                System.out.println("\n" + location);
                                displayContacts(people);
                            });
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;
                }

                case 10: {
                    String bookName = selectAddressBook();

                    if (bookName != null) {

                        AddressBook book = addressBooks.get(bookName);

                        System.out.println("1. Count by City");
                        System.out.println("2. Count by State");

                        int countChoice = readChoice();

                        Map<String, Long> counts =
                                countChoice == 1
                                        ? book.countByCity()
                                        : countChoice == 2
                                          ? book.countByState()
                                          : null;

                        if (counts != null) {
                            counts.forEach((location, count) ->
                                    System.out.println(location + ": " + count));
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;
                }

                case 11: {
                    String bookName = selectAddressBook();

                    if (bookName != null) {
                        displayContacts(
                                addressBooks.get(bookName).sortByName()
                        );
                    }
                    break;
                }

                case 12: {
                    String bookName = selectAddressBook();

                    if (bookName != null) {

                        AddressBook book = addressBooks.get(bookName);

                        System.out.println("1. Sort by City");
                        System.out.println("2. Sort by State");
                        System.out.println("3. Sort by ZIP");

                        int sortChoice = readChoice();

                        switch (sortChoice) {
                            case 1:
                                displayContacts(book.sortByCity());
                                break;
                            case 2:
                                displayContacts(book.sortByState());
                                break;
                            case 3:
                                displayContacts(book.sortByZip());
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;
                }

                case 13:
                    try {
                        writeAddressBooksToFile(DEFAULT_FILE);
                        System.out.println("Address books saved successfully.");
                    } catch (IOException e) {
                        System.out.println("Unable to save: " + e.getMessage());
                    }
                    break;

                case 14:
                    try {
                        readAddressBooksFromFile(DEFAULT_FILE);
                        System.out.println("Address books loaded successfully.");
                    } catch (IOException e) {
                        System.out.println("Unable to load: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using Address Book.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public static void main(String[] args) {

        AddressBookMain application = new AddressBookMain();

        application.run();
    }
}
