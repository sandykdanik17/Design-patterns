package lab7;

import io.reactivex.rxjava3.core.Observable;

public class Task_7_1_ErrorHandling {
    public static void main(String[] args) {
        Observable<String> currencyService = Observable.create(emitter -> {
            emitter.onNext("USD -> UAH: 41.50");
            emitter.onNext("EUR -> UAH: 44.20");
            emitter.onError(new RuntimeException("Сервіс тимчасово недоступний"));
            emitter.onNext("GBP -> UAH: 52.10");
        });

        System.out.println("Сценарій А (onErrorReturn)");
        currencyService
                .onErrorReturnItem("Використовується кешований курс: USD -> UAH: 41.00")
                .subscribe(System.out::println);

        System.out.println("\nСценарій В (onErrorResumeNext)");
        currencyService
                .onErrorResumeNext(err -> Observable.just("JPY -> UAH: 0.27", "PLN -> UAH: 10.30"))
                .subscribe(System.out::println);
    }
}