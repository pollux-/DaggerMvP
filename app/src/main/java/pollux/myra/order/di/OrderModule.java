package pollux.myra.order.di;

import dagger.Module;
import dagger.Provides;
import pollux.myra.network.api.MyraApi;
import pollux.myra.order.contract.OrderContract;
import pollux.myra.order.interactor.UpdateInteractor;
import pollux.myra.order.presenter.UpdateOrderPresenter;

/**
 * Created by sreekumar on 7/29/17.
 */

@Module
public class OrderModule {

    @OrderScope
    @Provides
    OrderContract.Presenter provideOrderPresenter(OrderContract.Interactor apiContract) {
        return new UpdateOrderPresenter(apiContract);
    }
    @OrderScope
    @Provides
    OrderContract.Interactor provideInteractor(MyraApi myraApi) {
        return new UpdateInteractor(myraApi);
    }



}
