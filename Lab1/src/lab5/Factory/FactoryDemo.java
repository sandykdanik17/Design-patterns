package lab5.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

interface Shape { void draw(); }
class Circle implements Shape { public void draw() { System.out.println("Малюємо коло"); } }
class Square implements Shape { public void draw() { System.out.println("Малюємо квадрат"); } }

public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("Функціональний Фабричний метод");

        Map<String, Supplier<Shape>> shapeFactory = new HashMap<>();
        shapeFactory.put("circle", Circle::new);
        shapeFactory.put("square", Square::new);

        Shape myCircle = shapeFactory.get("circle").get();
        Shape mySquare = shapeFactory.get("square").get();

        myCircle.draw();
        mySquare.draw();
    }
}
