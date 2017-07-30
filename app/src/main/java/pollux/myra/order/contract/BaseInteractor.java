package pollux.myra.order.contract;

/**
 * Created by sreekumar on 7/30/17.
 */

public interface BaseInteractor<T> {
    void subscribe(T presenter);
}
