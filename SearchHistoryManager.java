import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchHistoryManager {
    private static List<String> searchHistory = new ArrayList<>();
    private static List<Date> searchTimestamps = new ArrayList<>();

    public static void addToHistory(String query) {
        searchHistory.add(query);
        searchTimestamps.add(new Date());
    }

    public static List<String> getSearchHistory() {
        return searchHistory;
    }

    public static List<Date> getSearchTimestamps() {
        return searchTimestamps;
    }
}