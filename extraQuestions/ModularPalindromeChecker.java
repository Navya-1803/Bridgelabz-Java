import java.util.Scanner;

public class ModularPalindromeChecker {

    // Read the input string
    public static String readText(Scanner input) {
        System.out.print("Enter a word or phrase: ");
        return input.nextLine();
    }

    // Check whether the text is a palindrome, ignoring case and punctuation
    public static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters on the left
            while (left < right
                    && !Character.isLetterOrDigit(text.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters on the right
            while (left < right
                    && !Character.isLetterOrDigit(text.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(text.charAt(left))
                    != Character.toLowerCase(text.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Display the result
    public static void displayResult(String text, boolean result) {
        if (result) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String text = readText(input);
        boolean result = isPalindrome(text);

        displayResult(text, result);

        input.close();
    }
}
