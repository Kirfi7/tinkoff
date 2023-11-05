package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task20 {

    private Task20() {

    }

    public static Map<String, String> findErrorsInAnimalRecordsReadable(List<Animal> animals) {
        Map<String, String> errorsMap = new HashMap<>();

        for (Animal animal : animals) {
            List<String> errors = new ArrayList<>();
            if (animal.name() == null || animal.name().isEmpty()) {
                errors.add("Empty name");
            }
            if (animal.age() < 0) {
                errors.add("Invalid age");
            }
            if (!errors.isEmpty()) {
                errorsMap.put(animal.name(), String.join(", ", errors));
            }
        }
        return errorsMap;
    }
}

