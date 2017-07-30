package pollux.myra.network.api;

import pollux.myra.network.request.OrderRequest;
import pollux.myra.network.response.OrderResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by sreekumar on 7/29/17.
 */

public interface MyraApi {

    @POST("/api")
    Call<OrderResponse> updateOrder(@Body OrderRequest orderRequest);
}
