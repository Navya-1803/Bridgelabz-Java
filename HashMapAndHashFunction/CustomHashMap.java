public class CustomHashMap {

    static class Entry {
        int key;
        String value;
        Entry next;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    static class SimpleHashMap {
        private final Entry[] buckets;
        private final int capacity;

        SimpleHashMap(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException(
                        "Capacity must be positive."
                );
            }

            this.capacity = capacity;
            this.buckets = new Entry[capacity];
        }

        // Hash function maps a key to a valid bucket index.
        private int hash(int key) {
            return Math.floorMod(Integer.hashCode(key), capacity);
        }

        // Insert a new key or update an existing key.
        void put(int key, String value) {
            int index = hash(key);
            Entry current = buckets[index];

            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }

                current = current.next;
            }

            Entry entry = new Entry(key, value);
            entry.next = buckets[index];
            buckets[index] = entry;
        }

        // Retrieve a value; null means the key is absent.
        String get(int key) {
            int index = hash(key);
            Entry current = buckets[index];

            while (current != null) {
                if (current.key == key) {
                    return current.value;
                }

                current = current.next;
            }

            return null;
        }

        // Delete a key from its bucket's linked list.
        void remove(int key) {
            int index = hash(key);
            Entry current = buckets[index];
            Entry previous = null;

            while (current != null) {
                if (current.key == key) {
                    if (previous == null) {
                        buckets[index] = current.next;
                    } else {
                        previous.next = current.next;
                    }

                    return;
                }

                previous = current;
                current = current.next;
            }
        }

        void display() {
            for (int i = 0; i < capacity; i++) {
                System.out.print("Bucket " + i + ": ");

                Entry current = buckets[i];

                while (current != null) {
                    System.out.print(
                            "[" + current.key + " = " + current.value + "] -> "
                    );
                    current = current.next;
                }

                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        // Small capacity makes collisions easy to demonstrate.
        SimpleHashMap map = new SimpleHashMap(5);

        map.put(1, "Apple");
        map.put(6, "Banana");  // Same bucket as key 1.
        map.put(11, "Cherry"); // Also collides in that bucket.
        map.put(2, "Mango");

        System.out.println("Value for key 6: " + map.get(6));

        // Updating an existing key does not create a duplicate entry.
        map.put(6, "Orange");
        System.out.println("Updated value: " + map.get(6));

        map.remove(1);

        System.out.println("\nHash map after removal:");
        map.display();
    }
}