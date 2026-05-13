package lab7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_5_2_Microservices {
    record ServiceCall(String serviceName, int delayMs) {}

    public static void main(String[] args) {
        List<ServiceCall> services = Arrays.asList(
                new ServiceCall("UserService", 800),
                new ServiceCall("OrderService", 1200),
                new ServiceCall("RecommendationService", 600)
        );

        System.out.println("Послідовно (concatMap)");
        long start1 = System.currentTimeMillis();
        Observable.fromIterable(services)
                .concatMap(s -> Observable.just(s.serviceName() + " відповів за " + s.delayMs() + " мс")
                        .delay(s.delayMs(), TimeUnit.MILLISECONDS))
                .blockingSubscribe(res -> System.out.println("(+) " + res));
        System.out.println("Загальний час (послідовно): ~" + (System.currentTimeMillis() - start1) + " мс\n");

        System.out.println("Паралельно (flatMap + Schedulers.io)");
        long start2 = System.currentTimeMillis();
        Observable.fromIterable(services)
                .flatMap(s -> Observable.just(s.serviceName() + " відповів за " + s.delayMs() + " мс")
                        .delay(s.delayMs(), TimeUnit.MILLISECONDS, Schedulers.io()))
                .blockingSubscribe(res -> System.out.println("[" + Thread.currentThread().getName() + "] (+) " + res));
        System.out.println("Загальний час (паралельно): ~" + (System.currentTimeMillis() - start2) + " мс");
    }
}
