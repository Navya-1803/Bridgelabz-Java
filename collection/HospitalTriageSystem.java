import java.util.PriorityQueue;
import java.util.Comparator;

public class HospitalTriageSystem {

    static class Patient {
        String name;
        int severity;
        int arrivalOrder;

        Patient(String name, int severity, int arrivalOrder) {
            this.name = name;
            this.severity = severity;
            this.arrivalOrder = arrivalOrder;
        }

        @Override
        public String toString() {
            return name + " (Severity: " + severity + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Patient> patients = new PriorityQueue<>(
                Comparator.comparingInt(
                        (Patient p) -> p.severity
                ).reversed().thenComparingInt(p -> p.arrivalOrder)
        );

        patients.add(new Patient("John", 3, 1));
        patients.add(new Patient("Alice", 5, 2));
        patients.add(new Patient("Bob", 2, 3));

        System.out.println("Treatment order:");

        while (!patients.isEmpty()) {
            System.out.println(patients.poll());
        }
    }
}