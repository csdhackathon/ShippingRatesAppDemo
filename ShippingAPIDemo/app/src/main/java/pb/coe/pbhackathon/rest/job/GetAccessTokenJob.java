package pb.coe.pbhackathon.rest.job;

import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.rest.model.Events;
import pb.coe.pbhackathon.rest.model.ResponseViews;
import pb.coe.pbhackathon.utils.PBLogger;
import retrofit2.Call;

/**
 * Created by chetan on 11/09/17.
 * Get access token
 */
public class GetAccessTokenJob extends BaseRetrofitJob<ResponseViews.AccessTokenResponseView> {
    private static final PBLogger log = PBLogger.getPbLogger(GetAccessTokenJob.class);

    @Override
    protected Call<ResponseViews.AccessTokenResponseView> call() {
        return AppDelegate.get().getRestFactory().getAuthApi().getAccessToken("client_credentials");
    }

    @Override
    protected void onSuccess(ResponseViews.AccessTokenResponseView response) {
        log.d("token " + response.accessToken);
        AppDelegate.get().getRestFactory().setToken(response.accessToken);
        handleResponse(null);
    }

    @Override
    protected void onFailure(String error) {
        handleResponse(error);
    }

    private void handleResponse(String error) {
        AppDelegate.get().getEventBus().postSticky(new Events.AccessTokenResponseEvent(error));
    }
}
