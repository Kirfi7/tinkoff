package edu.hw4;

import java.util.List;

public class Task9 {

    private Task9() {

    }

    public static int countTotalPaws(List<Animal> animals) {
        int totalPaws = 0;
        for (Animal animal : animals) {
            totalPaws += animal.paws();
        }
        return totalPaws;
    }
}

