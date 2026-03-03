package creational;

public abstract class SpeciesFactory {
    public abstract Animal getAnimal(String type);
}

class MammalFactory extends SpeciesFactory {
    @Override public Animal getAnimal(String type) {
        if ("dog".equals(type)) return new Dog();
        else return new Cat();
    }
}

class ReptileFactory extends SpeciesFactory {
    @Override
    public Animal getAnimal(String type) {
        if ("snake".equals(type)) {
            return new Snake();
        } else {
            return new Tyrannosaurus();
        }
    }
}

class AbstractFactory {
    public SpeciesFactory getSpeciesFactory(String type) {
        if ("mammal".equals(type)) return new MammalFactory();
        else return new ReptileFactory();
    }
}