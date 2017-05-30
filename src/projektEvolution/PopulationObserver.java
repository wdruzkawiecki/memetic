package projektEvolution;

import projektEvolution.notify.Notifier;
import projektEvolution.notify.Observer;

public class PopulationObserver extends Observer<Population> {

    public PopulationObserver(Notifier<Population> notifier){
        this.notifier = notifier;
        this.notifier.attach(this);
    }

    @Override
    public void Update(Population population) {

    }
}
