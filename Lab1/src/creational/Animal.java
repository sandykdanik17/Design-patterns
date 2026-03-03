package creational;

public abstract class Animal {
    public abstract String makeSound();
}

class Dog extends Animal {
    @Override public String makeSound() { return "Woof";}
}

class Cat extends Animal {
    @Override public String makeSound() {return "Meow";}
}

class Snake extends Animal {
    @Override
    public String makeSound() {
        return "Hiss";
    }
}

class Tyrannosaurus extends Animal {
    @Override
    public String makeSound() {
        return "Roar";
    }
}

class AnimalFactory {
    public Animal getAnimal(String type) {
        if ("canine".equals(type)) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}


