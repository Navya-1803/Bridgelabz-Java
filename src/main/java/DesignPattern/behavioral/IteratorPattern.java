package DesignPattern.behavioral;

public class IteratorPattern {

    interface Iterator {
        boolean hasNext();

        String next();
    }

    static class NameRepository {

        private final String[] names = {
                "Rahul", "Priya", "Ananya", "Arjun"
        };

        public Iterator getIterator() {

            return new Iterator() {

                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < names.length;
                }

                @Override
                public String next() {

                    if (hasNext()) {
                        return names[index++];
                    }

                    return null;
                }
            };
        }
    }

    public static void main(String[] args) {

        NameRepository repository = new NameRepository();

        Iterator iterator = repository.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}