package pollux.myra.order.presenter;

import javax.inject.Inject;

import pollux.myra.order.contract.OrderContract;

/**
 * Created by sreekumar on 7/29/17.
 */

public class UpdateOrderPresenter implements OrderContract.Presenter {

    @Inject
    OrderContract.Interactor mUpdateInteractor;
    private OrderContract.View mView;

    public UpdateOrderPresenter(OrderContract.Interactor apiContract) {
        this.mUpdateInteractor = apiContract;
        mUpdateInteractor.subscribe(this);
    }


    /**
     * Update the Order
     */
    @Override
    public void updateOrder() {
        mUpdateInteractor.updateOrder();

    }

    /**
     * on Success order
     */
    @Override
    public void onSuccessOrder() {
        mView.updateOrderSuccess();
    }

    /**
     * On failed update
     */
    @Override
    public void onFailedOrderUpdate() {
        mView.updateOderFailed();
    }

    /**
     * Resource clean up
     */
    @Override
    public void cleanup() {
        mView = null;
    }

    @Override
    public void subscribe(OrderContract.View view) {
        mView = view;
    }
}
