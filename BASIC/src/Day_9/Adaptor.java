package Day_9;

public class Adaptor {
    public static void main(String[] args) {
        Square square = new Square(10);
        CalculatorAdapter adapter = new CalculatorAdapter();
        int area = adapter.calculateArea(square);
        System.out.println("Area = " + area);
    }
}

class Rectangle {
    public int width;
    public int height;
    public Rectangle(int _width, int _height) {
        width = _width;
        height = _height;
    }
}

class Square {
    public int size;
    public Square(int _size) {
        size = _size;
    }
}

class Calculator {
    public int calculateArea(Rectangle _rectangle) {
        return _rectangle.width * _rectangle.height;
    }
}

class CalculatorAdapter {
    public int calculateArea(Square _square) {
        Calculator calculator = new Calculator();
        Rectangle rectangle = new Rectangle(_square.size, _square.size);
        return calculator.calculateArea(rectangle);
    }
}