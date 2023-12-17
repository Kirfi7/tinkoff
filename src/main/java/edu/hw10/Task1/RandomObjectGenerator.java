package edu.hw10.Task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class RandomObjectGenerator {
    public <T> T nextObject(Class<T> tClass) {
        return nextObject(tClass, null);
    }

    public <T> T nextObject(Class<T> tClass, String factoryMethod) {
        if (tClass.isRecord() || factoryMethod == null) {
            return generateClass(tClass);
        }

        return generateWithFactory(tClass, factoryMethod);
    }

    private <T> T generateClass(Class<T> tClass) {
        Constructor<?> ctor = Arrays.stream(tClass.getDeclaredConstructors())
            .findFirst()
            .orElseThrow();

        Object[] initArgs = Arrays.stream(ctor.getParameters())
            .map(this::generateValue)
            .toArray();
        try {
            return (T) ctor.newInstance(initArgs);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T generateWithFactory(Class<T> tClass, String factoryMethodName) {
        Method method = Arrays.stream(tClass.getMethods())
            .filter(x -> x.getName().equals(factoryMethodName))
            .findFirst()
            .orElseThrow();

        Object[] initArgs = Arrays.stream(method.getParameters())
            .map(this::generateValue)
            .toArray();
        try {
            return (T) method.invoke(null, initArgs);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Object generateValue(Parameter param) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        boolean notNull = false;

        for (var i : param.getDeclaredAnnotations()) {
            if (i instanceof Min min1) {
                min = min1.value();
            } else if (i instanceof Max max1) {
                max = max1.value();
            } else if (i instanceof NotNull) {
                notNull = true;
            }
        }

        Type type = param.getAnnotatedType().getType();
        Random random = new SecureRandom();

        if (type == int.class || type == Integer.class) {
            return random.nextInt(min, max);
        } else if (type == double.class || type == Double.class) {
            return random.nextDouble(min, max);
        } else if (type == String.class) {
            return UUID.randomUUID().toString();
        }

        if (notNull) {
            throw new IllegalArgumentException();
        }

        return null;
    }
}
