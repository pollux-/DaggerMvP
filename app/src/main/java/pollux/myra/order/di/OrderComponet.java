package pollux.myra.order.di;

import dagger.Component;
import pollux.myra.di.ApplicationComponent;
import pollux.myra.order.ui.MainActivity;

/**
 * Created by sreekumar on 7/30/17.
 */

@OrderScope
@Component(dependencies = ApplicationComponent.class, modules = OrderModule.class)
public interface OrderComponet {
    void inject(MainActivity mainActivity);
}
