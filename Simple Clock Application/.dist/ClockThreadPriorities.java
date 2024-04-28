public class ClockThreadPriorities {
    public static void main(String[] args) {
        ClockThreads.startBackgroundThread();
        ClockThreads.startDisplayThread();
    }
}