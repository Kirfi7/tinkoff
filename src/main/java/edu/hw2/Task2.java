package edu.hw2;

public class Task2 {
    // Интерфейс "Фигура"
    interface Shape {

        void setWidth(int width); // Установить ширину

        void setHeight(int height); // Установить высоту

        double area(); // Вычислить площадь
    }

    // Класс "Прямоугольник", реализующий интерфейс "Фигура"
    class Rectangle implements Shape {
        private int width; // Ширина
        private int height; // Высота

        public void setWidth(int width) { // Установить ширину
            this.width = width;
        }

        public void setHeight(int height) { // Установить высоту
            this.height = height;
        }

        public int getWidth() { // Получить ширину
            return width;
        }

        public int getHeight() { // Получить высоту
            return height;
        }

        public double area() { // Вычислить площадь
            return width * height;
        }
    }

    // Класс "Квадрат", реализующий интерфейс "Фигура"
    class Square implements Shape {
        private int side; // Сторона

        public void setWidth(int width) { // Установить ширину
            this.side = width;
        }

        public void setHeight(int height) { // Установить высоту
            this.side = height;
        }

        public int getWidth() { // Получить ширину
            return side;
        }

        public int getHeight() { // Получить высоту
            return side;
        }

        public double area() { // Вычислить площадь
            return side * side;
        }
    }
}
