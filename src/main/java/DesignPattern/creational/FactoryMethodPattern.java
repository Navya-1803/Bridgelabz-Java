package DesignPattern.creational;

public class FactoryMethodPattern {

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

    static class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("Drawing Rectangle");
        }
    }

    static class ShapeFactory {

        public static Shape getShape(String shapeType) {

            if (shapeType == null) {
                return null;
            }

            return switch (shapeType.toLowerCase()) {
                case "circle" -> new Circle();
                case "rectangle" -> new Rectangle();
                default -> throw new IllegalArgumentException(
                        "Invalid shape type: " + shapeType);
            };
        }
    }

    public static void main(String[] args) {

        Shape shape1 = ShapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("rectangle");
        shape2.draw();
    }
}