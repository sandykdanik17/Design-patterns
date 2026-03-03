package creational;

public interface Prototype {
    public Prototype doClone();
}

class Person implements Prototype {
    String name;
    public Person(String name) { this.name = name;}

    @Override
    public Prototype doClone() {
        return new Person(name);
    }

    @Override
    public String toString() {
        return "This person is named " + name;
    }
}
