package structural;

import structural.Adapter.*;
import structural.Composite.*;
import structural.Proxy.*;
import structural.Flyweight.*;
import structural.Facade.*;
import structural.Bridge.*;
import structural.Decorator.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("1. Адаптер (Adapter)");
        System.out.println("class adapter test");
        TemperatureInfo tempInfo = new TemperatureClassReporter();
        testTempInfo(tempInfo);
        System.out.println("object adapter test");
        tempInfo = new TemperatureObjectReporter();
        testTempInfo(tempInfo);

        System.out.println("\n2. Композит (Composite)");
        Leaf leaf1 = new Leaf("Bob");
        Composite composite1 = new Composite();
        composite1.add(leaf1);
        System.out.println("Calling 'sayHello' on composite1");
        composite1.sayHello();

        System.out.println("\n3. Проксі (Proxy)");
        Proxy proxy = new Proxy();
        FastThing fastThing = new FastThing();
        fastThing.sayHello();
        proxy.sayHello();

        System.out.println("\n4. Легковик (Flyweight)");
        FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();
        for (int i = 0; i < 2; i++) {
            Flyweight flyweightAdder = flyweightFactory.getFlyweight("add");
            flyweightAdder.doMath(i, i);
        }

        System.out.println("\n5. Фасад (Facade)");
        Facade facade = new Facade();
        int x = 3;
        System.out.println("Cube of " + x + ":" + facade.cubeX(x));

        System.out.println("\n6. Міст (Bridge)");
        Vehicle vehicle = new BigBus(new SmallEngine());
        vehicle.drive();
        vehicle.setEngine(new BigEngine());
        vehicle.drive();

        System.out.println("\n7. Декоратор (Decorator)");
        structural.Decorator.Animal animal = new LivingAnimal();
        animal = new LegDecorator(animal);
        animal = new WingDecorator(animal);
        animal = new GrowlDecorator(animal);
        animal.describe();
    }

    public static void testTempInfo(TemperatureInfo tempInfo) {
        tempInfo.setTemperatureInC(0);
        System.out.println("temp in C:" + tempInfo.getTemperatureInC());
        System.out.println("temp in F:" + tempInfo.getTemperatureInF());
        tempInfo.setTemperatureInF(85);
        System.out.println("temp in C:" + tempInfo.getTemperatureInC());
        System.out.println("temp in F:" + tempInfo.getTemperatureInF());
    }
}