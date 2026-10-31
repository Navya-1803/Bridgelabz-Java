package Annotation;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVGsonService {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    // Read CSV records one by one into String arrays.
    public List<String[]> readCSVAsStringArrays(String filePath)
            throws Exception {

        List<String[]> records = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Path.of(filePath));
             CSVReader csvReader = new CSVReader(reader)) {

            String[] record;

            while ((record = csvReader.readNext()) != null) {
                records.add(record);
            }
        }

        return records;
    }

    // Read all CSV records into a List of String arrays.
    // The first row containing column headers is excluded.
    public List<String[]> readAllCSVRecords(String filePath)
            throws Exception {

        List<String[]> records = readCSVAsStringArrays(filePath);

        if (!records.isEmpty()) {
            records.remove(0);
        }

        return records;
    }

    // Convert a CSV file directly into Java POJO objects.
    // The CSV file must contain the headers name, email, phone and country.
    public List<CSVUser> readCSVAsUsers(String filePath)
            throws IOException {

        try (Reader reader = Files.newBufferedReader(Path.of(filePath))) {

            CsvToBean<CSVUser> csvToBean =
                    new CsvToBeanBuilder<CSVUser>(reader)
                            .withType(CSVUser.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withIgnoreEmptyLine(true)
                            .build();

            return csvToBean.parse();
        }
    }


    // Write Java objects into a CSV file with a header.
    public void writeUsersToCSV(
            List<CSVUser> users,
            String filePath) throws Exception {

        Path path = Path.of(filePath);

        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        try (Writer writer = Files.newBufferedWriter(path);
             CSVWriter csvWriter = new CSVWriter(writer)) {

            csvWriter.writeNext(
                    new String[]{"name", "email", "phone", "country"}
            );

            for (CSVUser user : users) {
                csvWriter.writeNext(new String[]{
                        user.getName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getCountry()
                });
            }
        }
    }


    // Convert CSV data into a JSON file using Gson.
    public void convertCSVToJSON(
            String csvFilePath,
            String jsonFilePath) throws Exception {

        List<CSVUser> users = readCSVAsUsers(csvFilePath);

        writeUsersToJSON(users, jsonFilePath);
    }

    // Write a list of Java objects into a JSON file.
    public void writeUsersToJSON(
            List<CSVUser> users,
            String jsonFilePath) throws IOException {

        Path path = Path.of(jsonFilePath);

        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        try (Writer writer = Files.newBufferedWriter(path)) {
            gson.toJson(users, writer);
        }
    }

    // Read JSON data and convert it back into Java objects.
    public List<CSVUser> readUsersFromJSON(String jsonFilePath)
            throws IOException {

        try (Reader reader = Files.newBufferedReader(
                Path.of(jsonFilePath))) {

            Type userListType =
                    new TypeToken<List<CSVUser>>() {}.getType();

            List<CSVUser> users = gson.fromJson(reader, userListType);

            return users == null ? new ArrayList<>() : users;
        }
    }

    // Display CSV records stored as String arrays.
    public void displayCSVRecords(String filePath) throws Exception {

        List<String[]> records = readAllCSVRecords(filePath);

        for (String[] record : records) {

            if (record.length >= 4) {
                System.out.println("Name: " + record[0]);
                System.out.println("Email: " + record[1]);
                System.out.println("Phone: " + record[2]);
                System.out.println("Country: " + record[3]);
                System.out.println("-------------------------");
            }
        }
    }

    // Display CSV records mapped to POJO objects.
    public void displayUsers(List<CSVUser> users) {

        for (CSVUser user : users) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {

        OpenCSVGsonService service = new OpenCSVGsonService();

        String csvFile = "users.csv";
        String jsonFile = "users.json";

        try {

            // Read CSV records as String arrays.
            System.out.println("Reading CSV as String Arrays:");

            List<String[]> records =
                    service.readAllCSVRecords(csvFile);

            for (String[] record : records) {
                System.out.println(String.join(", ", record));
            }

            // Read CSV records directly into POJO objects.
            System.out.println("\nReading CSV into POJO:");

            List<CSVUser> users = service.readCSVAsUsers(csvFile);

            service.displayUsers(users);

            // Write POJO objects into a CSV file.
            service.writeUsersToCSV(users, "output-users.csv");

            // Convert CSV data into JSON.
            service.convertCSVToJSON(csvFile, jsonFile);

            System.out.println("\nCSV converted to JSON successfully.");

            // Read the generated JSON file.
            List<CSVUser> jsonUsers =
                    service.readUsersFromJSON(jsonFile);

            System.out.println("\nReading Users from JSON:");

            service.displayUsers(jsonUsers);

        } catch (Exception e) {
            System.out.println("File processing failed: " + e.getMessage());
        }
    }
}
