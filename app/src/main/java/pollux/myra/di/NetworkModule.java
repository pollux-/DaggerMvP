package pollux.myra.di;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import pollux.myra.network.api.MyraApi;
import pollux.myra.util.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sreekumar on 7/29/17.
 */
@Module
public class NetworkModule {
    @Provides
    @ApplicationScope
    MyraApi provideNetworkClient(Gson gson){
        final Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.END_PONIT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder.build().create(MyraApi.class);
    }

    @Provides
    @ApplicationScope
    public Gson provideGson() {
        return new Gson();
    }


}
