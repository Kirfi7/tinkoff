package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task9;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task9Tests {

    @Test
    public void testCountTotalPaws() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 4, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));
        animals.add(new Animal("Shark", Animal.Type.FISH, Animal.Sex.F, 1, 20, 2, true));
        animals.add(new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 20, 2, true));

        int totalPaws = Task9.countTotalPaws(animals);

        assertEquals(18, totalPaws);
    }

    @Test
    public void testCountTotalPawsEmptyList() {
        List<Animal> animals = new ArrayList<>();

        int totalPaws = Task9.countTotalPaws(animals);

        assertEquals(0, totalPaws);
    }
}

