package lab7;

import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task_1_2_CityFilter {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Київ", "Харків", "Одеса", "Дніпро", "Запоріжжя",
                "Кривий Ріг", "Миколаїв", "Херсон", "Кропивницький",
                "Черкаси", "Суми", "Хмельницький", "Чернівці", "Каховка"
        );

        System.out.println("1. Імперативний");
        List<String> resultImp = new ArrayList<>();
        for (String city : cities) {
            if (city.startsWith("К")) {
                resultImp.add(city.toUpperCase());
            }
        }
        Collections.sort(resultImp);
        for (String c : resultImp) System.out.println(c);

        System.out.println("\n2. Функціональний");
        cities.stream()
                .filter(c -> c.startsWith("К"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n3. Реактивний");
        Observable.fromIterable(cities)
                .filter(c -> c.startsWith("К"))
                .map(String::toUpperCase)
                .sorted()
                .subscribe(System.out::println);
    }
}
