public class HospitalManagementDemo {

    static class HospitalPatientRecord {
        static String hospitalName = "City Care Hospital";
        private static int totalPatients = 0;

        private String name;
        private int age;
        private String ailment;
        private final int patientID;

        HospitalPatientRecord(
                String name, int age, String ailment, int patientID) {
            this.name = name;
            this.age = age;
            this.ailment = ailment;
            this.patientID = patientID;
            totalPatients++;
        }

        static int getTotalPatients() {
            return totalPatients;
        }

        void displayDetails() {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    public static void main(String[] args) {
        HospitalPatientRecord patient1 =
                new HospitalPatientRecord(
                        "Meera", 35, "Fever", 1001);

        HospitalPatientRecord patient2 =
                new HospitalPatientRecord(
                        "Arjun", 42, "Flu", 1002);

        Object obj = patient1;

        if (obj instanceof HospitalPatientRecord) {
            ((HospitalPatientRecord) obj).displayDetails();
        }

        System.out.println("Total Patients: "
                + HospitalPatientRecord.getTotalPatients());
    }
}3