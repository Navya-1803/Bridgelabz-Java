public class TaskScheduler {

    static class Task {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Task next;

        Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    static class TaskList {
        private Task head;
        private Task tail;
        private Task current;
        private int size;

        void addFirst(int id, String name, int priority, String dueDate) {
            Task node = new Task(id, name, priority, dueDate);

            if (head == null) {
                head = tail = node;
                node.next = node;
                current = node;
            } else {
                node.next = head;
                head = node;
                tail.next = head;
            }

            size++;
        }

        void addLast(int id, String name, int priority, String dueDate) {
            if (head == null) {
                addFirst(id, name, priority, dueDate);
                return;
            }

            Task node = new Task(id, name, priority, dueDate);
            node.next = head;
            tail.next = node;
            tail = node;
            size++;
        }

        // Positions are 1-based.
        void addAtPosition(int position, int id, String name,
                           int priority, String dueDate) {
            if (position < 1 || position > size + 1) {
                System.out.println("Invalid position.");
                return;
            }

            if (position == 1) {
                addFirst(id, name, priority, dueDate);
                return;
            }

            if (position == size + 1) {
                addLast(id, name, priority, dueDate);
                return;
            }

            Task previous = head;
            for (int i = 1; i < position - 1; i++) {
                previous = previous.next;
            }

            Task node = new Task(id, name, priority, dueDate);
            node.next = previous.next;
            previous.next = node;
            size++;
        }

        void removeById(int id) {
            if (head == null) {
                System.out.println("No tasks.");
                return;
            }

            Task previous = tail;
            Task target = head;

            do {
                if (target.taskId == id) {
                    if (size == 1) {
                        head = tail = current = null;
                    } else {
                        previous.next = target.next;

                        if (target == head) {
                            head = target.next;
                        }

                        if (target == tail) {
                            tail = previous;
                        }

                        tail.next = head;

                        if (current == target) {
                            current = target.next;
                        }
                    }

                    size--;
                    System.out.println("Task removed.");
                    return;
                }

                previous = target;
                target = target.next;
            } while (target != head);

            System.out.println("Task not found.");
        }

        void viewCurrentTask() {
            if (current == null) {
                System.out.println("No tasks available.");
                return;
            }

            printTask(current);
        }

        void moveToNextTask() {
            if (current == null) {
                System.out.println("No tasks available.");
                return;
            }

            current = current.next;
            System.out.println("Moved to next task:");
            printTask(current);
        }

        void searchByPriority(int priority) {
            if (head == null) {
                System.out.println("No tasks.");
                return;
            }

            Task currentTask = head;
            boolean found = false;

            do {
                if (currentTask.priority == priority) {
                    printTask(currentTask);
                    found = true;
                }
                currentTask = currentTask.next;
            } while (currentTask != head);

            if (!found) {
                System.out.println("No tasks with this priority.");
            }
        }

        void display() {
            if (head == null) {
                System.out.println("No tasks.");
                return;
            }

            Task task = head;

            do {
                printTask(task);
                task = task.next;
            } while (task != head);
        }

        private void printTask(Task task) {
            System.out.println(
                    "ID: " + task.taskId
                            + ", Name: " + task.taskName
                            + ", Priority: " + task.priority
                            + ", Due: " + task.dueDate
            );
        }
    }

    public static void main(String[] args) {
        TaskList tasks = new TaskList();

        tasks.addFirst(1, "Complete assignment", 1, "2026-11-01");
        tasks.addLast(2, "Prepare report", 2, "2026-11-03");
        tasks.addAtPosition(2, 3, "Review notes", 1, "2026-11-02");

        System.out.println("All tasks:");
        tasks.display();

        System.out.println("\nCurrent task:");
        tasks.viewCurrentTask();

        System.out.println("\nNext task:");
        tasks.moveToNextTask();

        System.out.println("\nSearch priority 1:");
        tasks.searchByPriority(1);

        tasks.removeById(2);
        System.out.println("\nRemaining tasks:");
        tasks.display();
    }
}