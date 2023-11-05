package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task10;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task10Tests {

    @Test
    public void testFindAnimalsWithAgeNotMatchingPaws() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 4, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 4, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 2, 2, false));

        List<Animal> resultAnimals = Task10.findAnimalsWithAgeNotMatchingPaws(animals);

        assertEquals(2, resultAnimals.size());
        assertEquals("Cat", resultAnimals.get(0).name());
        assertEquals("Sparrow", resultAnimals.get(1).name());
    }

    @Test
    public void testFindAnimalsWithAgeNotMatchingPawsEmptyList() {
        List<Animal> animals = new ArrayList<>();

        List<Animal> resultAnimals = Task10.findAnimalsWithAgeNotMatchingPaws(animals);

        assertEquals(0, resultAnimals.size());
    }
}

