package FileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class EmployeePayrollService {

    private static final String PAYROLL_FILE = "payroll-file.txt";

    private final List<EmployeePayrollData> employeePayrollList =
            new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    // Employee Payroll data class
    public static class EmployeePayrollData {

        private int id;
        private String name;
        private double salary;

        public EmployeePayrollData(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "ID: " + id
                    + ", Name: " + name
                    + ", Salary: " + salary;
        }
    }

    // UC1: Read employee payroll information from the console.
    public void readEmployeePayrollData() {

        System.out.print("Enter Employee ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        employeePayrollList.add(
                new EmployeePayrollData(id, name, salary)
        );

        System.out.println("Employee payroll details added.");
    }

    // UC1: Display employee payroll information on the console.
    public void writeEmployeePayrollDataToConsole() {

        if (employeePayrollList.isEmpty()) {
            System.out.println("No employee records available.");
            return;
        }

        System.out.println("\nEmployee Payroll Records:");

        employeePayrollList.forEach(System.out::println);
    }

    // UC2: Check whether a file exists.
    public boolean checkFileExists(String filePath) {

        return Files.exists(Paths.get(filePath));
    }

    // UC2: Delete a file and verify that it no longer exists.
    public boolean deleteFile(String filePath) throws IOException {

        Path path = Paths.get(filePath);

        if (Files.exists(path)) {
            Files.delete(path);
        }

        return !Files.exists(path);
    }

    // UC2: Create a directory.
    public boolean createDirectory(String directoryPath)
            throws IOException {

        Path path = Paths.get(directoryPath);

        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        return Files.isDirectory(path);
    }

    // UC2: Create an empty file.
    public boolean createEmptyFile(String filePath)
            throws IOException {

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            Files.createDirectories(path.getParent() == null
                    ? Paths.get(".") : path.getParent());

            Files.createFile(path);
        }

        return Files.exists(path) && Files.size(path) == 0;
    }

    // UC2: List files and directories in a given directory.
    public void listFilesAndDirectories(String directoryPath)
            throws IOException {

        try (Stream<Path> paths = Files.list(Paths.get(directoryPath))) {

            paths.forEach(path -> {
                if (Files.isDirectory(path)) {
                    System.out.println("[DIRECTORY] " + path.getFileName());
                } else {
                    System.out.println("[FILE] " + path.getFileName());
                }
            });
        }
    }

    // UC2: List files having a particular extension.
    public void listFilesByExtension(
            String directoryPath,
            String extension) throws IOException {

        try (Stream<Path> paths = Files.list(Paths.get(directoryPath))) {

            paths.filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString()
                            .endsWith(extension))
                    .forEach(System.out::println);
        }
    }

    // UC3: Register a directory and all its subdirectories with WatchService.
    private void registerAllDirectories(
            Path startDirectory,
            WatchService watchService) throws IOException {

        try (Stream<Path> paths = Files.walk(startDirectory)) {

            paths.filter(Files::isDirectory)
                    .forEach(directory -> {
                        try {
                            directory.register(
                                    watchService,
                                    StandardWatchEventKinds.ENTRY_CREATE,
                                    StandardWatchEventKinds.ENTRY_DELETE,
                                    StandardWatchEventKinds.ENTRY_MODIFY
                            );
                        } catch (IOException e) {
                            throw new RuntimeException(
                                    "Unable to register directory: " + directory,
                                    e
                            );
                        }
                    });
        }
    }

    // UC3: Watch a directory and its subdirectories for file changes.
    // This method continues watching until the thread is interrupted.
    public void watchDirectory(String directoryPath)
            throws IOException, InterruptedException {

        Path rootDirectory = Paths.get(directoryPath);

        if (!Files.isDirectory(rootDirectory)) {
            throw new IllegalArgumentException(
                    "Directory does not exist: " + directoryPath
            );
        }

        try (WatchService watchService =
                     FileSystems.getDefault().newWatchService()) {

            registerAllDirectories(rootDirectory, watchService);

            System.out.println("Watching directory: " + rootDirectory);
            System.out.println("Press Ctrl+C to stop watching.");

            while (!Thread.currentThread().isInterrupted()) {

                WatchKey key = watchService.take();

                Path directory = (Path) key.watchable();

                for (WatchEvent<?> event : key.pollEvents()) {

                    WatchEvent.Kind<?> kind = event.kind();

                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }

                    Path changedPath = directory.resolve(
                            (Path) event.context()
                    );

                    System.out.println(
                            "Event: " + kind.name()
                                    + " | Path: " + changedPath
                    );

                    // Register newly created directories and their subdirectories.
                    if (kind == StandardWatchEventKinds.ENTRY_CREATE
                            && Files.isDirectory(changedPath)) {

                        registerAllDirectories(changedPath, watchService);
                    }
                }

                // Remove invalid watch keys.
                if (!key.reset()) {
                    System.out.println("Directory is no longer accessible.");
                }
            }
        }
    }

    // UC3: Count all files and directories inside a directory recursively.
    public long countDirectoryEntries(String directoryPath)
            throws IOException {

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {

            return paths
                    .filter(path -> !path.equals(Paths.get(directoryPath)))
                    .count();
        }
    }

    // UC4: Write employee payroll records to a file.
    public void writeEmployeePayrollDataToFile(String filePath)
            throws IOException {

        try (PrintWriter writer = new PrintWriter(
                Files.newBufferedWriter(Paths.get(filePath)))) {

            for (EmployeePayrollData employee : employeePayrollList) {
                writer.println(
                        employee.getId() + ","
                                + employee.getName() + ","
                                + employee.getSalary()
                );
            }
        }

        System.out.println("Employee payroll data written to file.");
    }

    // UC5: Print all employee payroll records from the file.
    public void printEmployeePayrollData(String filePath)
            throws IOException {

        try (BufferedReader reader =
                     Files.newBufferedReader(Paths.get(filePath))) {

            String line;

            System.out.println("\nEmployee Payroll File Contents:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    // UC5 and UC6: Count the number of records in the payroll file.
    public long countEntries(String filePath) throws IOException {

        try (Stream<String> lines =
                     Files.lines(Paths.get(filePath))) {

            return lines.count();
        }
    }

    // UC6: Read employee payroll records from the file.
    public List<EmployeePayrollData> readEmployeePayrollDataFromFile(
            String filePath) throws IOException {

        List<EmployeePayrollData> employees = new ArrayList<>();

        try (BufferedReader reader =
                     Files.newBufferedReader(Paths.get(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] details = line.split(",", -1);

                if (details.length != 3) {
                    continue;
                }

                int id = Integer.parseInt(details[0]);
                String name = details[1];
                double salary = Double.parseDouble(details[2]);

                employees.add(
                        new EmployeePayrollData(id, name, salary)
                );
            }
        }

        return employees;
    }

    // UC6: Display employee payroll records read from the file.
    public void displayPayrollDataFromFile(String filePath)
            throws IOException {

        List<EmployeePayrollData> employees =
                readEmployeePayrollDataFromFile(filePath);

        System.out.println("\nEmployee Payroll Records Read From File:");

        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }

        employees.forEach(System.out::println);
    }

    // Get the current employee payroll list.
    public List<EmployeePayrollData> getEmployeePayrollList() {
        return employeePayrollList;
    }

    public static void main(String[] args) {

        EmployeePayrollService service = new EmployeePayrollService();

        try {

            // UC1: Read employee details from the console.
            System.out.println("Enter Employee Payroll Details");
            service.readEmployeePayrollData();
            service.writeEmployeePayrollDataToConsole();

            // UC4: Write employee records to the payroll file.
            service.writeEmployeePayrollDataToFile(PAYROLL_FILE);

            // UC5: Print payroll records and count entries.
            service.printEmployeePayrollData(PAYROLL_FILE);

            System.out.println(
                    "Total payroll entries: "
                            + service.countEntries(PAYROLL_FILE)
            );

            // UC6: Read payroll records from the file.
            service.displayPayrollDataFromFile(PAYROLL_FILE);

        } catch (IOException e) {
            System.out.println("File operation failed: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        }
    }
}
