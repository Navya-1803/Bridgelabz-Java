package DesignPattern.structural;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {

    interface Employee {
        void showDetails();
    }

    static class Developer implements Employee {

        private final String name;
        private final String position;

        public Developer(String name) {
            this.name = name;
            this.position = "Developer";
        }

        @Override
        public void showDetails() {
            System.out.println(position + ": " + name);
        }
    }

    static class Manager implements Employee {

        private final String name;
        private final List<Employee> employees = new ArrayList<>();

        public Manager(String name) {
            this.name = name;
        }

        public void addEmployee(Employee employee) {
            employees.add(employee);
        }

        public void removeEmployee(Employee employee) {
            employees.remove(employee);
        }

        @Override
        public void showDetails() {

            System.out.println("Manager: " + name);

            for (Employee employee : employees) {
                employee.showDetails();
            }
        }
    }

    public static void main(String[] args) {

        Developer developer1 = new Developer("Rahul");
        Developer developer2 = new Developer("Priya");

        Manager teamLead = new Manager("Ananya");

        teamLead.addEmployee(developer1);
        teamLead.addEmployee(developer2);

        Manager director = new Manager("Arjun");
        director.addEmployee(teamLead);

        director.showDetails();
    }
}