package pb.coe.pbhackathon.rest.model;

import java.util.ArrayList;
import java.util.List;

import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.model.CountryDetailModel;
import pb.coe.pbhackathon.model.ShippingRateDetailModel;

/**
 * Created by chetan on 11/09/17.
 * EventBus events to communicate to UI
 */

public final class Events {

    public static class BaseStickyEvent {
        public final void removeSelf() {
            AppDelegate.get().getEventBus().removeStickyEvent(this);
        }
    }

    public static class AccessTokenResponseEvent extends BaseStickyEvent {
        private final String errorMessage;

        public AccessTokenResponseEvent(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    public static class ParcelInformationCollectedEvent extends BaseStickyEvent {
    }

    public static class FromAddressInformationCollectedEvent extends BaseStickyEvent {
    }

    public static class ToAddressInformationCollectedEvent extends BaseStickyEvent {
    }

    public static class PostShippingStickyEvent extends BaseStickyEvent {

        private ShippingRateDetailModel model;
        private String error;

        public PostShippingStickyEvent(ShippingRateDetailModel model, String error) {
            this.model = model;
            this.error = error;
        }

        public boolean isSuccess() {
            return model != null;
        }

        public ShippingRateDetailModel getModel() {
            return model;
        }

        public String getError() {
            return error;
        }
    }

    public static class GetCountryListStickyEvent extends BaseStickyEvent {
        private List<CountryDetailModel> list;

        public GetCountryListStickyEvent(List<CountryDetailModel> list) {
            this.list = list;
        }

        public List<CountryDetailModel> getList() {
            return list;
        }
    }
}
