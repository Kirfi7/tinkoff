package edu.hw4;

import java.util.List;

public class Task12 {

    private Task12() {

    }

    public static int countAnimalsWeightGreaterThanHeight(List<Animal> animals) {
        int count = 0;
        for (Animal animal : animals) {
            if (animal.weight() > animal.height()) {
                count++;
            }
        }
        return count;
    }
}

