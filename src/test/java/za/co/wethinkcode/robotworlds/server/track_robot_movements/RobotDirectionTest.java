package za.co.wethinkcode.robotworlds.server.track_robot_movements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RobotDirectionTest {

    @Test
    public void testGetRobotAngle() {
        assertEquals(0, Robot_Direction.NORTH.getRobotAngle());
        assertEquals(90, Robot_Direction.EAST.getRobotAngle());
        assertEquals(180, Robot_Direction.SOUTH.getRobotAngle());
        assertEquals(270, Robot_Direction.WEST.getRobotAngle());
    }

    @Test
    public void testEnumValues() {
        Robot_Direction[] directions = Robot_Direction.values();

        assertEquals(4, directions.length);
        assertEquals(Robot_Direction.NORTH, directions[0]);
        assertEquals(Robot_Direction.EAST, directions[1]);
        assertEquals(Robot_Direction.SOUTH, directions[2]);
        assertEquals(Robot_Direction.WEST, directions[3]);
    }
}
