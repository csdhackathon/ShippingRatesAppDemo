package pb.coe.pbhackathon.rest.model;

import java.util.List;

import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.model.CountryDetailModel;

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
        private boolean success;

        public PostShippingStickyEvent(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
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
