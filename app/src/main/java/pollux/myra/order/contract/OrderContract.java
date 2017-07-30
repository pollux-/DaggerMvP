package pollux.myra.order.contract;

/**
 * Interface to handle orders
 */
public interface OrderContract {
    /**
     * Callback to notify the View
     */
    interface View  {
        /**
         * Update order Success callback
         */
        void updateOrderSuccess();

        /**
         * Update failed callback
         */
        void updateOderFailed();
    }


    interface Presenter extends BasePresenter<OrderContract.View>{
        /**
         * Update the Order
         */
        void updateOrder();

        /**
         * on Success order
         */
        void onSuccessOrder();

        /**
         * On failed update
         */
        void onFailedOrderUpdate();
    }

    interface Interactor extends BaseInteractor<Presenter>{
        /**
         * Call update order api
         */
        void updateOrder();
    }
}
