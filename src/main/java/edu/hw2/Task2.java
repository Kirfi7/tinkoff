package edu.hw2;

public class Task2 {
    interface Shape {
        void setWidth(int width);

        void setHeight(int height);

        double area();
    }

    class Rectangle implements Shape {
        private int width;
        private int height;

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public double area() {
            return width * height;
        }
    }

    class Square implements Shape {
        private int side;

        public void setWidth(int width) {
            this.side = width;
        }

        public void setHeight(int height) {
            this.side = height;
        }

        public int getWidth() {
            return side;
        }

        public int getHeight() {
            return side;
        }

        public double area() {
            return side * side;
        }
    }

}
