package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task10 {

    private Task10() {

    }

    public static List<Animal> findAnimalsWithAgeNotMatchingPaws(List<Animal> animals) {
        List<Animal> resultAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.age() != animal.paws()) {
                resultAnimals.add(animal);
            }
        }
        return resultAnimals;
    }
}

