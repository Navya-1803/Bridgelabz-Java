package DesignPattern.structural;

public class BridgePattern {

    interface Color {
        void applyColor();
    }

    static class Red implements Color {

        @Override
        public void applyColor() {
            System.out.println("Applying Red color");
        }
    }

    static class Blue implements Color {

        @Override
        public void applyColor() {
            System.out.println("Applying Blue color");
        }
    }

    abstract static class Shape {

        protected Color color;

        public Shape(Color color) {
            this.color = color;
        }

        abstract void draw();
    }

    static class Circle extends Shape {

        public Circle(Color color) {
            super(color);
        }

        @Override
        public void draw() {
            System.out.print("Circle: ");
            color.applyColor();
        }
    }

    static class Square extends Shape {

        public Square(Color color) {
            super(color);
        }

        @Override
        public void draw() {
            System.out.print("Square: ");
            color.applyColor();
        }
    }

    public static void main(String[] args) {

        Shape circle = new Circle(new Red());
        Shape square = new Square(new Blue());

        Shape redSquare = new Square(new Red());
        Shape blueCircle = new Circle(new Blue());

        circle.draw();
        square.draw();
        redSquare.draw();
        blueCircle.draw();
    }
}