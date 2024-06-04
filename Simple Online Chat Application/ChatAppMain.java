import java.util.Scanner;

public class ChatAppMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Chat Application!");
        System.out.println("Please select an option:");
        System.out.println("1. Start Chat Server");
        System.out.println("2. Start Chat Client");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                startServer();
                break;
            case 2:
                startClient();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                break;
        }

        scanner.close();
    }

    private static void startServer() {
        Thread serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ChatServer.main(new String[0]);
            }
        });
        serverThread.start();
    }

    private static void startClient() {
        Thread clientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ChatClient.main(new String[0]);
            }
        });
        clientThread.start();
    }
}