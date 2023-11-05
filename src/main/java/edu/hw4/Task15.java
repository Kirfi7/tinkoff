package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task15 {

    private Task15() {

    }

    public static Map<Animal.Type, Integer> calculateTotalWeightByTypeInRange(List<Animal> animals, int k, int l) {
        Map<Animal.Type, Integer> totalWeightByType = new HashMap<>();
        for (Animal animal : animals) {
            if (animal.age() >= k && animal.age() <= l) {
                totalWeightByType.put(animal.type(), totalWeightByType.getOrDefault(animal.type(), 0)
                    + animal.weight());
            }
        }
        return totalWeightByType;
    }
}

