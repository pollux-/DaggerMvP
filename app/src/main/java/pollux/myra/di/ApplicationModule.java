package pollux.myra.di;

import dagger.Module;
import dagger.Provides;
import pollux.myra.MyraApp;

@Module
public class ApplicationModule {

    private MyraApp mApp;

    public ApplicationModule(MyraApp app) {
        mApp = app;
    }

    @Provides
    @ApplicationScope
    public MyraApp provideApplication() {
        return mApp;
    }

}
