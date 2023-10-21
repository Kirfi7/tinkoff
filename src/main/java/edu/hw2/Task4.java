package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {

    private static final Logger LOGGER = LogManager.getLogger(Task4.class);

    @SuppressWarnings("HideUtilityClassConstructor")
    public class CallingInfoUtil {

        CallingInfoUtil() {

        }

        public static CallingInfo callingInfo() {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            String className = stackTraceElements[2].getClassName();
            String methodName = stackTraceElements[2].getMethodName();
            return new CallingInfo(className, methodName);
        }
    }

    public record CallingInfo(String className, String methodName) {}
}

