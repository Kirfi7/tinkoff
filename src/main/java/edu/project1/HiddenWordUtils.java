package edu.project1;

// Вспомогательный класс для работы с скрытым словом
public class HiddenWordUtils {

    // Закрытый конструктор, предотвращающий создание экземпляров этого класса
    private HiddenWordUtils() {
    }

    // Метод для проверки наличия символа в массиве символов
    public static boolean haveInCharArray(char[] userSequence, char input) {
        for (var i : userSequence) {
            if (input == i) {
                return true;
            }
        }
        return false;
    }

    // Метод для открытия букв в последовательности символов
    public static void openLettersInSequence(char[] sequence, String word, char letter) {
        for (var i = 0; i < sequence.length; i++) {
            if (word.charAt(i) == letter) {
                sequence[i] = letter;
            }
        }
    }
}

