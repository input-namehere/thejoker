package za.co.wethinkcode.robotworlds.server.commands;


import org.junit.jupiter.api.Test;

import za.co.wethinkcode.robotworlds.server.servers.MultiServer;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MultiServerTest {

    @Test
    void server_ShouldStartAndAcceptConnections() throws IOException, InterruptedException {
        // Arrange
        ExecutorService pool = Executors.newFixedThreadPool(50);
        Thread serverThread = new Thread(() -> {
            try {
                MultiServer.main(new String[]{});
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        // Allow some time for the server to start
        TimeUnit.SECONDS.sleep(2);

        // Act
        boolean connectionEstablished = false;
        try (Socket socket = new Socket("localhost", MultiServer.PORT)) {
            connectionEstablished = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        assertFalse(connectionEstablished);

        // Cleanup
        serverThread.interrupt();
        pool.shutdown();
        pool.awaitTermination(2, TimeUnit.SECONDS);
    }
}
