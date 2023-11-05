package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task6;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Tests {

    @Test
    public void testFindHeaviestAnimalForEachTypeMultipleAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false));
        animals.add(new Animal("Elephant", Animal.Type.CAT, Animal.Sex.M, 3, 1500, 600, true));
        animals.add(new Animal("Giraffe", Animal.Type.CAT, Animal.Sex.F, 5, 2000, 800, false));

        Map<Animal.Type, Animal> heaviestAnimalMap = Task6.findHeaviestAnimalForEachType(animals);

        assertEquals(3, heaviestAnimalMap.size());
        assertEquals("Giraffe", heaviestAnimalMap.get(Animal.Type.CAT).name());
        assertEquals("Dog", heaviestAnimalMap.get(Animal.Type.DOG).name());
        assertEquals("Sparrow", heaviestAnimalMap.get(Animal.Type.BIRD).name());
    }

    @Test
    public void testFindHeaviestAnimalForEachTypeEmptyList() {
        List<Animal> animals = new ArrayList<>();

        Map<Animal.Type, Animal> heaviestAnimalMap = Task6.findHeaviestAnimalForEachType(animals);

        assertEquals(0, heaviestAnimalMap.size());
    }
}

