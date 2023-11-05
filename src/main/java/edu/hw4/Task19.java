package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task19 {

    private Task19() {

    }

    public static Map<String, Set<Animal.ValidationError>> findErrorsInAnimalRecords(List<Animal> animals) {
        Map<String, Set<Animal.ValidationError>> errorsMap = new HashMap<>();

        for (Animal animal : animals) {
            Set<Animal.ValidationError> errors = new HashSet<>();
            if (animal.name() == null || animal.name().isEmpty()) {
                errors.add(Animal.ValidationError.EMPTY_NAME);
            }
            if (animal.age() < 0) {
                errors.add(Animal.ValidationError.INVALID_AGE);
            }
            if (!errors.isEmpty()) {
                errorsMap.put(animal.name(), errors);
            }
        }
        return errorsMap;
    }
}



