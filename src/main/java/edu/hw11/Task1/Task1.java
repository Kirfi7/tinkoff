package edu.hw11.Task1;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class Task1 {
    private Task1() {
    }

    public static Object getObjectWithStaticToString() {
        try {
            return new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.isToString())
                .intercept(FixedValue.value("Hello, ByteBuddy!"))
                .make()
                .load(Task1.class.getClassLoader())
                .getLoaded()
                .newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

