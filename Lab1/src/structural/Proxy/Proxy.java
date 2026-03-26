package structural.Proxy;

import java.util.Date;

public class Proxy {
    SlowThing slowThing;
    public Proxy() { System.out.println("Creating proxy at " + new Date()); }
    public void sayHello() {
        if (slowThing == null) { slowThing = new SlowThing(); }
        slowThing.sayHello();
    }
}
