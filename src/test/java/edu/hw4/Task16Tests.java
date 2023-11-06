package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task16;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task16Tests {

    @Test
    public void testSortAnimalsByTypeSexAndName() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cute Fluffy Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Big Fierce Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        List<Animal> sortedAnimals = Task16.sortAnimalsByTypeSexAndName(animals);

        assertEquals("Cute Fluffy Cat", sortedAnimals.get(0).name());
        assertEquals("Big Fierce Dog", sortedAnimals.get(1).name());
        assertEquals("Sparrow", sortedAnimals.get(2).name());
    }
}

