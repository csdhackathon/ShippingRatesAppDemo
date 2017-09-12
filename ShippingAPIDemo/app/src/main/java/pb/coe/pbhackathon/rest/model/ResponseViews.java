package pb.coe.pbhackathon.rest.model;

import com.google.gson.annotations.SerializedName;

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
}
