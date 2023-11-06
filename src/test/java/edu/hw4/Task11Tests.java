package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task11;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task11Tests {

    @Test
    public void testFindAnimalsCanBiteWithHeightGreaterThan100() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 120, 4, true));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 150, 2, false));

        List<Animal> resultAnimals = Task11.findAnimalsCanBiteWithHeightGreaterThan100(animals);

        assertEquals(1, resultAnimals.size());
        assertEquals("Cat", resultAnimals.get(0).name());
    }

    @Test
    public void testFindAnimalsCanBiteWithHeightGreaterThan100NoMatch() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, true));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 50, 2, false));

        List<Animal> resultAnimals = Task11.findAnimalsCanBiteWithHeightGreaterThan100(animals);

        assertEquals(0, resultAnimals.size());
    }
}

