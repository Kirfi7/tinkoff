package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task19;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task19Tests {

    @Test
    public void testFindErrorsInAnimalRecords() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("", Animal.Type.DOG, Animal.Sex.M, -1, 0, 0, false));
        animals.add(new Animal("Kitty", Animal.Type.CAT, Animal.Sex.F, -1, 30, 4, false));
        animals.add(new Animal("Tom", Animal.Type.CAT, Animal.Sex.M, 3, 35, 5, false));
        animals.add(new Animal("", Animal.Type.BIRD, Animal.Sex.F, -2, 0, 0, false));

        Map<String, Set<Animal.ValidationError>> result = Task19.findErrorsInAnimalRecords(animals);

        assertEquals(2, result.size());
        assertTrue(result.containsKey(""));
        assertTrue(result.containsKey("Kitty"));

        Set<Animal.ValidationError> emptyErrors = new HashSet<>();
        emptyErrors.add(Animal.ValidationError.EMPTY_NAME);
        emptyErrors.add(Animal.ValidationError.INVALID_AGE);

        Set<Animal.ValidationError> ageErrors = new HashSet<>();
        ageErrors.add(Animal.ValidationError.INVALID_AGE);

        assertEquals(emptyErrors, result.get(""));
        assertEquals(ageErrors, result.get("Kitty"));
    }




    @Test
    public void testFindErrorsInAnimalRecordsNoErrors() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Max", Animal.Type.DOG, Animal.Sex.M, 5, 50, 8, true));
        animals.add(new Animal("Lucy", Animal.Type.DOG, Animal.Sex.F, 3, 30, 6, true));

        Map<String, Set<Animal.ValidationError>> result = Task19.findErrorsInAnimalRecords(animals);

        assertEquals(0, result.size());
    }
}

