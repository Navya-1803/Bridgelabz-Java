package DesignPattern.structural;

public class ProxyPattern {

    interface FileService {
        void accessFile(String fileName);
    }

    static class RealFileService implements FileService {

        @Override
        public void accessFile(String fileName) {
            System.out.println("Accessing file: " + fileName);
        }
    }

    static class FileAccessProxy implements FileService {

        private final RealFileService realFileService;
        private final String userRole;

        public FileAccessProxy(String userRole) {
            this.realFileService = new RealFileService();
            this.userRole = userRole;
        }

        @Override
        public void accessFile(String fileName) {

            if (userRole.equalsIgnoreCase("ADMIN")) {
                realFileService.accessFile(fileName);
            } else {
                System.out.println(
                        "Access denied. Admin permission required.");
            }
        }
    }

    public static void main(String[] args) {

        FileService admin =
                new FileAccessProxy("ADMIN");

        FileService user =
                new FileAccessProxy("USER");

        admin.accessFile("confidential.txt");
        user.accessFile("confidential.txt");
    }
}