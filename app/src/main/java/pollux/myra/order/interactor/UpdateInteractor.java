package pollux.myra.order.interactor;

import javax.inject.Inject;

import pollux.myra.network.api.MyraApi;
import pollux.myra.network.request.OrderRequest;
import pollux.myra.network.response.OrderResponse;
import pollux.myra.order.contract.OrderContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sreekumar on 7/29/17.
 */

public class UpdateInteractor implements OrderContract.Interactor {

    private OrderContract.Presenter updateOrderPresenter;
    private MyraApi mMyraApi;

    @Inject
    public UpdateInteractor(MyraApi myraApi) {
        this.mMyraApi = myraApi;
    }

    /**
     * Call update order api
     */
    @Override
    public void updateOrder() {
        mMyraApi.updateOrder(new OrderRequest()).enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                updateOrderPresenter.onSuccessOrder();
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                updateOrderPresenter.onFailedOrderUpdate();
            }
        });
    }

    @Override
    public void subscribe(OrderContract.Presenter presenter) {
        updateOrderPresenter =  presenter;
    }
}
