package pb.coe.pbhackathon.rest.job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.model.CountryDetailModel;
import pb.coe.pbhackathon.rest.model.Events;
import pb.coe.pbhackathon.rest.model.ResponseViews;
import pb.coe.pbhackathon.utils.PBLogger;
import retrofit2.Call;

/**
 * Created by chetan on 11/09/17.
 * Get Shipping Country list
 */

public class GetShippingCountryListJob extends BaseRetrofitJob<List<ResponseViews.ShippingCountryView>> {
    private static final PBLogger log = PBLogger.getPbLogger(GetShippingCountryListJob.class);

    @Override
    protected Call<List<ResponseViews.ShippingCountryView>> call() {
        return AppDelegate.get().getRestFactory().getShippingApi().getCountryList("usps", "US");
    }

    @Override
    protected void onSuccess(List<ResponseViews.ShippingCountryView> response) {
        log.d("onSuccess " + response.size());
        List<CountryDetailModel> list = new ArrayList<>(response.size());
        for(ResponseViews.ShippingCountryView view : response) {
            list.add(new CountryDetailModel(view.countryCode, view.countryName));
        }
        Collections.sort(list);
        AppDelegate.get().getEventBus().postSticky(new Events.GetCountryListStickyEvent(list));
    }

    @Override
    protected void onFailure(String error) {
        AppDelegate.get().getEventBus().postSticky(new Events.GetCountryListStickyEvent(null));
    }
}
