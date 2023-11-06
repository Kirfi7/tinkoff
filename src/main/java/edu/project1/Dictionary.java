package edu.project1;

import java.util.Random;

public class Dictionary {
    private static final String[] WORDS = {
        "blue", "word", "keyboard", "gravity", "road", "math", "tetris"
    };

    private Dictionary() {
    }

    public static String getWord() {
        Random random = new Random();
        int index = random.nextInt(WORDS.length);

        return WORDS[index];
    }
}
