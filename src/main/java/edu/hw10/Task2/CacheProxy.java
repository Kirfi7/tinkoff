package edu.hw10.Task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cacheValues;
    private final String cacheDir = "src" + File.separator + "main" + File.separator + "resources";

    private CacheProxy(Object target) {
        this.target = target;
        this.cacheValues = new HashMap<>();
    }

    public static <T> T create(Object target, Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[] {interfaceClass},
            new CacheProxy(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cacheAnnotation = method.getAnnotation(Cache.class);

        if (cacheAnnotation == null) {
            return method.invoke(target, args);
        }

        String key = method.getName() + args[0];

        if (cacheValues.containsKey(key)) {
            return cacheValues.get(key);
        }

        Object result = method.invoke(target, args);
        cacheValues.put(key, result);

        if (cacheAnnotation.persist()) {
            persistResult(key, result);
        }

        return result;
    }

    private void persistResult(String key, Object result) {
        String filePath = cacheDir + File.separator + key + ".txt";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(result);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
