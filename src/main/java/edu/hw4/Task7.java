package edu.hw4;

import java.util.List;

public class Task7 {

    private Task7() {

    }

    public static Animal findOldestAnimal(List<Animal> animals) {
        if (animals.isEmpty()) {
            return null;
        }
        Animal oldestAnimal = animals.get(0);
        for (Animal animal : animals) {
            if (animal.age() > oldestAnimal.age()) {
                oldestAnimal = animal;
            }
        }
        return oldestAnimal;
    }
}

