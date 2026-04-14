package behavioral;

import behavioral.TemplateMethod.*;
import behavioral.Mediator.*;
import behavioral.Chain.*;
import behavioral.Observer.*;
import behavioral.Strategy.*;
import behavioral.Command.*;
import behavioral.State.*;
import behavioral.Visitor.*;
import behavioral.Iterator.*;
import behavioral.Memento.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("1. Шаблонний метод (Template Method) ");
        Meal meal1 = new HamburgerMeal();
        meal1.doMeal();
        System.out.println();
        Meal meal2 = new TacoMeal();
        meal2.doMeal();

        System.out.println("\n2. Медіатор (Mediator) ");
        Mediator mediator = new Mediator();
        Buyer swedishBuyer = new SwedishBuyer(mediator);
        Buyer frenchBuyer = new FrenchBuyer(mediator);
        float sellingPriceInDollars = 10.0f;
        AmericanSeller americanSeller = new AmericanSeller(mediator, sellingPriceInDollars);
        DollarConverter dollarConverter = new DollarConverter(mediator);
        float swedishBidInKronor = 55.0f;
        while (!swedishBuyer.attemptToPurchase(swedishBidInKronor)) { swedishBidInKronor += 15.0f; }
        float frenchBidInEuros = 3.0f;
        while (!frenchBuyer.attemptToPurchase(frenchBidInEuros)) { frenchBidInEuros += 1.5f; }

        System.out.println("\n3. Ланцюжок відповідальностей (Chain) ");
        PlanetHandler mercuryHandler = new MercuryHandler();
        PlanetHandler venusHandler = new VenusHandler();
        PlanetHandler earthHandler = new EarthHandler();
        mercuryHandler.setSuccessor(venusHandler);
        venusHandler.setSuccessor(earthHandler);
        PlanetHandler chain = mercuryHandler;
        chain.handleRequest(PlanetEnum.VENUS);
        chain.handleRequest(PlanetEnum.MERCURY);
        chain.handleRequest(PlanetEnum.EARTH);
        chain.handleRequest(PlanetEnum.JUPITER);

        System.out.println("\n4. Спостерігач (Observer) ");
        WeatherStation weatherStation = new WeatherStation(33);
        WeatherCustomer1 wc1 = new WeatherCustomer1();
        WeatherCustomer2 wc2 = new WeatherCustomer2();
        weatherStation.addObserver(wc1);
        weatherStation.addObserver(wc2);
        weatherStation.setTemperature(34);
        weatherStation.removeObserver(wc1);
        weatherStation.setTemperature(35);

        System.out.println("\n5. Стратегія (Strategy) ");
        int temperatureInF = 60;
        Strategy skiStrategy = new SkiStrategy();
        Context context = new Context(temperatureInF, skiStrategy);
        System.out.println("Is the temperature (" + context.getTemperatureInF() + "F) good for skiing? " + context.getResult());
        Strategy hikeStrategy = new HikeStrategy();
        context.setStrategy(hikeStrategy);
        System.out.println("Is the temperature (" + context.getTemperatureInF() + "F) good for hiking? " + context.getResult());

        System.out.println("\n6. Команда (Command) ");
        Lunch lunch = new Lunch();
        Command lunchCommand = new LunchCommand(lunch);
        Dinner dinner = new Dinner();
        Command dinnerCommand = new DinnerCommand(dinner);
        MealInvoker mealInvoker = new MealInvoker(lunchCommand);
        mealInvoker.invoke();
        mealInvoker.setCommand(dinnerCommand);
        mealInvoker.invoke();

        System.out.println("\n7. Стан (State) ");
        Person person = new Person(new HappyState());
        System.out.println("Hello in happy state: " + person.sayHello());
        System.out.println("Goodbye in happy state: " + person.sayGoodbye());
        person.setEmotionalState(new SadState());
        System.out.println("Hello in sad state: " + person.sayHello());
        System.out.println("Goodbye in sad state: " + person.sayGoodbye());

        System.out.println("\n8. Відвідувач (Visitor) ");
        TwoElement two1 = new TwoElement(3, 3);
        TwoElement two2 = new TwoElement(2, 7);
        ThreeElement three1 = new ThreeElement(3, 4, 5);
        List<NumberElement> numberElements = new ArrayList<NumberElement>();
        numberElements.add(two1);
        numberElements.add(two2);
        numberElements.add(three1);
        System.out.println("Visiting element list with SumVisitor");
        NumberVisitor sumVisitor = new SumVisitor();
        sumVisitor.visit(numberElements);
        System.out.println("\nVisiting element list with TotalSumVisitor");
        TotalSumVisitor totalSumVisitor = new TotalSumVisitor();
        totalSumVisitor.visit(numberElements);
        System.out.println("Total sum: " + totalSumVisitor.getTotalSum());

        System.out.println("\n9. Ітератор (Iterator) ");
        Item i1 = new Item("spaghetti", 7.50f);
        Item i2 = new Item("hamburger", 6.00f);
        Item i3 = new Item("chicken sandwich", 6.50f);
        Menu menu = new Menu();
        menu.addItem(i1);
        menu.addItem(i2);
        menu.addItem(i3);
        System.out.println("Displaying Menu:");
        java.util.Iterator<Item> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println(item);
        }

        System.out.println("\n10. Мементо (Memento) ");
        DietInfoCaretaker dietInfoCaretaker = new DietInfoCaretaker();
        DietInfo dietInfo = new DietInfo("Fred", 1, 100);
        System.out.println(dietInfo);
        dietInfo.setDayNumberAndWeight(2, 99);
        System.out.println(dietInfo);
        System.out.println("Saving state.");
        dietInfoCaretaker.saveState(dietInfo);
        dietInfo.setDayNumberAndWeight(3, 98);
        System.out.println(dietInfo);
        System.out.println("Restoring saved state.");
        dietInfoCaretaker.restoreState(dietInfo);
        System.out.println(dietInfo);
    }
}