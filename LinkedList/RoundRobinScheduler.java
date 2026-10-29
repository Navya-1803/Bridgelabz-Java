public class RoundRobinScheduler {

    static class Process {
        int processId;
        int burstTime;
        int remainingTime;
        int priority;
        int completionTime;
        Process next;

        Process(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
        }
    }

    static class ProcessQueue {
        private Process head;
        private Process tail;
        private int size;

        void addProcess(int id, int burstTime, int priority) {
            if (burstTime <= 0) {
                System.out.println("Burst time must be positive.");
                return;
            }

            Process process = new Process(id, burstTime, priority);

            if (head == null) {
                head = tail = process;
                process.next = process;
            } else {
                process.next = head;
                tail.next = process;
                tail = process;
            }

            size++;
        }

        void removeProcess(int id) {
            if (head == null) return;

            Process previous = tail;
            Process current = head;

            do {
                if (current.processId == id) {
                    if (size == 1) {
                        head = tail = null;
                    } else {
                        previous.next = current.next;

                        if (current == head) head = current.next;
                        if (current == tail) tail = previous;

                        tail.next = head;
                    }

                    size--;
                    return;
                }

                previous = current;
                current = current.next;
            } while (current != head);
        }

        void displayQueue() {
            if (head == null) {
                System.out.println("Queue is empty.");
                return;
            }

            Process current = head;

            do {
                System.out.println(
                        "P" + current.processId
                                + " | Remaining time: " + current.remainingTime
                                + " | Priority: " + current.priority
                );
                current = current.next;
            } while (current != head);
        }

        void simulate(int quantum) {
            if (quantum <= 0) {
                System.out.println("Time quantum must be positive.");
                return;
            }

            if (head == null) {
                System.out.println("No processes to schedule.");
                return;
            }

            int processCount = size;
            int[] ids = new int[processCount];
            int[] bursts = new int[processCount];
            int[] completion = new int[processCount];

            Process current = head;
            for (int i = 0; i < processCount; i++) {
                ids[i] = current.processId;
                bursts[i] = current.burstTime;
                current = current.next;
            }

            int time = 0;

            while (head != null) {
                current = head;

                // Visit each process present at the start of this round once.
                int processesThisRound = size;

                for (int i = 0; i < processesThisRound; i++) {
                    Process nextProcess = current.next;

                    int executionTime = Math.min(
                            quantum, current.remainingTime);

                    current.remainingTime -= executionTime;
                    time += executionTime;

                    System.out.println(
                            "Executed P" + current.processId
                                    + " for " + executionTime + " time units."
                    );

                    if (current.remainingTime == 0) {
                        current.completionTime = time;

                        for (int j = 0; j < processCount; j++) {
                            if (ids[j] == current.processId) {
                                completion[j] = time;
                                break;
                            }
                        }

                        removeProcess(current.processId);
                    }

                    // nextProcess might have been removed if the process
                    // just executed was the only remaining process.
                    if (head == null) break;

                    current = nextProcess;
                }

                System.out.println("Queue after round:");
                displayQueue();
                System.out.println("-------------------");
            }

            double totalWaiting = 0;
            double totalTurnaround = 0;

            System.out.println("\nScheduling results:");
            for (int i = 0; i < processCount; i++) {
                int turnaround = completion[i]; // Arrival time is zero.
                int waiting = turnaround - bursts[i];

                totalTurnaround += turnaround;
                totalWaiting += waiting;

                System.out.println(
                        "P" + ids[i]
                                + " | Burst: " + bursts[i]
                                + " | Completion: " + completion[i]
                                + " | Waiting: " + waiting
                                + " | Turnaround: " + turnaround
                );
            }

            System.out.println("Average waiting time: "
                    + totalWaiting / processCount);
            System.out.println("Average turnaround time: "
                    + totalTurnaround / processCount);
        }
    }

    public static void main(String[] args) {
        ProcessQueue queue = new ProcessQueue();

        queue.addProcess(1, 5, 2);
        queue.addProcess(2, 3, 1);
        queue.addProcess(3, 7, 3);

        System.out.println("Initial process queue:");
        queue.displayQueue();

        System.out.println("\nStarting Round Robin scheduling:");
        queue.simulate(2);
    }
}