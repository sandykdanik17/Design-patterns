package creational;

import creational.Singleton.SingletonExample;
import creational.Factory.Animal;
import creational.Factory.AnimalFactory;
import creational.AbstractFactory.AbstractFactory;
import creational.AbstractFactory.SpeciesFactory;
import creational.Builder.Meal;
import creational.Builder.MealBuilder;
import creational.Builder.ItalianMealBuilder;
import creational.Builder.JapaneseMealBuilder;
import creational.Builder.MealDirector;
import creational.Prototype.Person;

public class Main {
    public static void main(String[] args) {

        System.out.println("1. Одинак (Singleton)");
        SingletonExample singletonExample = SingletonExample.getInstance();
        singletonExample.sayHello();

        System.out.println("\n2. Фабрика (Factory)");
        AnimalFactory animalFactory = new AnimalFactory();
        Animal a1 = animalFactory.getAnimal("feline");
        System.out.println("a1 sound: " + a1.makeSound());
        Animal a2 = animalFactory.getAnimal("canine");
        System.out.println("a2 sound: " + a2.makeSound());

        System.out.println("\n3. Абстрактна фабрика (Abstract Factory)");
        AbstractFactory abstractFactory = new AbstractFactory();
        SpeciesFactory speciesFactory = abstractFactory.getSpeciesFactory("mammal");
        Animal a3 = speciesFactory.getAnimal("dog");
        System.out.println("a3 sound: " + a3.makeSound());
        Animal a4 = speciesFactory.getAnimal("cat");
        System.out.println("a4 sound: " + a4.makeSound());

        System.out.println("\n4. Будівельник (Builder)");

        MealBuilder mealBuilder = new ItalianMealBuilder();
        MealDirector mealDirector = new MealDirector(mealBuilder);
        mealDirector.constructMeal();
        Meal meal = mealDirector.getMeal();
        System.out.println("Italian meal is: " + meal);


        mealBuilder = new JapaneseMealBuilder();
        mealDirector = new MealDirector(mealBuilder);
        mealDirector.constructMeal();
        meal = mealDirector.getMeal();
        System.out.println("Japanese meal is: " + meal);

        System.out.println("\n5. Прототип (Prototype)");
        Person person1 = new Person("Fred");
        System.out.println("person 1: " + person1);
        Person person2 = (Person) person1.doClone();
        System.out.println("person 2: " + person2);
    }
}