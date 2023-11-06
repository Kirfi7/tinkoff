package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task12;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task12Tests {

    @Test
    public void testCountAnimalsWeightGreaterThanHeight() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 40, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 35, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 15, false));

        int count = Task12.countAnimalsWeightGreaterThanHeight(animals);

        assertEquals(1, count);
    }

    @Test
    public void testCountAnimalsWeightGreaterThanHeightNoMatch() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 25, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 38, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 22, false));

        int count = Task12.countAnimalsWeightGreaterThanHeight(animals);

        assertEquals(1, count);
    }
}

