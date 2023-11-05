package edu.hw4;

import edu.hw4.Animal;
import edu.hw4.Task17;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task17Tests {

    @Test
    public void testDoSpidersBiteMoreThanDogs() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Black Widow", Animal.Type.SPIDER, Animal.Sex.F, 1, 5, 2, true));
        animals.add(new Animal("Big Fierce Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Garden Spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 3, 1, true));
        animals.add(new Animal("Labrador", Animal.Type.DOG, Animal.Sex.M, 2, 50, 10, true));

        assertFalse(Task17.doSpidersBiteMoreThanDogs(animals));
    }

    @Test
    public void testDoSpidersBiteMoreThanDogsNoMatch() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Sparrow", Animal.Type.BIRD, Animal.Sex.F, 1, 20, 2, false));
        animals.add(new Animal("Labrador", Animal.Type.DOG, Animal.Sex.M, 2, 50, 10, false));

        assertFalse(Task17.doSpidersBiteMoreThanDogs(animals));
    }

    @Test
    void testDoSpidersBiteMoreThanDogs_NoData() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Black Widow", Animal.Type.SPIDER, Animal.Sex.F, 1, 5, 2, true));
        animals.add(new Animal("Big Fierce Dog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true));
        animals.add(new Animal("Garden Spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 3, 1, true));
        animals.add(new Animal("Labrador", Animal.Type.DOG, Animal.Sex.M, 2, 50, 10, false));

        assertFalse(Task17.doSpidersBiteMoreThanDogs(animals));
    }
}
