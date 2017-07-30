package pollux.myra.order.contract;

/**
 * Created by sreekumar on 7/29/17.
 */

public interface BasePresenter<T> {
    /**
     * Resource clean up
     */
    void cleanup();

    void subscribe(T view);
}
