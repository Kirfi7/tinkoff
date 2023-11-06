package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task20Tests {

    @Test
    void testFindErrorsInAnimalRecordsReadable() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("", Animal.Type.DOG, Animal.Sex.M, -1, 0, 0, false));
        animals.add(new Animal("Kitty", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Tom", Animal.Type.CAT, Animal.Sex.M, 3, 35, 5, false));
        animals.add(new Animal("", Animal.Type.BIRD, Animal.Sex.F, -2, 0, 0, false));

        Map<String, String> result = Task20.findErrorsInAnimalRecordsReadable(animals);

        assertEquals(1, result.size());
        assertEquals("Empty name, Invalid age", result.get(""));
        assertEquals(null, result.get("Kitty"));
    }
}

