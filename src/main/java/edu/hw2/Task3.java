package edu.hw2;

import java.util.Random;

public class Task3 {

    // Вероятность сбоя для соединения
    private static final double FAILURE_PROBABILITY = 0.3;

    // Интерфейс для соединения
    interface Connection extends AutoCloseable {
        void execute(String command);
    }

    // Исключение, связанное с соединением
    class ConnectionException extends RuntimeException {
        ConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // Реализация стабильного соединения
    class StableConnection implements Connection {
        @Override
        public void execute(String command) {
            // Реализация метода execute для стабильного соединения
        }

        @Override
        public void close() throws Exception {
            // Реализация метода close для стабильного соединения
        }
    }

    // Реализация нестабильного соединения
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
            // Реализация метода close для нестабильного соединения
        }
    }

    // Интерфейс для менеджера соединений
    interface ConnectionManager {
        Connection getConnection();
    }

    // Реализация менеджера соединений по умолчанию
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

    // Реализация менеджера нестабильных соединений
    class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            return new FaultyConnection(FAILURE_PROBABILITY);
        }
    }

    // Исполнитель популярных команд
    public final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        // Метод для обновления пакетов
        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        // Метод для попытки выполнения команды
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
