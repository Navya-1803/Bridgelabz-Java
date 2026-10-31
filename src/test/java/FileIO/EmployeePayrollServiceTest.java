package FileIO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollServiceTest {

    @TempDir
    Path temporaryDirectory;

    private EmployeePayrollService service;
    private Path payrollFile;

    @BeforeEach
    void setUp() {

        service = new EmployeePayrollService();
        payrollFile = temporaryDirectory.resolve("payroll-file.txt");

        service.getEmployeePayrollList().add(
                new EmployeePayrollService.EmployeePayrollData(
                        1, "Jeff Bezos", 100000.0
                )
        );

        service.getEmployeePayrollList().add(
                new EmployeePayrollService.EmployeePayrollData(
                        2, "Bill Gates", 200000.0
                )
        );

        service.getEmployeePayrollList().add(
                new EmployeePayrollService.EmployeePayrollData(
                        3, "Mark Zuckerberg", 300000.0
                )
        );
    }

    // Test whether a file exists.
    @Test
    void testCheckFileExists() throws IOException {

        Path file = temporaryDirectory.resolve("test.txt");

        Files.createFile(file);

        assertTrue(service.checkFileExists(file.toString()));
    }

    // Test deleting a file and checking that it no longer exists.
    @Test
    void testDeleteFile() throws IOException {

        Path file = temporaryDirectory.resolve("delete.txt");

        Files.createFile(file);

        assertTrue(service.deleteFile(file.toString()));
        assertFalse(Files.exists(file));
    }

    // Test creating a directory.
    @Test
    void testCreateDirectory() throws IOException {

        Path directory = temporaryDirectory.resolve("TestDirectory");

        assertTrue(service.createDirectory(directory.toString()));
        assertTrue(Files.isDirectory(directory));
    }

    // Test creating an empty file.
    @Test
    void testCreateEmptyFile() throws IOException {

        Path file = temporaryDirectory.resolve("empty.txt");

        assertTrue(service.createEmptyFile(file.toString()));
        assertTrue(Files.exists(file));
        assertEquals(0, Files.size(file));
    }

    // Test listing files and directories.
    @Test
    void testListFilesAndDirectories() throws IOException {

        Path file = temporaryDirectory.resolve("sample.txt");
        Path directory = temporaryDirectory.resolve("SampleDirectory");

        Files.createFile(file);
        Files.createDirectory(directory);

        assertDoesNotThrow(() ->
                service.listFilesAndDirectories(
                        temporaryDirectory.toString()
                )
        );
    }

    // Test listing files by extension.
    @Test
    void testListFilesByExtension() throws IOException {

        Path textFile = temporaryDirectory.resolve("sample.txt");
        Path javaFile = temporaryDirectory.resolve("Sample.java");

        Files.createFile(textFile);
        Files.createFile(javaFile);

        assertDoesNotThrow(() ->
                service.listFilesByExtension(
                        temporaryDirectory.toString(),
                        ".txt"
                )
        );
    }

    // Test counting files and directories recursively.
    @Test
    void testCountDirectoryEntries() throws IOException {

        Path directory = temporaryDirectory.resolve("Folder");
        Files.createDirectory(directory);

        Files.createFile(directory.resolve("file1.txt"));
        Files.createFile(directory.resolve("file2.txt"));

        long count = service.countDirectoryEntries(
                temporaryDirectory.toString()
        );

        assertEquals(3, count);
    }

    // Test writing employee payroll records to a file.
    @Test
    void testWriteEmployeePayrollDataToFile() throws IOException {

        service.writeEmployeePayrollDataToFile(payrollFile.toString());

        assertTrue(Files.exists(payrollFile));
        assertEquals(3, service.countEntries(payrollFile.toString()));
    }

    // Test printing payroll records from the file.
    @Test
    void testPrintEmployeePayrollData() throws IOException {

        service.writeEmployeePayrollDataToFile(payrollFile.toString());

        assertDoesNotThrow(() ->
                service.printEmployeePayrollData(payrollFile.toString())
        );
    }

    // Test counting the number of payroll entries.
    @Test
    void testCountEntries() throws IOException {

        service.writeEmployeePayrollDataToFile(payrollFile.toString());

        long count = service.countEntries(payrollFile.toString());

        assertEquals(3, count);
    }

    // Test reading employee payroll records from the file.
    @Test
    void testReadEmployeePayrollDataFromFile() throws IOException {

        service.writeEmployeePayrollDataToFile(payrollFile.toString());

        List<EmployeePayrollService.EmployeePayrollData> employees =
                service.readEmployeePayrollDataFromFile(
                        payrollFile.toString()
                );

        assertEquals(3, employees.size());

        assertEquals(1, employees.get(0).getId());
        assertEquals("Jeff Bezos", employees.get(0).getName());
        assertEquals(100000.0, employees.get(0).getSalary());

        assertEquals(2, employees.get(1).getId());
        assertEquals("Bill Gates", employees.get(1).getName());

        assertEquals(3, employees.get(2).getId());
        assertEquals("Mark Zuckerberg", employees.get(2).getName());
    }

    // Test that the file contains the expected payroll information.
    @Test
    void testPayrollFileContents() throws IOException {

        service.writeEmployeePayrollDataToFile(payrollFile.toString());

        List<String> lines = Files.readAllLines(payrollFile);

        assertEquals(3, lines.size());

        assertEquals("1,Jeff Bezos,100000.0", lines.get(0));
        assertEquals("2,Bill Gates,200000.0", lines.get(1));
        assertEquals("3,Mark Zuckerberg,300000.0", lines.get(2));
    }
}
