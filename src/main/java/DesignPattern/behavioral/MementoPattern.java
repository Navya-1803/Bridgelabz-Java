package DesignPattern.behavioral;

public class MementoPattern {

    static class Editor {

        private String content = "";

        public void write(String text) {
            content = text;
        }

        public String getContent() {
            return content;
        }

        public Memento save() {
            return new Memento(content);
        }

        public void restore(Memento memento) {
            content = memento.getSavedContent();
        }
    }

    static class Memento {

        private final String content;

        private Memento(String content) {
            this.content = content;
        }

        private String getSavedContent() {
            return content;
        }
    }

    static class Caretaker {

        private Memento savedState;

        public void saveState(Editor editor) {
            savedState = editor.save();
        }

        public void restoreState(Editor editor) {
            if (savedState != null) {
                editor.restore(savedState);
            }
        }
    }

    public static void main(String[] args) {

        Editor editor = new Editor();
        Caretaker caretaker = new Caretaker();

        editor.write("First version");
        caretaker.saveState(editor);

        System.out.println("Current Content: " + editor.getContent());

        editor.write("Second version");

        System.out.println("Updated Content: " + editor.getContent());

        caretaker.restoreState(editor);

        System.out.println("Restored Content: " + editor.getContent());
    }
}