package pb.coe.pbhackathon.manager;

import pb.coe.pbhackathon.model.AddressModel;
import pb.coe.pbhackathon.model.ParcelModel;
import pb.coe.pbhackathon.model.RateModel;

/**
 * Created by chetan on 11/09/17.
 * Data holder/manager for Shipping rate form session.
 */

public class RateInputDataManager {
    private static final RateInputDataManager ourInstance = new RateInputDataManager();

    public static RateInputDataManager getInstance() {
        return ourInstance;
    }

    private RateInputDataManager() {
    }

    public AddressModel fromAddress;
    public AddressModel toAddress;
    public ParcelModel parcel;
    public RateModel[] rates;

    public void reset() {
        fromAddress = null;
        toAddress = null;
        parcel = null;
    }
}
