package lab5.around;

import java.util.function.Consumer;

class Resourse {
    private Resourse() { System.out.println("Відкриття з'єднання з ресурсом..."); }
    public void operate() { System.out.println("Виконання операцій з даними..."); }
    private void close() { System.out.println("Безпечне закриття ресурсу."); }

    public static void use(Consumer<Resourse> block) {
        Resourse resourse = new Resourse();
        try {
            block.accept(resourse);
        } finally {
            resourse.close();
        }
    }
}

public class ExecuteAroundDemo {
    public static void main(String[] args) {
        System.out.println("Патерн Execute Around");

        Resourse.use(resourse -> {
            resourse.operate();
            System.out.println("Додаткова робота клієнта...");
        });
    }
}
