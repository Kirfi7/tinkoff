package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task1;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Tests {

    @Test
    public void testSortAnimalsByHeight() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        List<Animal> sortedAnimals = Task1.sortAnimalsByHeight(animals);

        assertEquals("Bird", sortedAnimals.get(0).name());
        assertEquals("Cat", sortedAnimals.get(1).name());
        assertEquals("Dog", sortedAnimals.get(2).name());
    }
}

