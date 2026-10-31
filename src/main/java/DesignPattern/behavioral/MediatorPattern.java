package DesignPattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {

    interface ChatMediator {

        void sendMessage(String message, User sender);

        void addUser(User user);
    }

    static class ChatRoom implements ChatMediator {

        private final List<User> users = new ArrayList<>();

        @Override
        public void addUser(User user) {
            users.add(user);
        }

        @Override
        public void sendMessage(String message, User sender) {

            for (User user : users) {

                if (user != sender) {
                    user.receiveMessage(message, sender.getName());
                }
            }
        }
    }

    static class User {

        private final String name;
        private final ChatMediator mediator;

        public User(String name, ChatMediator mediator) {
            this.name = name;
            this.mediator = mediator;
        }

        public String getName() {
            return name;
        }

        public void sendMessage(String message) {
            System.out.println(name + " sends: " + message);
            mediator.sendMessage(message, this);
        }

        public void receiveMessage(String message, String sender) {
            System.out.println(name + " receives from "
                    + sender + ": " + message);
        }
    }

    public static void main(String[] args) {

        ChatMediator chatRoom = new ChatRoom();

        User user1 = new User("Rahul", chatRoom);
        User user2 = new User("Priya", chatRoom);
        User user3 = new User("Ananya", chatRoom);

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.sendMessage("Hello everyone!");
    }
}