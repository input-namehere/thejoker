package za.co.wethinkcode.robotworlds.server.world_bots;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.server.commands.Command;
import za.co.wethinkcode.robotworlds.server.world_bots.Play;
import za.co.wethinkcode.robotworlds.server.world_bots.Robot;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayTest {

    @Test
    public void testMove() {
        Play play = new Play("Robot1", "MyRobot");
        play.setInstruction("move");

        play.move();

        Robot robot = play.getRobot();
        String expectedPrompt = "MyRobot> what must i do next?";
        String expectedMessage = "Robot: MyRobot, Position: (0,0), Direction: null, Status: ";

        assertEquals(expectedPrompt, play.getMyPrompt());
//        assertEquals(expectedMessage, play.getMessageToTheServer());
    }

    @Test
    public void testInvalidCommand() {
        Play play = new Play("Robot1", "MyRobot");
        play.setInstruction("invalidCommand");

        play.move();

        Robot robot = play.getRobot();
        String expectedPrompt = "MyRobot> what must i do next?";
        String expectedStatus = "Sorry, I did not understand 'invalidCommand'.";

        assertEquals(expectedPrompt, play.getMyPrompt());
        assertEquals(expectedStatus, robot.getStatus());
    }
}
