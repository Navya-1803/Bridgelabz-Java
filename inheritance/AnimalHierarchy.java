public class AnimalHierarchy {

    static class Animal {
        protected String name;
        protected int age;

        Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void makeSound() {
            System.out.println("Animal makes a sound.");
        }
    }

    static class Dog extends Animal {
        Dog(String name, int age) {
            super(name, age);
        }

        @Override
        void makeSound() {
            System.out.println(name + " says Woof!");
        }
    }

    static class Cat extends Animal {
        Cat(String name, int age) {
            super(name, age);
        }

        @Override
        void makeSound() {
            System.out.println(name + " says Meow!");
        }
    }

    static class Bird extends Animal {
        Bird(String name, int age) {
            super(name, age);
        }

        @Override
        void makeSound() {
            System.out.println(name + " chirps!");
        }
    }

    public static void main(String[] args) {
        // Parent-class references hold child-class objects.
        Animal[] animals = {
                new Dog("Bruno", 3),
                new Cat("Luna", 2),
                new Bird("Tweety", 1)
        };

        for (Animal animal : animals) {
            animal.makeSound(); // Calls the overridden method.
        }
    }
}