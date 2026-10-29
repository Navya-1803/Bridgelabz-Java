public class StudentRecordManagement {

    static class Student {
        int rollNumber;
        String name;
        int age;
        String grade;
        Student next;

        Student(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }

    static class StudentList {
        private Student head;

        // Add a student at the beginning.
        void addFirst(int roll, String name, int age, String grade) {
            Student node = new Student(roll, name, age, grade);
            node.next = head;
            head = node;
        }

        // Add a student at the end.
        void addLast(int roll, String name, int age, String grade) {
            Student node = new Student(roll, name, age, grade);

            if (head == null) {
                head = node;
                return;
            }

            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }

        // Positions are 1-based.
        void addAtPosition(int position, int roll, String name,
                           int age, String grade) {
            if (position < 1) {
                System.out.println("Invalid position.");
                return;
            }

            if (position == 1) {
                addFirst(roll, name, age, grade);
                return;
            }

            Student current = head;

            for (int i = 1; current != null && i < position - 1; i++) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("Position out of range.");
                return;
            }

            Student node = new Student(roll, name, age, grade);
            node.next = current.next;
            current.next = node;
        }

        void deleteByRollNumber(int roll) {
            if (head == null) {
                System.out.println("Student list is empty.");
                return;
            }

            if (head.rollNumber == roll) {
                head = head.next;
                System.out.println("Student deleted.");
                return;
            }

            Student current = head;

            while (current.next != null
                    && current.next.rollNumber != roll) {
                current = current.next;
            }

            if (current.next == null) {
                System.out.println("Student not found.");
            } else {
                current.next = current.next.next;
                System.out.println("Student deleted.");
            }
        }

        Student search(int roll) {
            Student current = head;

            while (current != null) {
                if (current.rollNumber == roll) {
                    return current;
                }
                current = current.next;
            }

            return null;
        }

        void updateGrade(int roll, String newGrade) {
            Student student = search(roll);

            if (student == null) {
                System.out.println("Student not found.");
            } else {
                student.grade = newGrade;
                System.out.println("Grade updated.");
            }
        }

        void display() {
            Student current = head;

            if (current == null) {
                System.out.println("No student records.");
                return;
            }

            while (current != null) {
                System.out.println(
                        "Roll: " + current.rollNumber
                                + ", Name: " + current.name
                                + ", Age: " + current.age
                                + ", Grade: " + current.grade
                );
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        StudentList students = new StudentList();

        students.addFirst(101, "Ananya", 20, "A");
        students.addLast(102, "Rahul", 21, "B");
        students.addAtPosition(2, 103, "Priya", 19, "A+");

        System.out.println("All students:");
        students.display();

        System.out.println("\nSearch roll number 102:");
        Student found = students.search(102);
        System.out.println(found != null ? found.name : "Not found");

        students.updateGrade(102, "A");
        students.deleteByRollNumber(101);

        System.out.println("\nAfter update and deletion:");
        students.display();
    }
}