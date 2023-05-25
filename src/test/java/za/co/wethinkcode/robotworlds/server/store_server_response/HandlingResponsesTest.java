package za.co.wethinkcode.robotworlds.server.store_server_response;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.server.store_server_response.HandlingResponses;
import za.co.wethinkcode.robotworlds.server.track_robot_movements.Position;
import za.co.wethinkcode.robotworlds.server.world_bots.Robot;
import za.co.wethinkcode.robotworlds.server.track_robot_movements.Robot_Direction;
import za.co.wethinkcode.robotworlds.server.world_bots.Play;

import static org.junit.jupiter.api.Assertions.*;

public class HandlingResponsesTest {

    @Test
    public void testResponse() {
        HandlingResponses handlingResponses = new HandlingResponses();

        String expectedResponse = "{\"status\":\"\",\"position\":\"(3, 4)\",\"shields\":\"5\",\"prompt\":\"Enter your command:\",\"shots\":\"4\",\"direction\":\"NORTH\",\"name\":\"Robot1\",\"state\":\"\"}";
        String actualResponse = handlingResponses.response();

        assertNotEquals(expectedResponse, actualResponse);
    }
}
