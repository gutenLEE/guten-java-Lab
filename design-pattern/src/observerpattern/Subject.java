package observerpattern;

import java.util.List;

public interface Subject {

    void registerObserver(Observer ob);
    void removeObserver(Observer ob);
    void notifyObservers();
}
