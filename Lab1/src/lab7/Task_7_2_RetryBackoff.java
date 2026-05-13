package lab7;

import io.reactivex.rxjava3.core.Observable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Task_7_2_RetryBackoff {
    public static void main(String[] args) {
        AtomicInteger attemptCount = new AtomicInteger(0);

        Observable<String> unstableApiCall = Observable.create(emitter -> {
            int attempt = attemptCount.incrementAndGet();
            System.out.println("[ПОВТОР] Спроба #" + attempt);
            if (attempt < 4) {
                emitter.onError(new IOException("Connection timeout"));
            } else {
                emitter.onNext("(+) Відповідь API: {status: 'ok', data: [...]}");
                emitter.onComplete();
            }
        });

        unstableApiCall

                .retryWhen(errors -> errors.zipWith(Observable.range(1, 5), (err, attempt) -> {
                    if (attempt == 5) throw err;
                    long delay = (long) Math.pow(2, attempt - 1);
                    System.out.println("Очікуємо " + delay + " сек перед повтором...");
                    return delay;
                }).flatMap(delay -> Observable.timer(delay, TimeUnit.SECONDS)))
                .blockingSubscribe(
                        System.out::println,
                        err -> System.out.println("Фінальна помилка: " + err.getMessage())
                );
    }
}
