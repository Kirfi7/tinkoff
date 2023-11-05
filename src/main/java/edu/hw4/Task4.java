package edu.hw4;

import java.util.List;

public class Task4 {

    private Task4() {

    }

    public static Animal findAnimalWithLongestName(List<Animal> animals) {
        if (animals.isEmpty()) {
            return null;
        }
        Animal longestNameAnimal = animals.get(0);
        for (Animal animal : animals) {
            if (animal.name().length() > longestNameAnimal.name().length()) {
                longestNameAnimal = animal;
            }
        }
        return longestNameAnimal;
    }
}

