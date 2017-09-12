package pb.coe.pbhackathon.rest.model;

import pb.coe.pbhackathon.model.AddressModel;
import pb.coe.pbhackathon.model.ParcelModel;
import pb.coe.pbhackathon.model.RateModel;

/**
 * Created by chetan on 11/09/17.
 * Request body/view classes for REST communication, add more as per requirement
 */

public class RequestBody {

    public static class ShippingRateRequestView {
        public AddressModel fromAddress;
        public AddressModel toAddress;
        public ParcelModel parcel;
        public RateModel[] rates;
    }
}
