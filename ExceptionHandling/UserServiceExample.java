import java.util.HashSet;
import java.util.Set;

// Custom exception when user already exists
class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

// Custom exception when user is not found
class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }
}

class UserService {

    private Set<String> users = new HashSet<>();

    // Register a new user
    public void registerUser(String username)
            throws UserAlreadyExistsException {

        if (users.contains(username)) {
            throw new UserAlreadyExistsException(
                    "User already exists: " + username
            );
        }

        users.add(username);

        System.out.println("User registered successfully: " + username);
    }

    // Check whether a user exists
    public void checkUserExistence(String username)
            throws UserNotFoundException {

        if (!users.contains(username)) {
            throw new UserNotFoundException(
                    "User not found: " + username
            );
        }

        System.out.println("User exists: " + username);
    }
}

public class UserServiceExample {

    public static void main(String[] args) {

        UserService service = new UserService();

        try {

            service.registerUser("Navya");

            service.registerUser("Navya");

        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {

            service.checkUserExistence("Rahul");

        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}