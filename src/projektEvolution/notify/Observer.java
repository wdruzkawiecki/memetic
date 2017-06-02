package projektEvolution.notify;

import projektEvolution.Population;

public abstract class Observer<T extends ISubject> {
    protected Notifier<T> notifier;
    public abstract void Update(T t);
}
