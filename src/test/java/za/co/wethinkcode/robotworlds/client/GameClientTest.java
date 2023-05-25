package za.co.wethinkcode.robotworlds.client;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class GameClientTest {
    private GameClient gameClient;

    @Before
    public void setup() {
        gameClient = new GameClient();
    }

    @Test
    public void testGetInputMessage() {
        String input = "Hello this is just a test to see if game client does get input message";
        provideInput(input);
        String message = gameClient.getInputMessage();
        assertEquals(input, message);
    }


    private void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }


}
