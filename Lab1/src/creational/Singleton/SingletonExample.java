package creational.Singleton;

public class SingletonExample {
    private static SingletonExample singleExample = null;
    private SingletonExample() {}
    public static SingletonExample getInstance() {
        if (singleExample == null) {
            singleExample = new SingletonExample();
        }
        return singleExample;
    }
 public void sayHello() {
        System.out.println("Hello");
 }
}