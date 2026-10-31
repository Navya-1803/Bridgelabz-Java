package DesignPattern.creational;

public class AbstractFactoryPattern {

    interface Car {
        void assemble();
    }

    interface Bike {
        void assemble();
    }

    static class Sedan implements Car {

        @Override
        public void assemble() {
            System.out.println("Assembling Sedan");
        }
    }

    static class SUV implements Car {

        @Override
        public void assemble() {
            System.out.println("Assembling SUV");
        }
    }

    static class SportsBike implements Bike {

        @Override
        public void assemble() {
            System.out.println("Assembling Sports Bike");
        }
    }

    static class NormalBike implements Bike {

        @Override
        public void assemble() {
            System.out.println("Assembling Normal Bike");
        }
    }

    abstract static class VehicleFactory {

        abstract Car createCar();

        abstract Bike createBike();
    }

    static class CarFactory extends VehicleFactory {

        @Override
        public Car createCar() {
            return new Sedan();
        }

        @Override
        public Bike createBike() {
            return new NormalBike();
        }
    }

    static class BikeFactory extends VehicleFactory {

        @Override
        public Car createCar() {
            return new SUV();
        }

        @Override
        public Bike createBike() {
            return new SportsBike();
        }
    }

    public static void main(String[] args) {

        VehicleFactory factory1 = new CarFactory();

        Car car = factory1.createCar();
        Bike bike = factory1.createBike();

        car.assemble();
        bike.assemble();

        VehicleFactory factory2 = new BikeFactory();

        Car car2 = factory2.createCar();
        Bike bike2 = factory2.createBike();

        car2.assemble();
        bike2.assemble();
    }
}