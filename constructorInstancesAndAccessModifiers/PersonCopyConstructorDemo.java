class Person {
    String name;
    int age;
    String city;

    // Parameterized constructor
    Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Copy constructor: copies attributes from another Person object
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.city = other.city;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
    }
}

public class PersonCopyConstructorDemo {
    public static void main(String[] args) {
        Person original = new Person("Aarav", 22, "Chennai");
        Person copy = new Person(original);

        System.out.println("Original Person:");
        original.displayDetails();

        System.out.println("\nCopied Person:");
        copy.displayDetails();
    }
}