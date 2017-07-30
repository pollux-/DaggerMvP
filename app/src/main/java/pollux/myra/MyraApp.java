package pollux.myra;

import android.app.Application;

import pollux.myra.di.ApplicationComponent;
import pollux.myra.di.ApplicationModule;
import pollux.myra.di.DaggerApplicationComponent;

/**
 * Created by sreekumar on 7/29/17.
 */

public class MyraApp extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder().
                applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
