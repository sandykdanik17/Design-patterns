package behavioral.Visitor;

public interface NumberElement {
    public void accept(NumberVisitor visitor);
}
