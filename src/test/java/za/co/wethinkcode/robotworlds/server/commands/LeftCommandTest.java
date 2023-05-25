package za.co.wethinkcode.robotworlds.server.commands;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.server.track_robot_movements.Robot_Direction;
import za.co.wethinkcode.robotworlds.server.world_bots.Robot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeftCommandTest {
    @Test
    void executeLeft() {
        Robot robot = new Robot("Bob", "SomeOtherString");
        robot.setCurrentDirection(Robot_Direction.NORTH); // Set the initial direction

        LeftCommand leftCommand = new LeftCommand();
        assertTrue(leftCommand.execute(robot));

        assertEquals(Robot_Direction.WEST, robot.getCurrentDirection());
        assertEquals("Turned left.", robot.getStatus());
    }
}