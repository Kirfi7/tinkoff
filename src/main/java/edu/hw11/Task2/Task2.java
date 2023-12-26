package edu.hw11.Task2;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.matcher.ElementMatchers;

public class Task2 {
    private Task2() {
    }

    public static int getResult(Class<?> tClass, String methodName, int value1, int value2) {
        Class<?> modifiedClass = new ByteBuddy()
            .subclass(tClass)
            .method(ElementMatchers.named(methodName))
            .intercept(MethodDelegation.to(ArithmeticInterceptor.class))
            .make()
            .load(Task2.class.getClassLoader(), ClassLoadingStrategy.Default.INJECTION)
            .getLoaded();

        try {
            return (int) modifiedClass.getMethod(methodName, int.class, int.class)
                .invoke(
                    modifiedClass.getDeclaredConstructor().newInstance(),
                    value1, value2
                );
        } catch (IllegalAccessException | InvocationTargetException
                 | NoSuchMethodException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    private static class ArithmeticInterceptor {
        @RuntimeType
        public static Object intercept(@AllArguments Object[] args, @SuperCall Callable<?> callable) {
            int a = (int) args[0];
            int b = (int) args[1];
            return a * b;
        }
    }
}
