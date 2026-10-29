public class InventoryManagementSystem {

    static class Item {
        String name;
        int itemId;
        int quantity;
        double price;
        Item next;

        Item(String name, int itemId, int quantity, double price) {
            this.name = name;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
        }
    }

    static class Inventory {
        private Item head;

        void addFirst(String name, int id, int quantity, double price) {
            if (!validItem(quantity, price)) return;

            Item item = new Item(name, id, quantity, price);
            item.next = head;
            head = item;
        }

        void addLast(String name, int id, int quantity, double price) {
            if (!validItem(quantity, price)) return;

            Item item = new Item(name, id, quantity, price);

            if (head == null) {
                head = item;
                return;
            }

            Item current = head;
            while (current.next != null) current = current.next;
            current.next = item;
        }

        void addAtPosition(int position, String name, int id,
                           int quantity, double price) {
            if (!validItem(quantity, price) || position < 1) {
                System.out.println("Invalid item or position.");
                return;
            }

            if (position == 1) {
                addFirst(name, id, quantity, price);
                return;
            }

            Item current = head;
            for (int i = 1; current != null && i < position - 1; i++) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("Position out of range.");
                return;
            }

            Item item = new Item(name, id, quantity, price);
            item.next = current.next;
            current.next = item;
        }

        private boolean validItem(int quantity, double price) {
            if (quantity < 0 || price < 0) {
                System.out.println("Quantity and price must be nonnegative.");
                return false;
            }
            return true;
        }

        void removeById(int id) {
            if (head == null) return;

            if (head.itemId == id) {
                head = head.next;
                return;
            }

            Item current = head;
            while (current.next != null && current.next.itemId != id) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            } else {
                System.out.println("Item not found.");
            }
        }

        void updateQuantity(int id, int quantity) {
            if (quantity < 0) {
                System.out.println("Quantity cannot be negative.");
                return;
            }

            Item item = searchById(id);
            if (item == null) {
                System.out.println("Item not found.");
            } else {
                item.quantity = quantity;
            }
        }

        Item searchById(int id) {
            Item current = head;

            while (current != null) {
                if (current.itemId == id) return current;
                current = current.next;
            }

            return null;
        }

        void searchByName(String name) {
            boolean found = false;

            for (Item current = head; current != null;
                 current = current.next) {
                if (current.name.equalsIgnoreCase(name)) {
                    printItem(current);
                    found = true;
                }
            }

            if (!found) System.out.println("Item not found.");
        }

        double totalInventoryValue() {
            double total = 0;

            for (Item current = head; current != null;
                 current = current.next) {
                total += current.price * current.quantity;
            }

            return total;
        }

        // Sort by name or price; ascending=true means ascending order.
        void sort(String field, boolean ascending) {
            if (!field.equalsIgnoreCase("name")
                    && !field.equalsIgnoreCase("price")) {
                System.out.println("Sort field must be name or price.");
                return;
            }

            head = mergeSort(head, field, ascending);
        }

        private Item mergeSort(Item node, String field, boolean ascending) {
            if (node == null || node.next == null) return node;

            Item middle = getMiddle(node);
            Item secondHalf = middle.next;
            middle.next = null;

            Item left = mergeSort(node, field, ascending);
            Item right = mergeSort(secondHalf, field, ascending);

            return merge(left, right, field, ascending);
        }

        private Item getMiddle(Item node) {
            Item slow = node;
            Item fast = node.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        private Item merge(Item left, Item right,
                           String field, boolean ascending) {
            Item dummy = new Item("", 0, 0, 0);
            Item tail = dummy;

            while (left != null && right != null) {
                int comparison;

                if (field.equalsIgnoreCase("name")) {
                    comparison = left.name.compareToIgnoreCase(right.name);
                } else {
                    comparison = Double.compare(left.price, right.price);
                }

                if (!ascending) comparison = -comparison;

                if (comparison <= 0) {
                    tail.next = left;
                    left = left.next;
                } else {
                    tail.next = right;
                    right = right.next;
                }

                tail = tail.next;
            }

            tail.next = (left != null) ? left : right;
            return dummy.next;
        }

        void display() {
            for (Item current = head; current != null;
                 current = current.next) {
                printItem(current);
            }
        }

        private void printItem(Item item) {
            System.out.println(
                    "ID: " + item.itemId
                            + ", Name: " + item.name
                            + ", Quantity: " + item.quantity
                            + ", Price: " + item.price
            );
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addFirst("Keyboard", 101, 5, 1500);
        inventory.addLast("Mouse", 102, 10, 500);
        inventory.addAtPosition(2, "Monitor", 103, 3, 8000);

        System.out.println("Inventory:");
        inventory.display();

        inventory.updateQuantity(102, 15);
        System.out.println("\nTotal inventory value: "
                + inventory.totalInventoryValue());

        System.out.println("\nSorted by name, ascending:");
        inventory.sort("name", true);
        inventory.display();

        System.out.println("\nSorted by price, descending:");
        inventory.sort("price", false);
        inventory.display();

        System.out.println("\nSearch by name:");
        inventory.searchByName("Mouse");

        inventory.removeById(101);
        System.out.println("\nAfter removal:");
        inventory.display();
    }
}