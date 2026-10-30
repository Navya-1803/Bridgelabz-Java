public class MultipleCatchExample {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40};

        // Change this to null to test NullPointerException
        int index = 2;

        try {
            System.out.println(
                    "Value at index " + index + ": " + numbers[index]
            );

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}