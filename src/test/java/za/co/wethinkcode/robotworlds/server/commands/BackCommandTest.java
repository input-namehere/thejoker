package za.co.wethinkcode.robotworlds.server.commands;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.server.track_robot_movements.Position;
import za.co.wethinkcode.robotworlds.server.world.IWorld;
import za.co.wethinkcode.robotworlds.server.world_bots.Robot;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BackCommandTest {
    @Test
    void getBackName() {
        BackCommand test = new BackCommand("100");
        assertEquals("back", test.getName());
        assertEquals("100", test.getArgument());
    }

    @Test
    void executeBack() {
        Robot robot = new Robot("Bob", "SomeOtherString");
        Command back10 = Command.create("back 10");
        assertTrue(back10.execute(robot));
        Position expectedPosition = new Position(IWorld.CENTRE.getX(), IWorld.CENTRE.getY() - 10);
        assertEquals(expectedPosition, robot.getPosition());
        assertEquals("Moved backward by 10 steps.", robot.getStatus());
    }
}
