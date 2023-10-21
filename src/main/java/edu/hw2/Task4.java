package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {

    // Приватное статическое поле LOGGER для логирования
    private static final Logger LOGGER = LogManager.getLogger(Task4.class);

    // Внутренний класс CallingInfoUtil для работы с информацией о вызове
    @SuppressWarnings("HideUtilityClassConstructor")
    public class CallingInfoUtil {

        // Приватный конструктор CallingInfoUtil
        CallingInfoUtil() {

        }

        // Метод callingInfo для получения информации о вызове
        public static CallingInfo callingInfo() {
            // Получение стека вызовов
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            // Получение имени класса
            String className = stackTraceElements[2].getClassName();
            // Получение имени метода
            String methodName = stackTraceElements[2].getMethodName();
            // Возвращение информации о вызове в виде объекта CallingInfo
            return new CallingInfo(className, methodName);
        }
    }

    // Запись (record) для хранения информации о вызове
    public record CallingInfo(String className, String methodName) {}
}
