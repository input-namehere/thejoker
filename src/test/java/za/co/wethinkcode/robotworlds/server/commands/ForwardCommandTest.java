package za.co.wethinkcode.robotworlds.server.commands;
import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.server.track_robot_movements.Position;
import za.co.wethinkcode.robotworlds.server.world.IWorld;
import za.co.wethinkcode.robotworlds.server.world_bots.Robot;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForwardCommandTest {
    @Test
    void executeForward() {
        Robot robot = new Robot("Bob", "anotherString");
        Command forward10 = Command.create("forward 10");
        assertTrue(forward10.execute(robot));
        Position expectedPosition = new Position(IWorld.CENTRE.getX(), IWorld.CENTRE.getY() + 10);
        assertEquals(expectedPosition, robot.getPosition());
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }

    @Test
    void getForwardName() {
        ForwardCommand test = new ForwardCommand("100");
        assertEquals("forward", test.getName());
        assertEquals("100", test.getArgument());
    }

}
