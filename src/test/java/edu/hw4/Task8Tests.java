package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task8;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Task8Tests {

    @Test
    public void testFindHeaviestAnimalBelowHeight() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        Optional<Animal> heaviestAnimal = Task8.findHeaviestAnimalBelowHeight(animals, 35);

        assertEquals("Cat", heaviestAnimal.get().name());
    }

    @Test
    public void testFindHeaviestAnimalBelowHeightNoMatch() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        Optional<Animal> heaviestAnimal = Task8.findHeaviestAnimalBelowHeight(animals, 10);

        assertFalse(heaviestAnimal.isPresent());
    }
}

