
import java.util.Arrays;
import java.util.List;

public class UserRegistration {

    // UC1 START: Validate First Name
    // Rule: Starts with capital letter, minimum 3 characters

    private static boolean isValidFirstName(String firstName) {
        return firstName != null &&
                firstName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC2 START: Validate Last Name
    // Rule: Starts with capital letter, minimum 3 characters

    private static boolean isValidLastName(String lastName) {
        return lastName != null &&
                lastName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC3 START: Validate Email
    // Example: abc.xyz@bl.co.in
    // Mandatory: username, domain, domain extension
    // Optional: additional username and country extension

    private static boolean isValidEmail(String email) {

        String emailRegex =
                "^[A-Za-z0-9]+([._+-][A-Za-z0-9]+)?"
                        + "@[A-Za-z0-9]+\\.[A-Za-z]{2,}"
                        + "(\\.[A-Za-z]{2,})?$";

        return email != null && email.matches(emailRegex);
    }

    // UC4 START: Validate Mobile Number
    // Format: Country code + space + 10-digit number
    // Example: 91 9919819801

    private static boolean isValidMobile(String mobile) {

        return mobile != null &&
                mobile.matches("^[0-9]{2} [0-9]{10}$");
    }

    // UC5 START: Password Rule 1
    // Password must contain minimum 8 characters

    private static boolean isValidPasswordLength(String password) {

        return password != null && password.length() >= 8;
    }

    // UC6 START: Password Rule 2
    // Password must contain at least one uppercase letter

    private static boolean hasUppercase(String password) {

        return password != null &&
                password.matches(".*[A-Z].*");
    }

    // UC7 START: Password Rule 3
    // Password must contain at least one numeric digit

    private static boolean hasDigit(String password) {

        return password != null &&
                password.matches(".*[0-9].*");
    }

    // UC8 START: Password Rule 4
    // Password must contain exactly one special character

    private static boolean hasExactlyOneSpecialCharacter(
            String password) {

        if (password == null) {
            return false;
        }

        int specialCharacterCount = 0;

        for (char ch : password.toCharArray()) {

            if (!Character.isLetterOrDigit(ch)) {
                specialCharacterCount++;
            }
        }

        return specialCharacterCount == 1;
    }

    // UC9 START: Validate All Supplied Email Samples

    private static void testEmailSamples() {

        String[] validEmails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        };

        String[] invalidEmails = {
                "abc",
                "abc@.com.my",
                "abc123@gmail.a",
                "abc123@.com",
                "abc123@.com.com",
                ".abc@abc.com",
                "abc()*@gmail.com",
                "abc@%*.com",
                "abc..2002@gmail.com",
                "abc.@gmail.com",
                "abc@abc@gmail.com",
                "abc@gmail.com.1a",
                "abc@gmail.com.aa.au"
        };

        System.out.println("\nVALID EMAIL TESTS:");

        for (String email : validEmails) {

            System.out.println(
                    email + " : " + isValidEmail(email)
            );
        }

        System.out.println("\nINVALID EMAIL TESTS:");

        for (String email : invalidEmails) {

            System.out.println(
                    email + " : " + isValidEmail(email)
            );
        }
    }

    // UC12 START: Custom Exceptions for Invalid User Details

    static class InvalidFirstNameException extends Exception {
        public InvalidFirstNameException(String message) {
            super(message);
        }
    }

    static class InvalidLastNameException extends Exception {
        public InvalidLastNameException(String message) {
            super(message);
        }
    }

    static class InvalidEmailException extends Exception {
        public InvalidEmailException(String message) {
            super(message);
        }
    }

    static class InvalidMobileException extends Exception {
        public InvalidMobileException(String message) {
            super(message);
        }
    }

    static class InvalidPasswordException extends Exception {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }


    // UC13 START: Lambda-Based User Validation
    // Functional interface for validation

    @FunctionalInterface
    interface Validator {
        boolean validate(String input);
    }

    // Lambda expressions for each validation
    static final Validator FIRST_NAME_VALIDATOR =
            input -> isValidFirstName(input);

    static final Validator LAST_NAME_VALIDATOR =
            input -> isValidLastName(input);

    static final Validator EMAIL_VALIDATOR =
            input -> isValidEmail(input);

    static final Validator MOBILE_VALIDATOR =
            input -> isValidMobile(input);

    static final Validator PASSWORD_VALIDATOR =
            input -> isValidPasswordLength(input)
                    && hasUppercase(input)
                    && hasDigit(input)
                    && hasExactlyOneSpecialCharacter(input);


    // Registration method using lambda validators
    public static void registerUser(
            String firstName,
            String lastName,
            String email,
            String mobile,
            String password
    ) throws InvalidFirstNameException,
            InvalidLastNameException,
            InvalidEmailException,
            InvalidMobileException,
            InvalidPasswordException {

        if (!FIRST_NAME_VALIDATOR.validate(firstName)) {
            throw new InvalidFirstNameException(
                    "Invalid first name"
            );
        }

        if (!LAST_NAME_VALIDATOR.validate(lastName)) {
            throw new InvalidLastNameException(
                    "Invalid last name"
            );
        }

        if (!EMAIL_VALIDATOR.validate(email)) {
            throw new InvalidEmailException(
                    "Invalid email address"
            );
        }

        if (!MOBILE_VALIDATOR.validate(mobile)) {
            throw new InvalidMobileException(
                    "Invalid mobile number"
            );
        }

        if (!PASSWORD_VALIDATOR.validate(password)) {
            throw new InvalidPasswordException(
                    "Invalid password. Check all password rules"
            );
        }

        System.out.println("\nUser registration successful!");
    }

    // MAIN METHOD: Test complete user registration

    public static void main(String[] args) {

        System.out.println("USER REGISTRATION SYSTEM");

        // UC9: Test email samples
        testEmailSamples();

        // UC1-8 and UC12-13: Complete registration
        System.out.println("\nUSER REGISTRATION:");

        try {

            registerUser(
                    "Navya",
                    "Raj",
                    "abc.xyz@bl.co.in",
                    "91 9919819801",
                    "Navya@123"
            );

        } catch (InvalidFirstNameException
                 | InvalidLastNameException
                 | InvalidEmailException
                 | InvalidMobileException
                 | InvalidPasswordException e) {

            System.out.println("Registration failed: " + e.getMessage());
        }

        // Test an invalid registration
        System.out.println("\nINVALID REGISTRATION:");

        try {

            registerUser(
                    "navya",
                    "Raj",
                    "abc.xyz@bl.co.in",
                    "91 9919819801",
                    "Navya@123"
            );

        } catch (InvalidFirstNameException
                 | InvalidLastNameException
                 | InvalidEmailException
                 | InvalidMobileException
                 | InvalidPasswordException e) {

            System.out.println("Registration failed: " + e.getMessage());
        }
    }
}
