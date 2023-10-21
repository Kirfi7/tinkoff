package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task3Tests {

    @Test
    public void testStableConnection() {
        Task3 task3 = new Task3();
        Task3.ConnectionManager connectionManager = task3.new DefaultConnectionManager(0.0);
        Task3.PopularCommandExecutor executor = new Task3().new PopularCommandExecutor(connectionManager, 3);
        assertDoesNotThrow(() -> executor.updatePackages());
    }

    @Test
    public void testFaultyConnection() {
        Task3 task3 = new Task3();
        Task3.ConnectionManager connectionManager = () -> {
            Task3.Connection connection = mock(Task3.Connection.class);
            doThrow(new Task3().new ConnectionException("Connection failed", new RuntimeException("Underlying connection issue"))).when(connection).execute(any());
            return connection;
        };
        Task3.PopularCommandExecutor executor = new Task3().new PopularCommandExecutor(connectionManager, 3);
        assertThrows(Task3.ConnectionException.class, () -> executor.tryExecute("Some command"));
    }

    @Test
    public void testMaxAttemptsExceeded() {
        Task3 task3 = new Task3();
        Task3.ConnectionManager connectionManager = () -> {
            Task3.Connection connection = mock(Task3.Connection.class);
            doThrow(new Task3().new ConnectionException("Connection failed", new RuntimeException("Underlying connection issue"))).when(connection).execute(any());
            return connection;
        };
        Task3.PopularCommandExecutor executor = new Task3().new PopularCommandExecutor(connectionManager, 2);
        assertThrows(Task3.ConnectionException.class, () -> executor.tryExecute("Some command"));
    }

    @Test
    public void testFaultyConnectionExecute() {
        Task3 task3 = new Task3();
        Task3.FaultyConnection connection = task3.new FaultyConnection(0.3);
        try {
            connection.execute("Some command that causes failure");
        } catch (Task3.ConnectionException e) {
            // Check if the root cause is RuntimeException
            assertTrue(e.getCause() instanceof RuntimeException);
        }
    }


    @Test
    public void testFaultyConnectionManager() {
        Task3 task3 = new Task3();
        Task3.FaultyConnectionManager connectionManager = task3.new FaultyConnectionManager();
        assertNotNull(connectionManager.getConnection());
    }

    @Test
    public void testTryExecuteRuntimeException() {
        Task3 task3 = new Task3();
        Task3.ConnectionManager connectionManager = () -> {
            throw new RuntimeException("Simulated RuntimeException");
        };
        Task3.PopularCommandExecutor executor = task3.new PopularCommandExecutor(connectionManager, 3);
        assertThrows(RuntimeException.class, () -> executor.tryExecute("Some command"));
    }

    @Test
    public void testTryExecuteConnectionException() {
        Task3 task3 = new Task3();
        Task3.ConnectionManager connectionManager = () -> {
            throw new Task3().new ConnectionException("Simulated ConnectionException", new RuntimeException("Underlying connection issue"));
        };
        Task3.PopularCommandExecutor executor = task3.new PopularCommandExecutor(connectionManager, 3);
        assertThrows(Task3.ConnectionException.class, () -> executor.tryExecute("Some command"));
    }

    @Test
    public void testFaultyConnectionClose() {
        Task3 task3 = new Task3();
        Task3.FaultyConnection connection = task3.new FaultyConnection(0.3);
        assertDoesNotThrow(connection::close);
    }

    @Test
    public void testDefaultConnectionManagerGetConnectionStable() {
        Task3 task3 = new Task3();
        Task3.DefaultConnectionManager connectionManager = task3.new DefaultConnectionManager(0.0);
        assertTrue(connectionManager.getConnection() instanceof Task3.StableConnection);
    }

    @Test
    public void testFaultyConnectionManagerGetConnection() {
        Task3 task3 = new Task3();
        Task3.FaultyConnectionManager connectionManager = task3.new FaultyConnectionManager();
        assertTrue(connectionManager.getConnection() instanceof Task3.FaultyConnection);
    }

    @Test
    public void testFaultyConnectionExecuteWithFailure() {
        Task3 task3 = new Task3();
        Task3.FaultyConnection connection = task3.new FaultyConnection(0.3);
        // Попробуйте несколько раз, чтобы убедиться, что исключение вызывается при сбое
        for (int i = 0; i < 100; i++) {
            try {
                connection.execute("Some command");
            } catch (Task3.ConnectionException e) {
                // Убедитесь, что исключение имеет правильное сообщение и причину
                assertEquals("Connection failed", e.getMessage());
                assertTrue(e.getCause() instanceof RuntimeException);
                return;
            }
        }
        fail("Expected Task3.ConnectionException to be thrown");
    }

    @Test
    public void testDefaultConnectionManagerGetConnectionReturnsFaultyConnection() {
        double failureProbability = 0.3;
        Task3 task3 = new Task3();
        Task3.DefaultConnectionManager connectionManager = task3.new DefaultConnectionManager(failureProbability);
        double randomValue = connectionManager.random.nextDouble();
        // Проверьте, что при вероятности сбоя больше, чем failureProbability, возвращается FaultyConnection
        if (randomValue <= failureProbability) {
            assertTrue(connectionManager.getConnection() instanceof Task3.FaultyConnection);
        } else {
            assertFalse(connectionManager.getConnection() instanceof Task3.FaultyConnection);
        }
    }


    @Test
    public void testDefaultConnectionManagerGetConnectionReturnsStableConnection() {
        double failureProbability = 0.3;
        Task3 task3 = new Task3();
        Task3.DefaultConnectionManager connectionManager = task3.new DefaultConnectionManager(failureProbability);
        double randomValue = connectionManager.random.nextDouble();
        // Проверьте, что при вероятности сбоя меньше, чем failureProbability, возвращается StableConnection
        if (randomValue >= failureProbability) {
            assertTrue(connectionManager.getConnection() instanceof Task3.StableConnection);
        } else {
            assertFalse(connectionManager.getConnection() instanceof Task3.StableConnection);
        }
    }




}
