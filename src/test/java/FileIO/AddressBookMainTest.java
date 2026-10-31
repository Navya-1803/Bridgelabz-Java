package FileIO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookMainTest {

    @TempDir
    Path temporaryDirectory;

    private AddressBookMain application;
    private AddressBookMain.AddressBook addressBook;
    private Path addressBookFile;

    @BeforeEach
    void setUp() {

        application = new AddressBookMain();

        application.createAddressBook("Friends");
        application.createAddressBook("Family");

        addressBook = application.getAddressBook("Friends");

        addressBookFile = temporaryDirectory.resolve("addressbook-data.txt");

        addressBook.addContact(createPerson(
                "Rahul", "Sharma", "Anna Nagar",
                "Chennai", "Tamil Nadu", "600001",
                "9876543210", "rahul@gmail.com"
        ));

        addressBook.addContact(createPerson(
                "Priya", "Kumar", "T Nagar",
                "Chennai", "Tamil Nadu", "600002",
                "9876543211", "priya@gmail.com"
        ));

        addressBook.addContact(createPerson(
                "Amit", "Verma", "Boring Road",
                "Patna", "Bihar", "800001",
                "9876543212", "amit@gmail.com"
        ));

        application.addContact("Family", createPerson(
                "Sneha", "Raj", "Adyar",
                "Chennai", "Tamil Nadu", "600020",
                "9876543213", "sneha@gmail.com"
        ));
    }

    private AddressBookMain.ContactPerson createPerson(
            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String zip,
            String phone,
            String email) {

        return new AddressBookMain.ContactPerson(
                firstName, lastName, address,
                city, state, zip, phone, email
        );
    }

    // UC1: Test creation of a contact with all details.
    @Test
    void testCreateContact() {

        AddressBookMain.ContactPerson person = createPerson(
                "John", "Smith", "MG Road",
                "Bangalore", "Karnataka", "560001",
                "9876500000", "john@gmail.com"
        );

        assertEquals("John", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals("MG Road", person.getAddress());
        assertEquals("Bangalore", person.getCity());
        assertEquals("Karnataka", person.getState());
        assertEquals("560001", person.getZip());
        assertEquals("9876500000", person.getPhoneNumber());
        assertEquals("john@gmail.com", person.getEmail());
    }

    // UC2: Test adding a new contact.
    @Test
    void testAddContact() {

        AddressBookMain.ContactPerson person = createPerson(
                "John", "Smith", "MG Road",
                "Bangalore", "Karnataka", "560001",
                "9876500000", "john@gmail.com"
        );

        assertTrue(addressBook.addContact(person));
        assertEquals(4, addressBook.getContacts().size());
    }

    // UC3: Test editing an existing contact.
    @Test
    void testEditContact() {

        AddressBookMain.ContactPerson updatedPerson = createPerson(
                "Rahul", "Sharma", "Velachery",
                "Chennai", "Tamil Nadu", "600042",
                "9999999999", "rahul.updated@gmail.com"
        );

        assertTrue(addressBook.editContact(
                "Rahul", "Sharma", updatedPerson
        ));

        AddressBookMain.ContactPerson updated =
                addressBook.getContacts().get(0);

        assertEquals("Velachery", updated.getAddress());
        assertEquals("9999999999", updated.getPhoneNumber());
    }

    // UC3: Test editing a contact that does not exist.
    @Test
    void testEditNonExistingContact() {

        AddressBookMain.ContactPerson updatedPerson = createPerson(
                "John", "Smith", "MG Road",
                "Bangalore", "Karnataka", "560001",
                "9876500000", "john@gmail.com"
        );

        assertFalse(addressBook.editContact(
                "Unknown", "Person", updatedPerson
        ));
    }

    // UC3: Prevent editing a contact into another contact's name.
    @Test
    void testEditContactWithDuplicateName() {

        AddressBookMain.ContactPerson duplicate = createPerson(
                "Priya", "Kumar", "New Address",
                "Chennai", "Tamil Nadu", "600010",
                "9999999999", "new@gmail.com"
        );

        assertFalse(addressBook.editContact(
                "Rahul", "Sharma", duplicate
        ));
    }

    // UC4: Test deleting an existing contact.
    @Test
    void testDeleteContact() {

        assertTrue(addressBook.deleteContact("Rahul", "Sharma"));
        assertEquals(2, addressBook.getContacts().size());
    }

    // UC4: Test deleting a contact that does not exist.
    @Test
    void testDeleteNonExistingContact() {

        assertFalse(addressBook.deleteContact("Unknown", "Person"));
    }

    // UC5: Test maintaining multiple contacts.
    @Test
    void testMultipleContacts() {

        assertEquals(3, addressBook.getContacts().size());
    }

    // UC6: Test creating multiple address books.
    @Test
    void testCreateMultipleAddressBooks() {

        assertEquals(2, application.getAddressBooks().size());
        assertNotNull(application.getAddressBook("Friends"));
        assertNotNull(application.getAddressBook("Family"));
    }

    // UC6: Address book names must be unique.
    @Test
    void testDuplicateAddressBookName() {

        assertFalse(application.createAddressBook("Friends"));
    }

    // UC7: Test duplicate contact prevention.
    @Test
    void testDuplicateContact() {

        AddressBookMain.ContactPerson duplicate = createPerson(
                "Rahul", "Sharma", "Different Address",
                "Delhi", "Delhi", "110001",
                "9999999999", "different@gmail.com"
        );

        assertFalse(addressBook.addContact(duplicate));
        assertEquals(3, addressBook.getContacts().size());
    }

    // UC7: Test equals method for contacts with the same name.
    @Test
    void testContactEquality() {

        AddressBookMain.ContactPerson first = createPerson(
                "Rahul", "Sharma", "Address 1",
                "Chennai", "Tamil Nadu", "600001",
                "9876543210", "rahul@gmail.com"
        );

        AddressBookMain.ContactPerson second = createPerson(
                "RAHUL", "SHARMA", "Address 2",
                "Delhi", "Delhi", "110001",
                "9999999999", "other@gmail.com"
        );

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    // UC8: Test searching contacts by city across address books.
    @Test
    void testSearchAcrossBooksByCity() {

        List<AddressBookMain.ContactPerson> results =
                application.searchAcrossBooksByCity("Chennai");

        assertEquals(3, results.size());
    }

    // UC8: Test searching contacts by state across address books.
    @Test
    void testSearchAcrossBooksByState() {

        List<AddressBookMain.ContactPerson> results =
                application.searchAcrossBooksByState("Tamil Nadu");

        assertEquals(3, results.size());
    }

    // UC8: Test search when no contacts match.
    @Test
    void testSearchWithNoResults() {

        assertTrue(
                application.searchAcrossBooksByCity("Mumbai").isEmpty()
        );
    }

    // UC9: Test city dictionary.
    @Test
    void testCityDictionary() {

        Map<String, List<AddressBookMain.ContactPerson>> cityDictionary =
                addressBook.getCityDictionary();

        assertEquals(2, cityDictionary.size());
        assertEquals(2, cityDictionary.get("Chennai").size());
        assertEquals(1, cityDictionary.get("Patna").size());
    }

    // UC9: Test state dictionary.
    @Test
    void testStateDictionary() {

        Map<String, List<AddressBookMain.ContactPerson>> stateDictionary =
                addressBook.getStateDictionary();

        assertEquals(2, stateDictionary.size());
        assertEquals(2, stateDictionary.get("Tamil Nadu").size());
        assertEquals(1, stateDictionary.get("Bihar").size());
    }

    // UC10: Test contact count by city.
    @Test
    void testCountByCity() {

        Map<String, Long> counts = addressBook.countByCity();

        assertEquals(2L, counts.get("Chennai"));
        assertEquals(1L, counts.get("Patna"));
    }

    // UC10: Test contact count by state.
    @Test
    void testCountByState() {

        Map<String, Long> counts = addressBook.countByState();

        assertEquals(2L, counts.get("Tamil Nadu"));
        assertEquals(1L, counts.get("Bihar"));
    }

    // UC11: Test alphabetical sorting by person name.
    @Test
    void testSortByName() {

        List<AddressBookMain.ContactPerson> sorted =
                addressBook.sortByName();

        assertEquals("Amit", sorted.get(0).getFirstName());
        assertEquals("Priya", sorted.get(1).getFirstName());
        assertEquals("Rahul", sorted.get(2).getFirstName());
    }

    // UC12: Test sorting by city.
    @Test
    void testSortByCity() {

        List<AddressBookMain.ContactPerson> sorted =
                addressBook.sortByCity();

        assertEquals("Chennai", sorted.get(0).getCity());
        assertEquals("Chennai", sorted.get(1).getCity());
        assertEquals("Patna", sorted.get(2).getCity());
    }

    // UC12: Test sorting by state.
    @Test
    void testSortByState() {

        List<AddressBookMain.ContactPerson> sorted =
                addressBook.sortByState();

        assertEquals("Bihar", sorted.get(0).getState());
        assertEquals("Tamil Nadu", sorted.get(1).getState());
    }

    // UC12: Test sorting by ZIP code.
    @Test
    void testSortByZip() {

        List<AddressBookMain.ContactPerson> sorted =
                addressBook.sortByZip();

        assertEquals("600001", sorted.get(0).getZip());
        assertEquals("600002", sorted.get(1).getZip());
        assertEquals("800001", sorted.get(2).getZip());
    }

    // UC13: Test writing all address books and contacts to a file.
    @Test
    void testWriteAddressBooksToFile() throws IOException {

        application.writeAddressBooksToFile(
                addressBookFile.toString()
        );

        assertTrue(Files.exists(addressBookFile));
        assertEquals(4, Files.readAllLines(addressBookFile).size());
    }

    // UC13: Test reading address books and contacts from a file.
    @Test
    void testReadAddressBooksFromFile() throws IOException {

        application.writeAddressBooksToFile(
                addressBookFile.toString()
        );

        AddressBookMain newApplication = new AddressBookMain();

        newApplication.readAddressBooksFromFile(
                addressBookFile.toString()
        );

        assertEquals(2, newApplication.getAddressBooks().size());

        assertEquals(
                3,
                newApplication.getAddressBook("Friends")
                        .getContacts().size()
        );

        assertEquals(
                1,
                newApplication.getAddressBook("Family")
                        .getContacts().size()
        );
    }

    // UC13: Verify that contact fields are preserved during file operations.
    @Test
    void testFileDataIntegrity() throws IOException {

        application.writeAddressBooksToFile(
                addressBookFile.toString()
        );

        AddressBookMain newApplication = new AddressBookMain();

        newApplication.readAddressBooksFromFile(
                addressBookFile.toString()
        );

        AddressBookMain.ContactPerson person =
                newApplication.getAddressBook("Friends")
                        .getContacts().get(0);

        assertEquals("Rahul", person.getFirstName());
        assertEquals("Sharma", person.getLastName());
        assertEquals("Anna Nagar", person.getAddress());
        assertEquals("Chennai", person.getCity());
        assertEquals("Tamil Nadu", person.getState());
        assertEquals("600001", person.getZip());
        assertEquals("9876543210", person.getPhoneNumber());
        assertEquals("rahul@gmail.com", person.getEmail());
    }

    // UC13: Test file persistence with special characters.
    @Test
    void testFileDataWithSpecialCharacters() throws IOException {

        AddressBookMain specialApplication = new AddressBookMain();

        specialApplication.createAddressBook("Work|Contacts");

        AddressBookMain.ContactPerson person = createPerson(
                "John", "O'Neil", "Flat 2|MG Road",
                "Chennai", "Tamil Nadu", "600001",
                "9876543210", "john+work@gmail.com"
        );

        specialApplication.addContact("Work|Contacts", person);

        specialApplication.writeAddressBooksToFile(
                addressBookFile.toString()
        );

        AddressBookMain restoredApplication = new AddressBookMain();

        restoredApplication.readAddressBooksFromFile(
                addressBookFile.toString()
        );

        AddressBookMain.ContactPerson restored =
                restoredApplication.getAddressBook("Work|Contacts")
                        .getContacts().get(0);

        assertEquals("O'Neil", restored.getLastName());
        assertEquals("Flat 2|MG Road", restored.getAddress());
        assertEquals("john+work@gmail.com", restored.getEmail());
    }

    // UC13: Reading a file that does not exist should throw IOException.
    @Test
    void testReadNonExistingFile() {

        Path missingFile =
                temporaryDirectory.resolve("missing-addressbook.txt");

        assertThrows(
                IOException.class,
                () -> application.readAddressBooksFromFile(
                        missingFile.toString()
                )
        );
    }

    // UC13: Reading a file with an invalid record should throw IOException.
    @Test
    void testReadInvalidFileFormat() throws IOException {

        Files.writeString(addressBookFile, "invalid|record");

        assertThrows(
                IOException.class,
                () -> application.readAddressBooksFromFile(
                        addressBookFile.toString()
                )
        );
    }
}
