package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task4;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task4Tests {

    @Test
    public void testFindAnimalWithLongestName() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Elephant", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        Animal animalWithLongestName = Task4.findAnimalWithLongestName(animals);

        assertEquals("Elephant", animalWithLongestName.name());
    }

    @Test
    public void testFindAnimalWithLongestNameEmptyList() {
        List<Animal> animals = new ArrayList<>();

        Animal animalWithLongestName = Task4.findAnimalWithLongestName(animals);

        assertNull(animalWithLongestName);
    }
}

