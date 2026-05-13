package lab7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Task_5_1_AsyncImages {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> images = Observable.just("photo_1.jpg", "photo_2.jpg", "photo_3.jpg");

        images
                .subscribeOn(Schedulers.io())
                .doOnNext(img -> {
                    Thread.sleep(1000);
                    System.out.println("[" + Thread.currentThread().getName() + "] [ЗАВАНТ] Завантаження: " + img);
                })
                .observeOn(Schedulers.computation())
                .doOnNext(img -> {
                    Thread.sleep(500);
                    System.out.println("[" + Thread.currentThread().getName() + "] [СТИСК] Стиснення: " + img);
                })
                .observeOn(Schedulers.trampoline())
                .subscribe(img ->
                        System.out.println("[" + Thread.currentThread().getName() + "] [ФОТО] Відображення: " + img)
                );

        Thread.sleep(5000);
    }
}
