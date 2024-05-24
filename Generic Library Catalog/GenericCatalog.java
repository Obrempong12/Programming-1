import java.util.ArrayList;
import java.util.List;

public class GenericCatalog<T> {
    private List<LibraryItem<T>> items;

    public GenericCatalog() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem<T> item) {
        items.add(item);
    }

    public void removeItem(T itemID) {
        items.removeIf(item -> item.getItemID().equals(itemID));
    }

    public LibraryItem<T> getItemDetails(T itemID) {
        for (LibraryItem<T> item : items) {
            if (item.getItemID().equals(itemID)) {
                return item;
            }
        }
        return null;
    }

    public List<LibraryItem<T>> getAllItems() {
        return new ArrayList<>(items);
    }
}