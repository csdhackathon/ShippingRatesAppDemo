package pb.coe.pbhackathon.rest.job;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.rest.model.Events;
import pb.coe.pbhackathon.rest.model.ResponseViews;
import pb.coe.pbhackathon.utils.PBLogger;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by chetan on 11/09/17.
 * Basic Retrofit Job abstraction
 */
public abstract class BaseRetrofitJob<T> extends Job {

    private static final PBLogger log = PBLogger.getPbLogger(BaseRetrofitJob.class);


    protected BaseRetrofitJob() {
        super(new Params(Priority.HIGH));
    }

    @Override
    public void onAdded() {
        log.v("onAdded");
    }

    @Override
    public void onRun() throws Throwable {
        Call<T> call = call();
        if(call != null) {
            Response<T> response = call.execute();
            log.v("onRun response success: " + response.isSuccessful() + " code: " + response.code());
            if(response.isSuccessful()) {
                onSuccess(response.body());
            } else {
                ResponseBody err = response.errorBody();
                if(err != null) {
                    //try getting first error detail
                    try {
                        String errorDetail = err.string();
                        JSONArray errorJsonArr = new JSONArray(errorDetail);
                        String message = errorJsonArr.getJSONObject(0).getString("message");
                        onFailure(message);
                    } catch (Exception ignore) {
                        onFailure("Failure: response code " + response.code() + ", message: " + response.message());
                    }
                } else {
                    onFailure("Failure: response code " + response.code() + ", message: " + response.message());
                }
            }
        } else {
            throw new IllegalArgumentException("Call should not be null");
        }
    }

    protected abstract Call<T> call();

    protected abstract void onSuccess(T response);

    protected abstract void onFailure(String error);

    @Override
    protected final void onCancel() {
        log.v("onCancel");
        onFailure("Unknown Error");
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        log.v("shouldReRunOnThrowable", throwable.toString());
        return false;
    }
}
