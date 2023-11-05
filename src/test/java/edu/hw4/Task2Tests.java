package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Tests {

    @Test
    public void testSortAndSelectTopKByWeight() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        List<Animal> selectedAnimals = Task2.sortAndSelectTopKByWeight(animals, 2);

        assertEquals(2, selectedAnimals.size());
        assertEquals("Dog", selectedAnimals.get(0).name());
        assertEquals("Cat", selectedAnimals.get(1).name());
    }
}
