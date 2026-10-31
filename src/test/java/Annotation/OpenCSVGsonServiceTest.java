package Annotation;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OpenCSVGsonServiceTest {

    @TempDir
    Path temporaryDirectory;

    private OpenCSVGsonService service;
    private Path csvFile;
    private Path outputCSVFile;
    private Path jsonFile;

    @BeforeEach
    void setUp() throws IOException {

        service = new OpenCSVGsonService();

        csvFile = temporaryDirectory.resolve("users.csv");
        outputCSVFile = temporaryDirectory.resolve("output-users.csv");
        jsonFile = temporaryDirectory.resolve("users.json");

        String csvContent =
                "name,email,phone,country\n"
                        + "Rajeev Kumar Singh,rajeevs@example.com,+91-9999999999,India\n"
                        + "Sachin Tendulkar,sachin@example.com,+91-9999999998,India\n"
                        + "Barak Obama,barak.obama@example.com,+1-1111111111,United States\n"
                        + "Donald Trump,donald.trump@example.com,+1-2222222222,United States\n";

        Files.writeString(csvFile, csvContent);
    }

    // Test reading CSV records as String arrays.
    @Test
    void testReadCSVAsStringArrays() throws Exception {

        List<String[]> records =
                service.readCSVAsStringArrays(csvFile.toString());

        assertEquals(5, records.size());

        assertEquals("name", records.get(0)[0]);
        assertEquals("email", records.get(0)[1]);

        assertEquals("Rajeev Kumar Singh", records.get(1)[0]);
        assertEquals("rajeevs@example.com", records.get(1)[1]);
    }

    // Test reading all CSV records without the header.
    @Test
    void testReadAllCSVRecords() throws Exception {

        List<String[]> records =
                service.readAllCSVRecords(csvFile.toString());

        assertEquals(4, records.size());

        assertEquals("Rajeev Kumar Singh", records.get(0)[0]);
        assertEquals("Donald Trump", records.get(3)[0]);
    }

    // Test mapping CSV records directly into POJO objects.
    @Test
    void testReadCSVAsUsers() throws Exception {

        List<CSVUser> users =
                service.readCSVAsUsers(csvFile.toString());

        assertEquals(4, users.size());

        assertEquals("Rajeev Kumar Singh", users.get(0).getName());
        assertEquals("rajeevs@example.com", users.get(0).getEmail());
        assertEquals("+91-9999999999", users.get(0).getPhone());
        assertEquals("India", users.get(0).getCountry());
    }

    // Test writing Java objects into a CSV file.
    @Test
    void testWriteUsersToCSV() throws Exception {

        List<CSVUser> users =
                service.readCSVAsUsers(csvFile.toString());

        service.writeUsersToCSV(users, outputCSVFile.toString());

        assertTrue(Files.exists(outputCSVFile));

        List<String[]> writtenRecords =
                service.readCSVAsStringArrays(outputCSVFile.toString());

        assertEquals(5, writtenRecords.size());

        assertEquals("name", writtenRecords.get(0)[0]);
        assertEquals("Rajeev Kumar Singh", writtenRecords.get(1)[0]);
    }

    // Test writing an empty list of users to CSV.
    @Test
    void testWriteEmptyUsersToCSV() throws Exception {

        service.writeUsersToCSV(List.of(), outputCSVFile.toString());

        assertTrue(Files.exists(outputCSVFile));

        List<String[]> records =
                service.readCSVAsStringArrays(outputCSVFile.toString());

        assertEquals(1, records.size());
        assertEquals("name", records.get(0)[0]);
    }

    // Test converting CSV data into JSON.
    @Test
    void testConvertCSVToJSON() throws Exception {

        service.convertCSVToJSON(
                csvFile.toString(),
                jsonFile.toString()
        );

        assertTrue(Files.exists(jsonFile));

        String jsonContent = Files.readString(jsonFile);

        assertTrue(jsonContent.contains("Rajeev Kumar Singh"));
        assertTrue(jsonContent.contains("rajeevs@example.com"));
        assertTrue(jsonContent.contains("Sachin Tendulkar"));
    }

    // Test reading JSON data back into Java objects.
    @Test
    void testReadUsersFromJSON() throws Exception {

        List<CSVUser> originalUsers =
                service.readCSVAsUsers(csvFile.toString());

        service.writeUsersToJSON(originalUsers, jsonFile.toString());

        List<CSVUser> restoredUsers =
                service.readUsersFromJSON(jsonFile.toString());

        assertEquals(4, restoredUsers.size());

        assertEquals(
                originalUsers.get(0).getName(),
                restoredUsers.get(0).getName()
        );

        assertEquals(
                originalUsers.get(0).getEmail(),
                restoredUsers.get(0).getEmail()
        );

        assertEquals(
                originalUsers.get(0).getPhone(),
                restoredUsers.get(0).getPhone()
        );

        assertEquals(
                originalUsers.get(0).getCountry(),
                restoredUsers.get(0).getCountry()
        );
    }

    // Test the complete CSV-to-JSON workflow.
    @Test
    void testCompleteCSVToJSONWorkflow() throws Exception {

        service.convertCSVToJSON(
                csvFile.toString(),
                jsonFile.toString()
        );

        List<CSVUser> users =
                service.readUsersFromJSON(jsonFile.toString());

        assertEquals(4, users.size());

        assertEquals("Rajeev Kumar Singh", users.get(0).getName());
        assertEquals("Sachin Tendulkar", users.get(1).getName());
        assertEquals("Barak Obama", users.get(2).getName());
        assertEquals("Donald Trump", users.get(3).getName());
    }

    // Test reading a CSV file that does not exist.
    @Test
    void testReadNonExistingCSVFile() {

        Path missingFile =
                temporaryDirectory.resolve("missing.csv");

        assertThrows(
                IOException.class,
                () -> service.readCSVAsUsers(missingFile.toString())
        );
    }

    // Test that special characters in CSV fields are preserved.
    @Test
    void testCSVWithSpecialCharacters() throws Exception {

        List<CSVUser> users = List.of(
                new CSVUser(
                        "John, Smith",
                        "john.smith@example.com",
                        "+91-9999999999",
                        "United States"
                )
        );

        service.writeUsersToCSV(users, outputCSVFile.toString());

        List<CSVUser> restoredUsers =
                service.readCSVAsUsers(outputCSVFile.toString());

        assertEquals(1, restoredUsers.size());
        assertEquals("John, Smith", restoredUsers.get(0).getName());
        assertEquals("United States", restoredUsers.get(0).getCountry());
    }

    // Test reading an empty JSON file.
    @Test
    void testReadEmptyJSONFile() throws IOException {

        Files.writeString(jsonFile, "");

        List<CSVUser> users =
                service.readUsersFromJSON(jsonFile.toString());

        assertNotNull(users);
        assertTrue(users.isEmpty());
    }
}


