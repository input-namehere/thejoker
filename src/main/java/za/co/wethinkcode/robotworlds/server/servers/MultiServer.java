package za.co.wethinkcode.robotworlds.server.servers;

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

import za.co.wethinkcode.robotworlds.server.world_maze.RandomMaze;
import za.co.wethinkcode.robotworlds.server.world.Robot_World;
import za.co.wethinkcode.robotworlds.server.world.Config_World;
public class MultiServer {
    public static final int PORT = 8080;

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        //variable pool keeps check of the cap number of clients currently its 50
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try (
                ServerSocket serverSocket = new ServerSocket(PORT);

        ) {
            System.out.println("Hey WeThinkCoder_ the RobotWorlds server is currently running\nConnect to the server by running the  SimpleClient Class.");
//            RandomMaze randomMaze = new RandomMaze();
//            Robot_World world = new Robot_World(randomMaze);
//            world.showObstacles();
            Config_World hostConfig = new Config_World();
            hostConfig.loadFileContents();
            hostConfig.displayDefaultConfigs();
            String hostResponse = hostConfig.checkIfUserWantsToChangeConfigs();
            if (hostResponse.equalsIgnoreCase("y")) {
                hostConfig.changeDefaultConfigs();
                System.out.println("successfully changed default world configs.....server currently waiting for client requests.");
                }
            else if (hostResponse.equalsIgnoreCase("n")){
                System.out.println("Great!! the default configs have been left unchanged......server currently waiting for client requests.");
            }


            while (true) {
                Socket socket = serverSocket.accept();
                pool.execute(new SimpleServer(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
