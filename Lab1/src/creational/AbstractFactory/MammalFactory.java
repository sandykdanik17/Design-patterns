package creational.AbstractFactory;

import creational.Factory.Animal;
import creational.Factory.Cat;
import creational.Factory.Dog;

public class MammalFactory extends SpeciesFactory {
    @Override public Animal getAnimal(String type) {
        if ("dog".equals(type)) return new Dog();
        else return new Cat();
    }
}
