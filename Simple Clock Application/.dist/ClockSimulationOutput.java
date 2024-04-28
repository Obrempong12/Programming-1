public class ClockSimulationOutput {
    public static void main(String[] args) {
        // Run the clock threads to see the simulation output
        ClockThreads.startBackgroundThread();
        ClockThreads.startDisplayThread();
    }
}