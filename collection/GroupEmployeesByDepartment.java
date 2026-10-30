import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupEmployeesByDepartment {

    static class Employee {
        String name;
        String department;

        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static Map<String, List<Employee>> groupEmployees(
            List<Employee> employees) {

        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee employee : employees) {
            grouped.computeIfAbsent(
                    employee.department,
                    key -> new ArrayList<>()
            ).add(employee);
        }

        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> result =
                groupEmployees(employees);

        result.forEach((department, members) ->
                System.out.println(department + ": " + members));
    }
}