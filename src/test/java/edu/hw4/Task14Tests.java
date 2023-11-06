package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task14;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task14Tests {

    @Test
    public void testIsDogTallerThanK() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cute Fluffy Dog", Animal.Type.DOG, Animal.Sex.F, 2, 120, 40, false));
        animals.add(new Animal("Big Fierce Dog", Animal.Type.DOG, Animal.Sex.M, 4, 140, 80, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        assertTrue(Task14.isDogTallerThanK(animals, 100));
    }

    @Test
    public void testIsDogTallerThanKNoMatch() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cute Fluffy Dog", Animal.Type.DOG, Animal.Sex.F, 2, 80, 40, false));
        animals.add(new Animal("Big Fierce Dog", Animal.Type.DOG, Animal.Sex.M, 4, 90, 80, true));
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));

        assertFalse(Task14.isDogTallerThanK(animals, 100));
    }
}

