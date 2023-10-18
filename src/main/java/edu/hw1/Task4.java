package edu.hw1;

public class Task4 {

    private Task4() {
        // приватный конструктор
    }

    // Метод для перестановки символов в строке попарно
    public static String fixString(String str) {
        // Проверяем, если входная строка равна null или имеет нечетную длину, возвращаем "Invalid Input"
        if (str == null || str.length() % 2 != 0) {
            return "Invalid Input";
        }

        // Преобразуем строку в массив символов
        char[] charArray = str.toCharArray();
        // Проходим по массиву и меняем символы местами попарно
        for (int i = 0; i < charArray.length; i += 2) {
            char temp = charArray[i];
            charArray[i] = charArray[i + 1];
            charArray[i + 1] = temp;
        }

        // Возвращаем новую строку, собранную из измененного массива символов
        return new String(charArray);
    }
}
