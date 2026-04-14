package behavioral.State;

public class SadState implements EmotionalState {
    @Override public String sayGoodbye() { return "Bye. Sniff, sniff."; }
    @Override public String sayHello() { return "Hello. Sniff, sniff."; }
}
