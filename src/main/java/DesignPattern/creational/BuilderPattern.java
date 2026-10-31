package DesignPattern.creational;

public class BuilderPattern {

    static class User {

        private final String name;
        private final int age;
        private final String email;
        private final String address;

        private User(Builder builder) {
            this.name = builder.name;
            this.age = builder.age;
            this.email = builder.email;
            this.address = builder.address;
        }

        public void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Email: " + email);
            System.out.println("Address: " + address);
        }

        static class Builder {

            private final String name;
            private int age;
            private String email;
            private String address;

            public Builder(String name) {
                this.name = name;
            }

            public Builder age(int age) {
                this.age = age;
                return this;
            }

            public Builder email(String email) {
                this.email = email;
                return this;
            }

            public Builder address(String address) {
                this.address = address;
                return this;
            }

            public User build() {
                return new User(this);
            }
        }
    }

    public static void main(String[] args) {

        User user = new User.Builder("Navya")
                .age(21)
                .email("navya@example.com")
                .address("Chennai")
                .build();

        user.displayDetails();
    }
}