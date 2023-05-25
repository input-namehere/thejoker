//package za.co.wethinkcode.robotworlds.server.commands;
//
//import za.co.wethinkcode.robotworlds.server.world_bots.Robot;
//
///**
// * The FireCommand class represents a command to shoot an enemy in the game.
// * It extends the Command class.
// */
//public class FireCommand extends Command {
//    private static final int MAX_BULLETS = 6;
//    private int bullets;
//
//    /**
//     * Constructs a FireCommand object with the specified name.
//     * Initializes the bullets to the maximum value.
//     *
//     * @param name the name of the command
//     */
//    public FireCommand(String name) {
//        super(name);
//        bullets = MAX_BULLETS;
//    }
//
//    /**
//     * Executes the fire command by shooting the target robot.
//     * Decrements the bullet count and returns true if the shooting is successful,
//     * or false if there are no bullets left.
//     *
//     * @param target the target robot to shoot
//     * @return true if the shooting is successful, false otherwise
//     */
//    @Override
//    public boolean execute(Robot target) {
//        if (bullets > 0) {
//            shootEnemy(target);
//            return true;
//        } else {
//            System.out.println("No bullets left. Reload!");
//            return false;
//        }
//    }
//
//    /**
//     * Shoots the target robot and decrements the bullet count.
//     * Prints appropriate messages based on the outcome.
//     *
//     * @param target the target robot to shoot
//     */
//    private void shootEnemy(Robot target) {
//        System.out.println("You shot the enemy!");
//        bullets--;
////        target.setHealth(target.getHealth() - 1);
////        if (target.getHealth() <= 0) {
////            System.out.println("The enemy robot has been destroyed!");
////        } else {
////            System.out.println("The enemy robot's health is now: " + target.getHealth());
////        }
//    }
//
//    /**
//     * Reloads the bullets to the maximum value.
//     * Prints a message indicating that the bullets have been reloaded.
//     */
//    public void reloadBullets() {
//        bullets = MAX_BULLETS;
//        System.out.println("Bullets reloaded.");
//    }
//}
package za.co.wethinkcode.robotworlds.server.commands;

import za.co.wethinkcode.robotworlds.server.world_bots.Robot;

/**
 * The FireCommand class represents a command to shoot an enemy in the game.
 * It extends the Command class.
 */
public class FireCommand extends Command {
    private static final int MAX_BULLETS = 6;
    private int bullets;
    private int distance;

    /**
     * Constructs a FireCommand object with the specified name.
     * Initializes the bullets to the maximum value.
     *
     * @param name     the name of the command
     * @param distance the distance the gun can shoot
     */
    public FireCommand(String name, int distance) {
        super(name);
        bullets = MAX_BULLETS;
        this.distance = distance;
    }

    /**
     * Executes the fire command by shooting the target robot.
     * Decrements the bullet count and returns true if the shooting is successful,
     * or false if there are no bullets left.
     *
     * @param target the target robot to shoot
     * @return true if the shooting is successful, false otherwise
     */
    @Override
    public boolean execute(Robot target) {
        if (bullets > 0) {
            shootEnemy(target);
            return true;
        } else {
            System.out.println("No bullets left. Reload!");
            return false;
        }
    }

    /**
     * Shoots the target robot and decrements the bullet count.
     * Prints appropriate messages based on the outcome.
     *
     * @param target the target robot to shoot
     */
    private void shootEnemy(Robot target) {
        System.out.println("You shot the enemy!");
        bullets--;
//        int effectiveDistance = Math.min(distance, target.getDistance());
//        target.setHealth(target.getHealth() - effectiveDistance);
//        if (target.getHealth() <= 0) {
//            System.out.println("The enemy robot has been destroyed!");
//        } else {
//            System.out.println("The enemy robot's health is now: " + target.getHealth());
//        }
    }

    /**
     * Reloads the bullets to the maximum value.
     * Prints a message indicating that the bullets have been reloaded.
     */
    public void reloadBullets() {
        bullets = MAX_BULLETS;
        System.out.println("Bullets reloaded.");
    }
}
