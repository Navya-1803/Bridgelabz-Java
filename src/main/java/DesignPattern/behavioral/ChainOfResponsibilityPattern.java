package DesignPattern.behavioral;

public class ChainOfResponsibilityPattern {

    abstract static class Handler {

        protected Handler nextHandler;

        public void setNextHandler(Handler handler) {
            this.nextHandler = handler;
        }

        public abstract void handleRequest(String request);
    }

    static class TeamLead extends Handler {

        @Override
        public void handleRequest(String request) {

            if (request.equalsIgnoreCase("Code Review")) {
                System.out.println("Team Lead handled: " + request);
            } else if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }

    static class Manager extends Handler {

        @Override
        public void handleRequest(String request) {

            if (request.equalsIgnoreCase("Project Approval")) {
                System.out.println("Manager handled: " + request);
            } else if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }

    static class HR extends Handler {

        @Override
        public void handleRequest(String request) {

            if (request.equalsIgnoreCase("Leave Approval")) {
                System.out.println("HR handled: " + request);
            } else {
                System.out.println("No handler found for: " + request);
            }
        }
    }

    public static void main(String[] args) {

        Handler teamLead = new TeamLead();
        Handler manager = new Manager();
        Handler hr = new HR();

        teamLead.setNextHandler(manager);
        manager.setNextHandler(hr);

        teamLead.handleRequest("Code Review");
        teamLead.handleRequest("Project Approval");
        teamLead.handleRequest("Leave Approval");
        teamLead.handleRequest("Salary Revision");
    }
}