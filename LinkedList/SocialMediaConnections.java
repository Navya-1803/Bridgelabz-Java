public class SocialMediaConnections {

    static class Friend {
        int friendId;
        Friend next;

        Friend(int friendId) {
            this.friendId = friendId;
        }
    }

    static class User {
        int userId;
        String name;
        int age;
        Friend friends;
        User next;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
        }
    }

    static class SocialNetwork {
        private User head;

        void addUser(int id, String name, int age) {
            if (findUserById(id) != null) {
                System.out.println("User ID already exists.");
                return;
            }

            User user = new User(id, name, age);
            user.next = head;
            head = user;
        }

        User findUserById(int id) {
            User current = head;

            while (current != null) {
                if (current.userId == id) return current;
                current = current.next;
            }

            return null;
        }

        void searchByName(String name) {
            boolean found = false;

            for (User user = head; user != null; user = user.next) {
                if (user.name.equalsIgnoreCase(name)) {
                    System.out.println(
                            "ID: " + user.userId
                                    + ", Name: " + user.name
                                    + ", Age: " + user.age
                    );
                    found = true;
                }
            }

            if (!found) System.out.println("User not found.");
        }

        private boolean hasFriend(User user, int friendId) {
            for (Friend friend = user.friends;
                 friend != null; friend = friend.next) {
                if (friend.friendId == friendId) return true;
            }

            return false;
        }

        private void addFriendId(User user, int friendId) {
            if (hasFriend(user, friendId)) return;

            Friend friend = new Friend(friendId);
            friend.next = user.friends;
            user.friends = friend;
        }

        private void removeFriendId(User user, int friendId) {
            Friend current = user.friends;
            Friend previous = null;

            while (current != null) {
                if (current.friendId == friendId) {
                    if (previous == null) {
                        user.friends = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    return;
                }

                previous = current;
                current = current.next;
            }
        }

        // Connections are mutual: A is added to B and B to A.
        void addConnection(int firstId, int secondId) {
            if (firstId == secondId) {
                System.out.println("A user cannot be their own friend.");
                return;
            }

            User first = findUserById(firstId);
            User second = findUserById(secondId);

            if (first == null || second == null) {
                System.out.println("Both users must exist.");
                return;
            }

            addFriendId(first, secondId);
            addFriendId(second, firstId);
            System.out.println("Friend connection added.");
        }

        void removeConnection(int firstId, int secondId) {
            User first = findUserById(firstId);
            User second = findUserById(secondId);

            if (first == null || second == null) {
                System.out.println("User not found.");
                return;
            }

            removeFriendId(first, secondId);
            removeFriendId(second, firstId);
            System.out.println("Friend connection removed.");
        }

        void displayFriends(int userId) {
            User user = findUserById(userId);

            if (user == null) {
                System.out.println("User not found.");
                return;
            }

            System.out.println("Friends of " + user.name + ":");
            Friend friend = user.friends;

            if (friend == null) {
                System.out.println("No friends.");
                return;
            }

            while (friend != null) {
                User friendUser = findUserById(friend.friendId);

                if (friendUser != null) {
                    System.out.println(
                            friendUser.userId + " - " + friendUser.name);
                }

                friend = friend.next;
            }
        }

        void findMutualFriends(int firstId, int secondId) {
            User first = findUserById(firstId);
            User second = findUserById(secondId);

            if (first == null || second == null) {
                System.out.println("User not found.");
                return;
            }

            boolean found = false;

            for (Friend friend = first.friends;
                 friend != null; friend = friend.next) {
                if (hasFriend(second, friend.friendId)) {
                    User mutual = findUserById(friend.friendId);

                    if (mutual != null) {
                        System.out.println(
                                mutual.userId + " - " + mutual.name);
                        found = true;
                    }
                }
            }

            if (!found) System.out.println("No mutual friends.");
        }

        int countFriends(int userId) {
            User user = findUserById(userId);
            if (user == null) return -1;

            int count = 0;

            for (Friend friend = user.friends;
                 friend != null; friend = friend.next) {
                count++;
            }

            return count;
        }

        void displayAllFriendCounts() {
            for (User user = head; user != null; user = user.next) {
                System.out.println(
                        user.name + " has " + countFriends(user.userId)
                                + " friend(s)."
                );
            }
        }
    }

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        network.addUser(1, "Ananya", 21);
        network.addUser(2, "Rahul", 22);
        network.addUser(3, "Priya", 20);
        network.addUser(4, "Arjun", 23);

        network.addConnection(1, 2);
        network.addConnection(1, 3);
        network.addConnection(2, 3);
        network.addConnection(2, 4);

        System.out.println("\nAnanya's friends:");
        network.displayFriends(1);

        System.out.println("\nMutual friends of Ananya and Rahul:");
        network.findMutualFriends(1, 2);

        System.out.println("\nFriend counts:");
        network.displayAllFriendCounts();

        System.out.println("\nSearch by name:");
        network.searchByName("Priya");

        network.removeConnection(1, 3);
        System.out.println("\nAnanya's friends after removal:");
        network.displayFriends(1);
    }
}