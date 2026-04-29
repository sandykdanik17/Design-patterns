package lab5.decorator;

import java.util.function.Function;

public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("Функціональний декоратор");

        Function<String, String> baseText = text -> text;
        Function<String, String> upperCaseDecorator = String::toUpperCase;
        Function<String, String> htmlBoldDecorator = text -> "<b" + text + "</b";

        Function<String, String> decoratedText = baseText
                .andThen(upperCaseDecorator)
                .andThen(htmlBoldDecorator);

        System.out.println("Оригінал: design patterns");
        System.out.println("Декоровано: " + decoratedText.apply("design patterns"));
    }
}
