package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 {

    private Task6() {

    }

    public static Map<Animal.Type, Animal> findHeaviestAnimalForEachType(List<Animal> animals) {
        Map<Animal.Type, Animal> heaviestAnimalMap = new HashMap<>();
        for (Animal animal : animals) {
            if (!heaviestAnimalMap.containsKey(animal.type()) || animal.weight()
                > heaviestAnimalMap.get(animal.type()).weight()) {
                heaviestAnimalMap.put(animal.type(), animal);
            }
        }
        return heaviestAnimalMap;
    }
}

