package lab7;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class Task_4_2_MaybeCompletable {
    public static Maybe<String> findInCache(String key) {
        if (key.equals("user:1")) return Maybe.just("{'name': 'Леся', 'age':28}");
        if (key.equals("user:2")) return Maybe.empty();
        return Maybe.error(new RuntimeException("Redis недоступний"));
    }

    public static void main(String[] args) {
        System.out.println("Частина А (Maybe)");
        String[] keys = {"user:1", "user:2", "user:error"};
        for (String key : keys) {
            findInCache(key)
                    .defaultIfEmpty("Завантажено з БД")
                    .subscribe(
                            res -> System.out.println("[КЕШ] " + (key.equals("user:error") ? "Значення: " : "Знайдено: ") + res),
                            err -> System.out.println("[КЕШ (!)] Помилка: " + err.getMessage())
                    );
        }

        System.out.println("\nЧастина В (Completable)");
        Completable validate = Completable.fromAction(() -> System.out.println("[ПОШУК] Перевірка даних...\n(+) Дані валідні"));
        Completable save = Completable.fromAction(() -> System.out.println("[DB] Збереження в БД...\n(+) Збережено"));
        Single<String> token = Single.just("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.demo");

        validate.andThen(save).andThen(token)
                .subscribe(
                        res -> {
                            System.out.println("[ТОКЕН] Токен: " + res);
                            System.out.println("(+) Реєстрацію завершено успішно!");
                        },
                        err -> System.out.println("Помилка: " + err.getMessage())
                );
    }
}
