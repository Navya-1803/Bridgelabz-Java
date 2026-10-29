public class StringBuilderReverseString {
    public static void main(String[] args) {
        String input = "hello";

        // Create a StringBuilder and append the input
        StringBuilder builder = new StringBuilder();
        builder.append(input);

        // Reverse the string
        String reversed = builder.reverse().toString();

        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reversed);
    }
}