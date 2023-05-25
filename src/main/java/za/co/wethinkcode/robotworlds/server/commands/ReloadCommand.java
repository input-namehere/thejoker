package za.co.wethinkcode.robotworlds.server.commands;

public class ReloadCommand {
    private static final int RELOAD_TIME = 5000; // Reload time in milliseconds

    public static boolean reloadBullets(int bullets, int maxBullets) {
        if (bullets == maxBullets) {
            System.out.println("Robot already has the maximum number of shots.");
            return false;
        }

        System.out.println("Reloading...");
        // Simulate reloading time
        try {
            Thread.sleep(RELOAD_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Robot reloaded to the maximum shots.");
        return true;
    }
}
