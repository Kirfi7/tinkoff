package edu.hw2;

import java.util.Random;

public class Task3 {

    private static final double FAILURE_PROBABILITY = 0.3;

    interface Connection extends AutoCloseable {
        void execute(String command);
    }

    class ConnectionException extends RuntimeException {
        ConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    class StableConnection implements Connection {
        @Override
        public void execute(String command) {
            // Implement execute method for stable connection
        }

        @Override
        public void close() throws Exception {
            // Implement close method for stable connection
        }
    }

    class FaultyConnection implements Connection {
        private final double failureProbability;
        private final Random random;

        FaultyConnection(double failureProbability) {
            this.failureProbability = failureProbability;
            this.random = new Random();
        }

        @Override
        public void execute(String command) {
            if (random.nextDouble() < failureProbability) {
                throw new ConnectionException("Connection failed", new RuntimeException("Underlying connection issue"));
            }
        }

        @Override
        public void close() throws Exception {
        }
    }

    interface ConnectionManager {
        Connection getConnection();
    }

    class DefaultConnectionManager implements ConnectionManager {
        public final double failureProbability;
        final Random random;

        DefaultConnectionManager(double failureProbability) {
            this.failureProbability = failureProbability;
            this.random = new Random();
        }

        @Override
        public Connection getConnection() {
            if (random.nextDouble() < failureProbability) {
                return new FaultyConnection(FAILURE_PROBABILITY);
            } else {
                return new StableConnection();
            }
        }
    }

    class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            return new FaultyConnection(FAILURE_PROBABILITY);
        }
    }

    public final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        public void tryExecute(String command) {
            int attempts = 0;
            Exception lastException = null;
            while (attempts < maxAttempts) {
                try (Connection connection = manager.getConnection()) {
                    connection.execute(command);
                    return;
                } catch (ConnectionException e) {
                    lastException = e;
                    attempts++;
                } catch (Exception e) {
                    throw new RuntimeException("Error executing command", e);
                }
            }
            if (lastException != null) {
                throw new ConnectionException("Failed to execute command after multiple attempts", lastException);
            }
        }
    }
}
