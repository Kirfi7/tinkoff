package edu.project1;

public class IllegalWordException extends RuntimeException {
    public IllegalWordException(String word) {
        super(word + "can't be guessed");
    }
}
