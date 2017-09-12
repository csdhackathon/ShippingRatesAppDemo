package pb.coe.pbhackathon.rest.job;

import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.manager.RateInputDataManager;
import pb.coe.pbhackathon.rest.model.Events;
import pb.coe.pbhackathon.rest.model.RequestBody;
import pb.coe.pbhackathon.rest.model.ResponseViews;
import retrofit2.Call;

/**
 * Created by chetan on 11/09/17.
 * Post Shipping Rate API
 */

public class PostShippingRateJob extends BaseRetrofitJob<ResponseViews.ShippingRateCardResponseView> {
    @Override
    protected Call<ResponseViews.ShippingRateCardResponseView> call() {
        RequestBody.ShippingRateRequestView body = new RequestBody.ShippingRateRequestView();
        body.fromAddress = RateInputDataManager.getInstance().fromAddress;
        body.toAddress = RateInputDataManager.getInstance().toAddress;
        body.parcel = RateInputDataManager.getInstance().parcel;
        body.rates = RateInputDataManager.getInstance().rates;
        return AppDelegate.get().getRestFactory().getShippingApi().postShippingRates(body);
    }

    @Override
    protected void onSuccess(ResponseViews.ShippingRateCardResponseView response) {
        if(response.rates != null && response.rates.size() > 0) {
            AppDelegate.get().getEventBus().postSticky(new Events.PostShippingStickyEvent(response.rates.get(0).getModel(), null));
        } else {
            AppDelegate.get().getEventBus().postSticky(new Events.PostShippingStickyEvent(null, null));
        }
    }

    @Override
    protected void onFailure(String error) {
        AppDelegate.get().getEventBus().postSticky(new Events.PostShippingStickyEvent(null, error));
    }
}
