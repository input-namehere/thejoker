package za.co.wethinkcode.robotworlds.server.track_robot_movements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testEquals() {
        Position position1 = new Position(3, 5);
        Position position2 = new Position(3, 5);
        Position position3 = new Position(3, 7);

        assertTrue(position1.equals(position2));
        assertFalse(position1.equals(position3));
    }
}
