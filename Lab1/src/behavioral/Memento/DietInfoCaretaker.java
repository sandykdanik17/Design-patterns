package behavioral.Memento;

public class DietInfoCaretaker {
    Object objMemento;
    public void saveState(DietInfo dietInfo) { objMemento = dietInfo.save(); }
    public void restoreState(DietInfo dietInfo) { dietInfo.restore(objMemento); }
}
