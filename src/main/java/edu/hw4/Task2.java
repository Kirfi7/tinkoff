package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task2 {

    private Task2() {

    }

    public static List<Animal> sortAndSelectTopKByWeight(List<Animal> animals, int k) {
        List<Animal> sortedAnimals = new ArrayList<>(animals);
        Collections.sort(sortedAnimals, Comparator.comparingInt(Animal::weight).reversed());
        return sortedAnimals.subList(0, Math.min(k, sortedAnimals.size()));
    }
}

