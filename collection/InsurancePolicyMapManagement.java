import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyMapManagement {

    static class Policy {
        String policyNumber;
        String policyholderName;
        LocalDate expiryDate;
        String coverageType;
        double premiumAmount;

        Policy(String policyNumber, String policyholderName,
               LocalDate expiryDate, String coverageType,
               double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        @Override
        public String toString() {
            return policyNumber + " | " + policyholderName
                    + " | " + expiryDate + " | "
                    + coverageType + " | " + premiumAmount;
        }
    }

    private final Map<String, Policy> hashPolicies = new HashMap<>();
    private final Map<String, Policy> insertionPolicies =
            new LinkedHashMap<>();

    // Expiry date is the key; policies with the same date
    // are stored in a list so none are lost.
    private final TreeMap<LocalDate, List<Policy>> expiryPolicies =
            new TreeMap<>();

    void addPolicy(Policy policy) {
        String number = policy.policyNumber;

        // Reject duplicate policy numbers
        if (hashPolicies.containsKey(number)) {
            System.out.println("Duplicate policy: " + number);
            return;
        }

        hashPolicies.put(number, policy);
        insertionPolicies.put(number, policy);

        expiryPolicies.computeIfAbsent(
                policy.expiryDate,
                key -> new ArrayList<>()
        ).add(policy);
    }

    Policy getPolicy(String policyNumber) {
        return hashPolicies.get(policyNumber);
    }

    void displayInsertionOrder() {
        System.out.println("\nPolicies in insertion order:");

        insertionPolicies.values().forEach(System.out::println);
    }

    void displayExpiryOrder() {
        System.out.println("\nPolicies sorted by expiry:");

        expiryPolicies.forEach((date, policies) -> {
            for (Policy policy : policies) {
                System.out.println(policy);
            }
        });
    }

    void displayExpiringWithin30Days() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("\nPolicies expiring within 30 days:");

        expiryPolicies.subMap(today, true, limit, true)
                .values()
                .forEach(policies -> policies.forEach(System.out::println));
    }

    void displayByPolicyholder(String name) {
        System.out.println("\nPolicies for: " + name);

        for (Policy policy : hashPolicies.values()) {
            if (policy.policyholderName.equalsIgnoreCase(name)) {
                System.out.println(policy);
            }
        }
    }

    void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        List<String> expiredNumbers = new ArrayList<>();

        for (Policy policy : hashPolicies.values()) {
            if (policy.expiryDate.isBefore(today)) {
                expiredNumbers.add(policy.policyNumber);
            }
        }

        for (String number : expiredNumbers) {
            Policy removed = hashPolicies.remove(number);

            insertionPolicies.remove(number);

            List<Policy> sameDatePolicies =
                    expiryPolicies.get(removed.expiryDate);

            sameDatePolicies.remove(removed);

            if (sameDatePolicies.isEmpty()) {
                expiryPolicies.remove(removed.expiryDate);
            }
        }

        System.out.println("\nRemoved expired policies: "
                + expiredNumbers);
    }

    public static void main(String[] args) {
        InsurancePolicyMapManagement system =
                new InsurancePolicyMapManagement();

        LocalDate today = LocalDate.now();

        system.addPolicy(new Policy(
                "P101", "Alice", today.plusDays(10), "Health", 12000));

        system.addPolicy(new Policy(
                "P102", "Bob", today.plusDays(45), "Auto", 15000));

        system.addPolicy(new Policy(
                "P103", "Alice", today.minusDays(5), "Home", 18000));

        system.addPolicy(new Policy(
                "P104", "Carol", today.plusDays(20), "Health", 10000));

        // Try adding a duplicate
        system.addPolicy(new Policy(
                "P101", "Alice", today.plusDays(10), "Health", 12000));

        System.out.println("Retrieve P102: "
                + system.getPolicy("P102"));

        system.displayInsertionOrder();
        system.displayExpiryOrder();
        system.displayExpiringWithin30Days();
        system.displayByPolicyholder("Alice");

        system.removeExpiredPolicies();

        System.out.println("\nPolicies after removing expired ones:");
        system.displayInsertionOrder();
    }
}