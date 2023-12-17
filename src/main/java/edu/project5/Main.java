package edu.project5;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Thread)
public class Main {
    private final static int VALUE = 5;
    private final static int WARMUPS = 2;

    private Student instance;
    private Class<?> tClass;
    private String methodName;
    private Object[] args;
    private Method method;
    private MethodHandle methodHandle;
    private MyFunctionalInterface methodWithMetaFactory;

    public static void main(String[] args) {
        // uncomment to start benchmark

        /*try {
            org.openjdk.jmh.Main.main(args);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    @Setup
    public void setupParams() {
        // for first method
        instance = new Student("Egor", "Fka");

        // for second method
        methodName = "name";
        args = new Object[0];
        tClass = instance.getClass();

        try {
            method = tClass.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // for third method
        try {
            methodHandle = MethodHandles.lookup().unreflect(method);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // for fourth method
        try {
            methodWithMetaFactory = (MyFunctionalInterface) LambdaMetafactory.metafactory(
                MethodHandles.lookup(),
                "apply",
                MethodType.methodType(MyFunctionalInterface.class),
                MethodType.methodType(Object.class, Object.class),
                methodHandle,
                MethodType.methodType(Object.class, tClass)
            ).getTarget().invokeExact();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    @Fork(value = VALUE, warmups = WARMUPS)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public String firstCalcBench(Blackhole bh) {
        Object res = instance.name();
        bh.consume(res);
        return res.toString();
    }

    @Benchmark
    @Fork(value = VALUE, warmups = WARMUPS)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public String secondCalcBench(Blackhole bh) {
        try {
            Object res = method.invoke(instance, args);
            bh.consume(res);
            return res.toString();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    @Fork(value = VALUE, warmups = WARMUPS)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public String thirdCalcBench(Blackhole bh) {
        try {
            Object res = methodHandle.invoke(instance);
            bh.consume(res);
            return res.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    @Fork(value = VALUE, warmups = WARMUPS)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public String fourthCalcBench(Blackhole bh) {
        try {
            Object res = methodWithMetaFactory.apply(instance);
            bh.consume(res);
            return res.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
