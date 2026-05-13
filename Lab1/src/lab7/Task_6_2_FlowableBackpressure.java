package lab7;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Task_6_2_FlowableBackpressure {
    public static void main(String[] args) {
        System.out.println("Частина А (buffer)");
        Observable<String> events = Observable.just(
                "LOGIN:user1", "CLICK:btn_buy", "VIEW:product_42", "LOGIN:user2", "LOGOUT:user1",
                "CLICK:btn_cart", "VIEW:product_7", "LOGIN:user3", "CLICK:btn_pay", "LOGOUT:user2"
        );

        int[] batchNum = {1};
        events.buffer(5)
                .subscribe(batch -> System.out.println("[DB] Batch INSERT #" + (batchNum[0]++) + ": " + batch));
        System.out.println("(+) Збережено подій: 12\n");

        System.out.println("Частина В (Flowable + DROP)");
        int[] processed = {0};
        int[] dropped = {0};

        Flowable.range(1, 1000)
                .onBackpressureDrop(item -> dropped[0]++)
                .observeOn(Schedulers.io(), false, 1)
                .doOnNext(item -> {
                    Thread.sleep(10);
                    processed[0]++;
                })
                .blockingSubscribe();

        System.out.println("[ЗВІТ] Оброблено: ~" + processed[0]);
        System.out.println("[ЗВІТ] Відкинуто: ~" + dropped[0]);
        System.out.println("(!) Стратегія DROP: частину елементів втрачено");
    }
}
