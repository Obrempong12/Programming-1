public class MainTest {
    public static void main(String[] args) {
        GenericCatalog<String> catalog = new GenericCatalog<>();

        // Add items
        catalog.addItem(new LibraryItem<>("The Great Gatsby", "F. Scott Fitzgerald", "B001"));
        catalog.addItem(new LibraryItem<>("Inception", "Christopher Nolan", "D001"));
        catalog.addItem(new LibraryItem<>("National Geographic", "Various", "M001"));

        // Remove an item
        catalog.removeItem("B001");

        // View an item
        LibraryItem<String> item = catalog.getItemDetails("D001");
        if (item != null) {
            System.out.println("Retrieved item: " + item);
        } else {
            System.out.println("Item not found.");
        }

        // List all items
        System.out.println("All items in the catalog:");
        for (LibraryItem<String> catalogItem : catalog.getAllItems()) {
            System.out.println(catalogItem);
        }
    }
}