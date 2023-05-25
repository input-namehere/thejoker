package za.co.wethinkcode.robotworlds.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandlingRequestsTest {

    private HandlingRequests handlingRequests;

    @BeforeEach
    public void setUp() {
        handlingRequests = new HandlingRequests();
    }


    @Test
    public void testRequest() {
        handlingRequests.setCommand("command");
        handlingRequests.setRobot("robot");
        handlingRequests.setArguments("argument1");
        handlingRequests.setArguments("argument2");

        String expectedJson = "{\"robot\":\"robot\",\"command\":\"command\",\"arguments\":[\"argument1\",\"argument2\"]}";
        assertEquals(expectedJson, handlingRequests.request(""));
    }
}
