package za.co.wethinkcode.robotworlds.server.commands;


import za.co.wethinkcode.robotworlds.server.world_bots.Robot;
public class HelpCommand extends Command{

    public HelpCommand() {
        super("help");
    }

    @Override
    public boolean execute(Robot target) {
        target.setStatus("I can understand these commands:\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'\n" +
                "BACK - move backwards by specified number of steps, e.g. 'BACK 10'\n" +
                "RIGHT - turns to the right\n" +
                "LEFT - turns to the left\n" +
                "EXIT - use it when you want to exit the game\n" +
                "LOOK - shows the robot anything that is in its way but respecting the distance\n" +
                "REPAIR - repairs the robot\n" +
                "QUIT - this is for the server, it switches off the whole server\n" +
                "STATE - gives you the current state of the robot\n" +
                "FIRE - shoots robots\n"+
                "RELOAD - reloads robot weapon");
        return true;
    }



}
