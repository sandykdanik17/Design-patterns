package lab7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;

public class Task_2_2_SportsResults {
    public static void main(String[] args) throws InterruptedException {
        String[] matches = {"Динамо 2:1 Шахтар", "Шахтар 3:0 Металіст", "Ворскла 1:1 Зоря", "Дніпро 2:0 Рух", "Колос 0:1 Минай"};

        System.out.println("Частина А (Холодний)");
        Observable<String> cold = Observable.fromArray(matches);
        cold.subscribe(res -> System.out.println("Підписник 1: " + res));
        cold.subscribe(res -> System.out.println("Підписник 2: " + res));

        System.out.println("\nЧастина В (Гарячий)");
        ConnectableObservable<String> hot = Observable.zip(
                Observable.fromArray(matches),
                Observable.interval(500, TimeUnit.MILLISECONDS), // Інтервал для емуляції часу
                (match, timer) -> match
        ).publish();

        hot.subscribe(res -> System.out.println("[ГЛЯДАЧ 1] Отримав: " + res));
        hot.connect(); // Початок трансляції

        Thread.sleep(1200);
        hot.subscribe(res -> System.out.println("[ГЛЯДАЧ 2] Отримав: " + res));

        Thread.sleep(3000);
    }
}
