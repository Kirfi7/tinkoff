package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task15;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task15Tests {

    @Test
    public void testCalculateTotalWeightByTypeInRange() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cute Fluffy Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Big Fierce Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        Map<Animal.Type, Integer> expectedResult = new HashMap<>();
        expectedResult.put(Animal.Type.CAT, 4);
        expectedResult.put(Animal.Type.DOG, 8);
        expectedResult.put(Animal.Type.BIRD, 2);

        Map<Animal.Type, Integer> result = Task15.calculateTotalWeightByTypeInRange(animals, 1, 4);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testCalculateTotalWeightByTypeInRangeNoMatch() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cute Fluffy Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Big Fierce Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        Map<Animal.Type, Integer> expectedResult = new HashMap<>();

        Map<Animal.Type, Integer> result = Task15.calculateTotalWeightByTypeInRange(animals, 5, 6);

        assertEquals(expectedResult, result);
    }
}

