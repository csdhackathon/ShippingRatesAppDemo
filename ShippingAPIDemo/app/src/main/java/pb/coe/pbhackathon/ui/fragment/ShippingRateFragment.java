package pb.coe.pbhackathon.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.R;
import pb.coe.pbhackathon.manager.RateInputDataManager;
import pb.coe.pbhackathon.model.DimensionModel;
import pb.coe.pbhackathon.model.InputParameterModel;
import pb.coe.pbhackathon.model.ParcelModel;
import pb.coe.pbhackathon.model.RateModel;
import pb.coe.pbhackathon.model.ShippingRateDetailModel;
import pb.coe.pbhackathon.model.SpecialServiceModel;
import pb.coe.pbhackathon.model.WeightModel;
import pb.coe.pbhackathon.rest.model.Events;
import pb.coe.pbhackathon.ui.adapter.LabelValueGenericAdapter;

/**
 * Created by chetan on 11/09/17.
 * Shipping Rate Fragment
 */
public class ShippingRateFragment extends Fragment {

    public static final String ARGS_RATE_MODEL = "args_rate_model";
    @BindView(R.id.shippingRatesRecyclerView) RecyclerView shippingRatesRecyclerView;

    private ShippingRateDetailModel rateDetailModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.rates_information_layout, container, false);
        rateDetailModel = getArguments().getParcelable(ARGS_RATE_MODEL);
        ButterKnife.bind(this, inflatedView);
        setupUI();
        return inflatedView;
    }

    private void setupUI() {
        getActivity().setTitle(getString(R.string.label_rates_detail));
        shippingRatesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Pair<String, String>> pairList = new ArrayList<>();

        pairList.add(new Pair<>(getString(R.string.rate_detail_lable_carrier), rateDetailModel.carrier));
        pairList.add(new Pair<>(getString(R.string.rate_detail_lable_parcel_type), rateDetailModel.parcelType));
        pairList.add(new Pair<>(getString(R.string.rate_detail_lable_base_charge), rateDetailModel.baseCharge));
        pairList.add(new Pair<>(getString(R.string.rate_detail_lable_total_carrier_charge), rateDetailModel.totalCarrierCharge));
        pairList.add(new Pair<>(getString(R.string.rate_detail_lable_alt_base_charge), rateDetailModel.alternateBaseCharge));
        pairList.add(new Pair<>(getString(R.string.rate_detail_lable_detination_zone), rateDetailModel.destinationZone));
        pairList.add(new Pair<>(getString(R.string.rate_detail_lable_alt_total_charge), rateDetailModel.alternateTotalCharge));

        pairList = trimEmptyValueItem(pairList);

        LabelValueGenericAdapter adapter = new LabelValueGenericAdapter(pairList);
        shippingRatesRecyclerView.setAdapter(adapter);
    }

    private List<Pair<String, String>> trimEmptyValueItem(List<Pair<String, String>> pairList) {
        List<Pair<String, String>> trimmedList = new ArrayList<>();
        for(Pair<String, String> pair : pairList) {
            if(!TextUtils.isEmpty(pair.second)) {
                trimmedList.add(pair);
            }
        }
        return trimmedList;
    }
}
