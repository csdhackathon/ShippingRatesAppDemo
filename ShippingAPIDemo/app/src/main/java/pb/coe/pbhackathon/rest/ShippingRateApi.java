package pb.coe.pbhackathon.rest;

import java.util.List;

import pb.coe.pbhackathon.rest.model.RequestBody;
import pb.coe.pbhackathon.rest.model.ResponseViews;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by chetan on 11/09/17.
 * Shipping APIs
 */

public interface ShippingRateApi {

    @SuppressWarnings("SpellCheckingInspection")
    @POST("shippingservices/v1/rates")
    Call<ResponseViews.ShippingRateCardResponseView> postShippingRates(@Body RequestBody.ShippingRateRequestView body);

    @SuppressWarnings("SpellCheckingInspection")
    @GET("shippingservices/v1/countries")
    Call<List<ResponseViews.ShippingCountryView>> getCountryList(@Query("carrier") String carrier, @Query("originCountryCode") String originCountryCode);

}
