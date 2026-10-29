package level2;

public class PalindromeTextValidator {

    static class PalindromeChecker {
        String text;

        // Initialize the text
        PalindromeChecker(String text) {
            this.text = text;
        }

        // Check whether the text reads the same forward and backward
        boolean isPalindrome() {
            int left = 0;
            int right = text.length() - 1;

            while (left < right) {
                if (text.charAt(left) != text.charAt(right)) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }

        // Display the result
        void displayResult() {
            if (isPalindrome()) {
                System.out.println(text + " is a palindrome.");
            } else {
                System.out.println(text + " is not a palindrome.");
            }
        }
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker("madam");

        checker.displayResult();
    }
}
