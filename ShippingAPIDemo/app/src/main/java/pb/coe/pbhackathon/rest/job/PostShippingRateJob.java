package pb.coe.pbhackathon.rest.job;

import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.manager.RateInputDataManager;
import pb.coe.pbhackathon.rest.model.Events;
import pb.coe.pbhackathon.rest.model.RequestBody;
import retrofit2.Call;

/**
 * Created by chetan on 11/09/17.
 * Post Shipping Rate API
 */

public class PostShippingRateJob extends BaseRetrofitJob<Object> {
    @Override
    protected Call<Object> call() {
        RequestBody.ShippingRateRequestView body = new RequestBody.ShippingRateRequestView();
        body.fromAddress = RateInputDataManager.getInstance().fromAddress;
        body.toAddress = RateInputDataManager.getInstance().toAddress;
        body.parcel = RateInputDataManager.getInstance().parcel;
        body.rates = RateInputDataManager.getInstance().rates;
        return AppDelegate.get().getRestFactory().getShippingApi().postShippingRates(body);
    }

    @Override
    protected void onSuccess(Object response) {
        RateInputDataManager.getInstance().reset();
        AppDelegate.get().getEventBus().postSticky(new Events.PostShippingStickyEvent(true));
    }

    @Override
    protected void onFailure(String error) {
        AppDelegate.get().getEventBus().postSticky(new Events.PostShippingStickyEvent(false));
    }
}
