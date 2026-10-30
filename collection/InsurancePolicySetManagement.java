import java.time.LocalDate;
import java.util.*;

public class InsurancePolicySetManagement {

    static class Policy {
        private final String policyNumber;
        private final String policyholderName;
        private final LocalDate expiryDate;
        private final String coverageType;
        private final double premiumAmount;

        Policy(String policyNumber, String policyholderName,
               LocalDate expiryDate, String coverageType,
               double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        String getPolicyNumber() {
            return policyNumber;
        }

        String getPolicyholderName() {
            return policyholderName;
        }

        LocalDate getExpiryDate() {
            return expiryDate;
        }

        String getCoverageType() {
            return coverageType;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Policy)) return false;

            Policy other = (Policy) obj;
            return policyNumber.equals(other.policyNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(policyNumber);
        }

        @Override
        public String toString() {
            return policyNumber + " | "
                    + policyholderName + " | "
                    + expiryDate + " | "
                    + coverageType + " | "
                    + premiumAmount;
        }
    }

    private final Set<Policy> hashPolicies = new HashSet<>();
    private final Set<Policy> insertionPolicies = new LinkedHashSet<>();

    // Expiry date first; policy number breaks date ties.
    private final TreeSet<Policy> expiryPolicies =
            new TreeSet<>(
                    Comparator.comparing(Policy::getExpiryDate)
                            .thenComparing(Policy::getPolicyNumber)
            );

    void addPolicy(Policy policy) {
        hashPolicies.add(policy);
        insertionPolicies.add(policy);
        expiryPolicies.add(policy);
    }

    void displayAllPolicies() {
        System.out.println("\nAll unique policies:");
        hashPolicies.forEach(System.out::println);
    }

    void displayInsertionOrder() {
        System.out.println("\nPolicies in insertion order:");
        insertionPolicies.forEach(System.out::println);
    }

    void displayExpiryOrder() {
        System.out.println("\nPolicies sorted by expiry:");
        expiryPolicies.forEach(System.out::println);
    }

    void displayExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("\nPolicies expiring within 30 days:");

        for (Policy policy : expiryPolicies) {
            if (!policy.getExpiryDate().isBefore(today)
                    && !policy.getExpiryDate().isAfter(limit)) {
                System.out.println(policy);
            }
        }
    }

    void displayByCoverage(String coverage) {
        System.out.println("\nPolicies with coverage: " + coverage);

        for (Policy policy : hashPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverage)) {
                System.out.println(policy);
            }
        }
    }

    void findDuplicatePolicyNumbers(List<Policy> policies) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy policy : policies) {
            if (!seen.add(policy.getPolicyNumber())) {
                duplicates.add(policy.getPolicyNumber());
            }
        }

        System.out.println("\nDuplicate policy numbers: " + duplicates);
    }

    void performanceComparison(List<Policy> policies) {
        Set<Policy> hash = new HashSet<>();
        Set<Policy> linked = new LinkedHashSet<>();
        Set<Policy> tree = new TreeSet<>(
                Comparator.comparing(Policy::getExpiryDate)
                        .thenComparing(Policy::getPolicyNumber)
        );

        measure("HashSet", hash, policies);
        measure("LinkedHashSet", linked, policies);
        measure("TreeSet", tree, policies);
    }

    static void measure(String name, Set<Policy> set,
                        List<Policy> policies) {
        long start = System.nanoTime();

        for (Policy policy : policies) {
            set.add(policy);
        }

        long addTime = System.nanoTime() - start;

        Policy searchPolicy = policies.get(policies.size() / 2);

        start = System.nanoTime();
        set.contains(searchPolicy);
        long searchTime = System.nanoTime() - start;

        start = System.nanoTime();
        set.remove(searchPolicy);
        long removeTime = System.nanoTime() - start;

        System.out.println("\n" + name);
        System.out.println("Add: " + addTime + " ns");
        System.out.println("Search: " + searchTime + " ns");
        System.out.println("Remove: " + removeTime + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicySetManagement system =
                new InsurancePolicySetManagement();

        LocalDate today = LocalDate.now();

        Policy p1 = new Policy("P101", "Alice",
                today.plusDays(10), "Health", 12000);

        Policy p2 = new Policy("P102", "Bob",
                today.plusDays(45), "Auto", 15000);

        Policy p3 = new Policy("P103", "Carol",
                today.plusDays(20), "Home", 18000);

        Policy p4 = new Policy("P104", "David",
                today.plusDays(5), "Health", 10000);

        Policy duplicate = new Policy("P101", "Alice",
                today.plusDays(10), "Health", 12000);

        List<Policy> inputPolicies =
                Arrays.asList(p1, p2, p3, p4, duplicate);

        for (Policy policy : inputPolicies) {
            system.addPolicy(policy);
        }

        system.displayAllPolicies();
        system.displayInsertionOrder();
        system.displayExpiryOrder();
        system.displayExpiringSoon();
        system.displayByCoverage("Health");
        system.findDuplicatePolicyNumbers(inputPolicies);

        System.out.println("\nPerformance comparison:");
        system.performanceComparison(inputPolicies);
    }
}