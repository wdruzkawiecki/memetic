package projektEvolution.notify;

import java.util.ArrayList;
import java.util.List;

public class Notifier<T extends ISubject> {
    private List<Observer<T>> observers = new ArrayList<Observer<T>>();

    public void attach(Observer<T> observer){
        if(!observers.contains(observer))
            observers.add(observer);
    }

    public void detach(Observer<T> observer){
        if(observers.contains(observer))
            observers.remove(observer);
    }

    public void notify(T t){
        for (Observer<T> observer : observers){
            observer.Update(t);
        }
    }
}
