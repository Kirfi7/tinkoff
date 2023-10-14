package edu.hw1;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SeventhTask {
    private static String listToString(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list) {
            builder.append(ch);
        }
        return builder.toString();
    }

    private static int rotate(int n, int shift) {
        var string = Integer.toBinaryString(n);
        var characters = string.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        Collections.rotate(characters, shift);
        var resultString = listToString(characters);
        return Integer.parseInt(resultString, 2);
    }

    public static int rotateLeft(int n, int shift) {
        return rotate(n, -shift);
    }

    public static int rotateRight(int n, int shift) {
        return rotate(n, shift);
    }

}


