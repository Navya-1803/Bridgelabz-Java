import java.util.ArrayList;
import java.util.List;

public class HospitalPatientManagement {

    interface MedicalRecord {
        void addRecord(String record);
        void viewRecords();
    }

    static abstract class Patient implements MedicalRecord {
        private int patientId;
        private String name;
        private int age;
        private List<String> medicalHistory = new ArrayList<>();

        Patient(int patientId, String name, int age) {
            this.patientId = patientId;
            this.name = name;
            this.age = age;
        }

        abstract double calculateBill();

        void getPatientDetails() {
            System.out.println("Patient ID: " + patientId);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Total Bill: " + calculateBill());
        }

        @Override
        public void addRecord(String record) {
            if (record != null && !record.isBlank()) {
                medicalHistory.add(record);
            }
        }

        @Override
        public void viewRecords() {
            System.out.println("Medical History:");

            for (String record : medicalHistory) {
                System.out.println("- " + record);
            }
        }
    }

    static class InPatient extends Patient {
        private int daysAdmitted;
        private double dailyRoomCharge;
        private double treatmentCharge;

        InPatient(int id, String name, int age, int daysAdmitted,
                  double dailyRoomCharge, double treatmentCharge) {
            super(id, name, age);
            this.daysAdmitted = daysAdmitted;
            this.dailyRoomCharge = dailyRoomCharge;
            this.treatmentCharge = treatmentCharge;
        }

        @Override
        double calculateBill() {
            return daysAdmitted * dailyRoomCharge + treatmentCharge;
        }
    }

    static class OutPatient extends Patient {
        private double consultationFee;
        private double medicineCharges;

        OutPatient(int id, String name, int age,
                   double consultationFee, double medicineCharges) {
            super(id, name, age);
            this.consultationFee = consultationFee;
            this.medicineCharges = medicineCharges;
        }

        @Override
        double calculateBill() {
            return consultationFee + medicineCharges;
        }
    }

    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient admittedPatient =
                new InPatient(101, "Ananya", 45, 3, 2500, 5000);
        admittedPatient.addRecord("Routine blood test completed");

        OutPatient visitingPatient =
                new OutPatient(102, "Rahul", 28, 800, 1200);
        visitingPatient.addRecord("Outpatient consultation completed");

        patients.add(admittedPatient);
        patients.add(visitingPatient);

        for (Patient patient : patients) {
            patient.getPatientDetails();
            patient.viewRecords();
            System.out.println("-------------------");
        }
    }
}