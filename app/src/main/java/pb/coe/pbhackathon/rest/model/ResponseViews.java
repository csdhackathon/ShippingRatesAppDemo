package pb.coe.pbhackathon.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pb.coe.pbhackathon.model.ShippingRateDetailModel;

/**
 * Created by chetan on 11/09/17.
 * Basic Response Views for REST communication
 */
public class ResponseViews {

    public static class BaseResponseView {
        //To use common response logic here
    }

    public static class AccessTokenResponseView extends BaseResponseView {
        @SerializedName("access_token")
        public String accessToken;
        public String tokenType;
        public String issuedAt;
        public String expiresIn;
        public String clientID;
        public String org;
    }

    public static class ShippingCountryView {
        public String countryCode;
        public String countryName;
    }

    public static class ShippingRateCardResponseView {
        /*We can add all other fields/views, but currently we are showing few details for demo*/
        public List<ShippingRateCardDetailView> rates;

        public static class ShippingRateCardDetailView {
            public String carrier;
            public String parcelType;

            public String baseCharge;
            public String totalCarrierCharge;
            public String alternateBaseCharge;
            public String destinationZone;
            public String alternateTotalCharge;

            public ShippingRateDetailModel getModel() {
                ShippingRateDetailModel model = new ShippingRateDetailModel();
                model.carrier = carrier;
                model.parcelType = parcelType;
                model.baseCharge = baseCharge;
                model.totalCarrierCharge = totalCarrierCharge;
                model.alternateBaseCharge = alternateBaseCharge;
                model.destinationZone = destinationZone;
                model.alternateTotalCharge = alternateTotalCharge;
                return model;

            }
        }
    }

}
