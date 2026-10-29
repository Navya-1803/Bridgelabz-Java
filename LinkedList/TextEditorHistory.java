public class TextEditorHistory {

    static class State {
        String text;
        State prev;
        State next;

        State(String text) {
            this.text = text;
        }
    }

    static class Editor {
        private State head;
        private State tail;
        private State current;
        private int size;
        private final int maxHistory;

        Editor(int maxHistory) {
            if (maxHistory < 1) {
                throw new IllegalArgumentException(
                        "History limit must be at least 1.");
            }

            this.maxHistory = maxHistory;

            // Initial empty document.
            current = new State("");
            head = tail = current;
            size = 1;
        }

        void addState(String text) {
            State node = new State(text);

            // A new edit removes any redo history after current.
            current.next = null;
            tail = current;

            node.prev = current;
            current.next = node;
            current = tail = node;
            size++;

            // Remove the oldest states when history exceeds the limit.
            while (size > maxHistory) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }

        void undo() {
            if (current != null && current.prev != null) {
                current = current.prev;
                System.out.println("Undo successful.");
            } else {
                System.out.println("Nothing to undo.");
            }
        }

        void redo() {
            if (current != null && current.next != null) {
                current = current.next;
                System.out.println("Redo successful.");
            } else {
                System.out.println("Nothing to redo.");
            }
        }

        void displayCurrentText() {
            System.out.println("Current text: \"" + current.text + "\"");
        }

        void displayHistory() {
            System.out.println("Available history:");

            for (State state = head; state != null; state = state.next) {
                String marker = state == current ? " <-- current" : "";
                System.out.println("\"" + state.text + "\"" + marker);
            }
        }
    }

    public static void main(String[] args) {
        Editor editor = new Editor(10);

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.displayCurrentText();

        editor.undo();
        editor.displayCurrentText();

        editor.undo();
        editor.displayCurrentText();

        editor.redo();
        editor.displayCurrentText();

        editor.addState("Hello Java");
        editor.displayHistory();

        // Demonstrate the history limit.
        for (int i = 1; i <= 10; i++) {
            editor.addState("Text version " + i);
        }

        System.out.println("\nAfter adding more than 10 states:");
        editor.displayHistory();
    }
}