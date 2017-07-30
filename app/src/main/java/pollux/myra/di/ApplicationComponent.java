package pollux.myra.di;

import dagger.Component;
import pollux.myra.MyraApp;
import pollux.myra.network.api.MyraApi;

/**
 * Created by sreekumar on 7/29/17.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    MyraApp provideApplication();

    MyraApi provideNetworkClient();
}
