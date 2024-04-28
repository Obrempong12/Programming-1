public class ClockThreads {
    // Method to create and start the background updating thread
    public static void startBackgroundThread() {
        Thread backgroundThread = new Thread(() -> {
            Clock.updateAndPrintTime();
        });
        backgroundThread.setPriority(Thread.MIN_PRIORITY);
        backgroundThread.start();
    }

    // Method to create and start the clock display thread
    public static void startDisplayThread() {
        Thread displayThread = new Thread(() -> {
            Clock.updateAndPrintTime();
        });
        displayThread.setPriority(Thread.MAX_PRIORITY);
        displayThread.start();
    }
}