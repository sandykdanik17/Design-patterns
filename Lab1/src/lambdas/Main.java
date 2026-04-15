package lambdas;

import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5, 4.5);
        List<String> stringList = Arrays.asList("Banana", "Apple", "cherry", "Date", "Elephant", "");
        String sentence = "Тестове речення для підрахунку слів";

        System.out.println("1. Непарні числа: " + filterOddNumbers(intList));

        System.out.println("2. Середнє значення: " + findAverage(doubleList));

        System.out.println("3. Сортування за алфавітом: " + sortAlphabetically(stringList));

        System.out.println("4. Сума парних чисел: " + sumOfEvens(intList));

        int numForFactorial = 5;
        System.out.println("5. Факторіал числа " + numForFactorial + ": " + calculateFactorial(numForFactorial));

        System.out.println("6. Сума всіх елементів: " + sumAll(intList) + ", Добуток всіх елементів: " + multiplyAll(intList));

        System.out.println("7. Квадрати чисел: " + squareNumbers(intList));

        System.out.println("8. Сортування за довжиною: " + sortByLength(stringList));

        System.out.println("9. Кількість слів у реченні: " + countWords(sentence));

        System.out.println("10. Перший непорожній рядок: " + findFirstNonEmpty(stringList));

        System.out.println("11. Чи всі з великої літери: " + allStartWithCapital(Arrays.asList("Apple", "Banana")));

        System.out.println("12. Друге за величиною число: " + findSecondLargest(intList));

        System.out.println("13. Найбільше парне число: " + findLargestEven(intList));
    }


    public static List<Integer> filterOddNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
    }

    public static double findAverage(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public static List<String> sortAlphabetically(List<String> strings) {
        return strings.stream().sorted().collect(Collectors.toList());
    }

    public static int sumOfEvens(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static long calculateFactorial(int n) {
        return LongStream.rangeClosed(1, n).reduce(1, (long a, long b) -> a * b);
    }

    public static int sumAll(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
    public static int multiplyAll(List<Integer> numbers) {
        return numbers.stream().reduce(1, (a, b) -> a * b);
    }

    public static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream().map(n -> n * n).collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static long countWords(String sentence) {
        return Arrays.stream(sentence.trim().split("\\s+")).filter(word -> !word.isEmpty()).count();
    }

    public static String findFirstNonEmpty(List<String> strings) {
        return strings.stream().filter(s -> s != null && !s.isEmpty()).findFirst().orElse("Не знайдено");
    }

    public static boolean allStartWithCapital(List<String> strings) {
        return strings.stream().allMatch(s -> s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0)));
    }

    public static Integer findSecondLargest(List<Integer> numbers) {
        return numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
    }

    public static Integer findLargestEven(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).max(Integer::compareTo).orElse(null);
    }
}