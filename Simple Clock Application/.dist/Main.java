public class Main {
    public static void main(String[] args) {
        // Start the clock threads with different priorities
        ClockThreads.startBackgroundThread();
        ClockThreads.startDisplayThread();
        
        // Simulate the clock output
        simulateClockOutput();
    }

    // Method to simulate the clock output
    private static void simulateClockOutput() {
        try {
            // Sleep for a while to observe the clock output
            Thread.sleep(10000); // Simulate for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}