package creational.AbstractFactory;

import creational.Factory.Animal;
import creational.Factory.*;

public abstract class SpeciesFactory {
    public abstract Animal getAnimal(String type);
}

