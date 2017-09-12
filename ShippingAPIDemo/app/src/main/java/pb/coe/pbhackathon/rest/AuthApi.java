package pb.coe.pbhackathon.rest;

import pb.coe.pbhackathon.rest.model.ResponseViews;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by chetan on 11/09/17.
 * Auth API for Token
 */
public interface AuthApi {

    @FormUrlEncoded
    @POST("oauth/token")
    Call<ResponseViews.AccessTokenResponseView> getAccessToken(@Field("grant_type") String type);
}
