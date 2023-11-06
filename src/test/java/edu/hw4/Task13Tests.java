package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task13;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task13Tests {

    @Test
    public void testFindAnimalsWithNamesLongerThanTwoWords() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cute Fluffy Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Big Fierce Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        List<Animal> resultAnimals = Task13.findAnimalsWithNamesLongerThanTwoWords(animals);

        assertEquals(2, resultAnimals.size());
        assertEquals("Cute Fluffy Cat", resultAnimals.get(0).name());
        assertEquals("Big Fierce Dog", resultAnimals.get(1).name());
    }

    @Test
    public void testFindAnimalsWithNamesLongerThanTwoWordsNoMatch() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        List<Animal> resultAnimals = Task13.findAnimalsWithNamesLongerThanTwoWords(animals);

        assertEquals(0, resultAnimals.size());
    }
}

