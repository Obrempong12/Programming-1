import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

    // Method to continuously update and print the current time
    public static void updateAndPrintTime() {
        while (true) {
            updateClock();
            try {
                Thread.sleep(1000); // Update every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to update the current time
    private static void updateClock() {
        // Simulate fetching updated time from a server or system clock
        // Here we just print the current time and date
        System.out.println("Updating time: " + dateFormat.format(new Date()));
    }
}