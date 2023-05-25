//package za.co.wethinkcode.robotworlds.server.commands;
//
//import za.co.wethinkcode.robotworlds.server.world_bots.Robot;
//
//import java.io.IOException;
//
//public class QuitCommand extends Command {
//    public QuitCommand() {
//        super("quit", "Exit the program");
//    }
//
//    @Override
//    public boolean execute(Robot target) {
//        try {
//            target.getServer().close();
//            return false;
//        } catch (IOException e) {
//            System.err.println("Error closing socket: " + e.getMessage());
//            return true;
//        }
//    }
//}
//
//public QuitCommand(String robotName) {
//        super(robotName);
//        }
//
//@Override
//public String execute() {
//        World.remove(robotName);
//        return "Quit Successful";
//        }
//import za.co.wethinkcode.robotworlds.server.World;