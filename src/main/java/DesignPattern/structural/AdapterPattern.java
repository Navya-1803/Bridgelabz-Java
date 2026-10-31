package DesignPattern.structural;

public class AdapterPattern {

    interface NewPrinter {
        void print();
    }

    static class OldPrinter {

        public void oldPrint() {
            System.out.println("Printing using old printer");
        }
    }

    static class PrinterAdapter implements NewPrinter {

        private final OldPrinter oldPrinter;

        public PrinterAdapter(OldPrinter oldPrinter) {
            this.oldPrinter = oldPrinter;
        }

        @Override
        public void print() {
            oldPrinter.oldPrint();
        }
    }

    public static void main(String[] args) {

        OldPrinter oldPrinter = new OldPrinter();

        NewPrinter printer = new PrinterAdapter(oldPrinter);

        printer.print();
    }
}