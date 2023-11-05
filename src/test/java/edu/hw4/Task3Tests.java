package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Tests {

    @Test
    public void testCountAnimalsByType() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));
        animals.add(new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 3, 35, 5, true));

        Map<Animal.Type, Integer> animalCountMap = Task3.countAnimalsByType(animals);

        assertEquals(2, animalCountMap.get(Animal.Type.CAT));
        assertEquals(1, animalCountMap.get(Animal.Type.DOG));
        assertEquals(1, animalCountMap.get(Animal.Type.BIRD));
        assertEquals(null, animalCountMap.get(Animal.Type.FISH));
    }
}

