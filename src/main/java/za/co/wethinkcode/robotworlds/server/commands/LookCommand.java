package za.co.wethinkcode.robotworlds.server.commands;
import za.co.wethinkcode.robotworlds.server.world_bots.Robot;

import java.util.HashMap;

public class LookCommand extends Command{
    public LookCommand() {
        super("look");
    }

    @Override
    public boolean execute(Robot target) {
        return false;
    }
}

