package edu.hw4;

import java.util.List;

public class Task17 {

    private Task17() {

    }

    public static boolean doSpidersBiteMoreThanDogs(List<Animal> animals) {
        int spiderBites = 0;
        int dogBites = 0;

        for (Animal animal : animals) {
            if (animal.type() == Animal.Type.SPIDER) {
                spiderBites++;
            } else if (animal.type() == Animal.Type.DOG) {
                dogBites++;
            }
        }

        if (spiderBites == 0 && dogBites == 0) {
            return false;
        } else {
            return spiderBites > dogBites;
        }
    }
}

