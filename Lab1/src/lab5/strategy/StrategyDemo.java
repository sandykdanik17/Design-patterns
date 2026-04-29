package lab5.strategy;

import java.util.function.Function;

public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("Функціональна стратегія");

        Function<Double, Double> normalPrice = price -> price;
        Function<Double, Double> halfPriceDiscount = price -> price * 0.5;
        Function<Double, Double> studentDiscount = price -> price * 0.8;

        System.out.println("Звичайна ціна (1000): " + calculate(1000, normalPrice));
        System.out.println("Ціна зі знижкою 50%: " + calculate(1000, halfPriceDiscount));
        System.out.println("Студентська знижка: " + calculate(1000, studentDiscount));
    }

    public static double calculate(double price, Function<Double, Double> strategy) {
        return strategy.apply(price);
    }
}
