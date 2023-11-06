package edu.project1;

public class HiddenWordUtils {
    private HiddenWordUtils() {
    }

    public static boolean haveInCharArray(char[] userSequence, char input) {
        for (var i : userSequence) {
            if (input == i) {
                return true;
            }
        }
        return false;
    }

    public static void openLettersInSequence(char[] sequence, String word, char letter) {
        for (var i = 0; i < sequence.length; i++) {
            if (word.charAt(i) == letter) {
                sequence[i] = letter;
            }
        }
    }
}
