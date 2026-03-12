package creational.AbstractFactory;

import creational.Factory.Animal;
import creational.Factory.Snake;
import creational.Factory.Tyrannosaurus;

public class ReptileFactory extends SpeciesFactory {
    @Override
    public Animal getAnimal(String type) {
        if ("snake".equals(type)) {
            return new Snake();
        } else {
            return new Tyrannosaurus();
        }
    }
}
