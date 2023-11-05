package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    private Task3() {

    }

    public static Map<Animal.Type, Integer> countAnimalsByType(List<Animal> animals) {
        Map<Animal.Type, Integer> animalCountMap = new HashMap<>();
        for (Animal animal : animals) {
            animalCountMap.put(animal.type(), animalCountMap.getOrDefault(animal.type(), 0) + 1);
        }
        return animalCountMap;
    }
}

