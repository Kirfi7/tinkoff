package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task11 {

    private static final int NUM = 100;

    private Task11() {

    }

    public static List<Animal> findAnimalsCanBiteWithHeightGreaterThan100(List<Animal> animals) {
        List<Animal> resultAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.bites() && animal.height() > NUM) {
                resultAnimals.add(animal);
            }
        }
        return resultAnimals;
    }
}

