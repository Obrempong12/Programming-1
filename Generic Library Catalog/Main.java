import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenericCatalog<String> catalog = new GenericCatalog<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command (add, remove, view, list, exit):");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    addItem(scanner, catalog);
                    break;
                case "remove":
                    removeItem(scanner, catalog);
                    break;
                case "view":
                    viewItem(scanner, catalog);
                    break;
                case "list":
                    listItems(catalog);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }

    private static void addItem(Scanner scanner, GenericCatalog<String> catalog) {
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Enter item ID:");
        String itemID = scanner.nextLine();

        LibraryItem<String> item = new LibraryItem<>(title, author, itemID);
        catalog.addItem(item);
        System.out.println("Item added.");
    }

    private static void removeItem(Scanner scanner, GenericCatalog<String> catalog) {
        System.out.println("Enter item ID to remove:");
        String itemID = scanner.nextLine();

        catalog.removeItem(itemID);
        System.out.println("Item removed.");
    }

    private static void viewItem(Scanner scanner, GenericCatalog<String> catalog) {
        System.out.println("Enter item ID to view:");
        String itemID = scanner.nextLine();

        LibraryItem<String> item = catalog.getItemDetails(itemID);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void listItems(GenericCatalog<String> catalog) {
        for (LibraryItem<String> item : catalog.getAllItems()) {
            System.out.println(item);
        }
    }
}