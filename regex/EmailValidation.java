import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailValidation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regex = "^[A-Za-z0-9_-]+(?:\\.[A-Za-z0-9_-]+)*@[A-Za-z0-9]+(?:\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,}$";

        Pattern pattern = Pattern.compile(regex);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (pattern.matcher(email).matches()) {
            System.out.println(email + " is a valid email.");
        } else {
            System.out.println(email + " is an invalid email.");
        }

        scanner.close();
    }
}