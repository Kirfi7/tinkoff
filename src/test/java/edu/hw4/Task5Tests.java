package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task5;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task5Tests {

    @Test
    public void testCompareSexCountMoreMales() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false));

        Animal.Sex sexWithMoreAnimals = Task5.compareSexCount(animals);

        assertEquals(Animal.Sex.M, sexWithMoreAnimals);
    }

    @Test
    public void testCompareSexCountMoreFemales() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        Animal.Sex sexWithMoreAnimals = Task5.compareSexCount(animals);

        assertEquals(Animal.Sex.F, sexWithMoreAnimals);
    }

    @Test
    public void testCompareSexCountEqualCounts() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));

        Animal.Sex sexWithMoreAnimals = Task5.compareSexCount(animals);

        assertNull(sexWithMoreAnimals);
    }
}

