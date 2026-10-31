package DesignPattern.structural;

public class DecoratorPattern {

    interface Coffee {
        double cost();
    }

    static class SimpleCoffee implements Coffee {

        @Override
        public double cost() {
            return 50;
        }
    }

    abstract static class CoffeeDecorator implements Coffee {

        protected Coffee coffee;

        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }
    }

    static class MilkDecorator extends CoffeeDecorator {

        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double cost() {
            return coffee.cost() + 10;
        }
    }

    static class SugarDecorator extends CoffeeDecorator {

        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double cost() {
            return coffee.cost() + 5;
        }
    }

    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();

        System.out.println("Simple Coffee: Rs." + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println("Coffee with Milk: Rs." + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println("Coffee with Milk and Sugar: Rs."
                + coffee.cost());
    }
}