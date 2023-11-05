package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task13 {

    private Task13() {

    }

    public static List<Animal> findAnimalsWithNamesLongerThanTwoWords(List<Animal> animals) {
        List<Animal> resultAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            String[] words = animal.name().split(" ");
            if (words.length > 2) {
                resultAnimals.add(animal);
            }
        }
        return resultAnimals;
    }
}

