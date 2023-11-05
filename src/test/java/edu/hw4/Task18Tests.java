package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task18;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task18Tests {

    @Test
    public void testFindHeaviestFish() {
        List<List<Animal>> animalLists = new ArrayList<>();
        List<Animal> list1 = new ArrayList<>();
        list1.add(new Animal("Goldfish", Animal.Type.FISH, Animal.Sex.F, 1, 5, 1, false));
        list1.add(new Animal("Carp", Animal.Type.FISH, Animal.Sex.M, 2, 7, 3, false));

        List<Animal> list2 = new ArrayList<>();
        list2.add(new Animal("Salmon", Animal.Type.FISH, Animal.Sex.M, 3, 10, 5, false));
        list2.add(new Animal("Tuna", Animal.Type.FISH, Animal.Sex.F, 4, 12, 8, false));

        animalLists.add(list1);
        animalLists.add(list2);

        Animal result = Task18.findHeaviestFish(animalLists);

        assertEquals("Tuna", result.name());
    }

    @Test
    public void testFindHeaviestFishEmpty() {
        List<List<Animal>> animalLists = new ArrayList<>();

        Animal result = Task18.findHeaviestFish(animalLists);

        assertEquals(null, result);
    }
}

