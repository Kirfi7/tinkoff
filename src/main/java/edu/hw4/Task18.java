package edu.hw4;

import java.util.List;

public class Task18 {

    private Task18() {

    }

    public static Animal findHeaviestFish(List<List<Animal>> animalLists) {
        Animal heaviestFish = null;
        for (List<Animal> animals : animalLists) {
            for (Animal animal : animals) {
                if (animal.type() == Animal.Type.FISH) {
                    if (heaviestFish == null || animal.weight() > heaviestFish.weight()) {
                        heaviestFish = animal;
                    }
                }
            }
        }
        return heaviestFish;
    }
}

