package za.co.wethinkcode.robotworlds.server.world_maze;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.server.track_robot_movements.Position;
import za.co.wethinkcode.robotworlds.server.world.Obstacle;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RandomMazeTest {

    @Test
    public void testGetObstacles() {
        RandomMaze maze = new RandomMaze();
        List<Obstacle> obstacles = maze.getObstacles();
        assertNotNull(obstacles);
        assertFalse(obstacles.isEmpty());
    }

    @Test
    public void testBlocksPath() {
        RandomMaze maze = new RandomMaze();
        Position positionA = new Position(0, 0);
        Position positionB = new Position(1, 1);
        assertFalse(maze.blocksPath(positionA, positionB));
    }
}

