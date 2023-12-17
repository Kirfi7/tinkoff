package edu.hw10.Task1Tests;

import edu.hw10.Task1.Max;
import edu.hw10.Task1.Min;
import edu.hw10.Task1.NotNull;

public class MyClassWithFabric {
    private final int real;
    private final double doub;
    private final String str;

    private MyClassWithFabric(int real, double doub, String str) {
        this.real = real;
        this.doub = doub;
        this.str = str;
    }

    public static MyClassWithFabric create(@Min(0) @Max(10) int real, double doub, @NotNull String str) {
        return new MyClassWithFabric(real, doub, str);
    }

    public int getInt() {
        return real;
    }

    public double getDouble() {
        return doub;
    }

    public String getStr() {
        return str;
    }
}
