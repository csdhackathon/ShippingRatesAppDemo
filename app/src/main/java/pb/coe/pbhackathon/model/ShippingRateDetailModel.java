package pb.coe.pbhackathon.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chetan on 12/09/17.
 * Shipping rate details model
 */

public class ShippingRateDetailModel implements Parcelable {
    public String baseCharge;
    public String totalCarrierCharge;
    public String alternateBaseCharge;
    public String destinationZone;
    public String alternateTotalCharge;
    public String carrier;
    public String parcelType;

    public ShippingRateDetailModel() {}

    protected ShippingRateDetailModel(Parcel in) {
        carrier = in.readString();
        parcelType = in.readString();
        baseCharge = in.readString();
        totalCarrierCharge = in.readString();
        alternateBaseCharge = in.readString();
        destinationZone = in.readString();
        alternateTotalCharge = in.readString();
    }

    public static final Creator<ShippingRateDetailModel> CREATOR = new Creator<ShippingRateDetailModel>() {
        @Override
        public ShippingRateDetailModel createFromParcel(Parcel in) {
            return new ShippingRateDetailModel(in);
        }

        @Override
        public ShippingRateDetailModel[] newArray(int size) {
            return new ShippingRateDetailModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(carrier);
        parcel.writeString(parcelType);
        parcel.writeString(baseCharge);
        parcel.writeString(totalCarrierCharge);
        parcel.writeString(alternateBaseCharge);
        parcel.writeString(destinationZone);
        parcel.writeString(alternateTotalCharge);
    }
}
