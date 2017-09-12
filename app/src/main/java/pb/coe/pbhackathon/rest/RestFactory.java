package pb.coe.pbhackathon.rest;

import android.support.annotation.NonNull;
import android.util.Base64;

import java.io.IOException;
import java.util.logging.Level;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chetan on 11/09/17.
 * API Factory for Rest services
 */
public class RestFactory {

    private final String apiKeySecret;

    private String token;
    private AuthApi authApi;
    private ShippingRateApi shippingApi;

    public RestFactory(String serverUrl, String apiKey, String accessKey) {
        this.apiKeySecret = Base64.encodeToString(String.format("%s:%s", apiKey, accessKey).getBytes(), Base64.DEFAULT);

        initBuilder(serverUrl);
    }

    private void initBuilder(String serverUrl) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //Open Client
        OkHttpClient clientOpen = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Authorization", ("Basic " + apiKeySecret).trim())
                                .header("Content-Type", "application/x-www-form-urlencoded");
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                }).build();

        Retrofit retrofitOpen = new Retrofit.Builder()
                .baseUrl(serverUrl)
                .client(clientOpen)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        buildOpenApis(retrofitOpen);

        //Auth Token Client
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Authorization", "Bearer " + token)
                                .header("Content-Type", "application/json");
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(serverUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        buildApis(retrofit);
    }

    private void buildApis(Retrofit retrofit) {
        shippingApi = retrofit.create(ShippingRateApi.class);
    }

    private void buildOpenApis(Retrofit retrofit) {
        authApi = retrofit.create(AuthApi.class);
    }

    public AuthApi getAuthApi() {
        return authApi;
    }

    public ShippingRateApi getShippingApi() {
        return shippingApi;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
