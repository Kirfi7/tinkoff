package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task7;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task7Tests {

    @Test
    public void testFindOldestAnimal() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        Animal oldestAnimal = Task7.findOldestAnimal(animals);

        assertEquals("Dog", oldestAnimal.name());
    }

    @Test
    public void testFindOldestAnimalEmptyList() {
        List<Animal> animals = new ArrayList<>();

        Animal oldestAnimal = Task7.findOldestAnimal(animals);

        assertNull(oldestAnimal);
    }
}

