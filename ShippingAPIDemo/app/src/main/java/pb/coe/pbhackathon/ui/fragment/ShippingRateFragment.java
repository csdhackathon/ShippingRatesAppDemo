package pb.coe.pbhackathon.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.R;
import pb.coe.pbhackathon.manager.RateInputDataManager;
import pb.coe.pbhackathon.model.DimensionModel;
import pb.coe.pbhackathon.model.InputParameterModel;
import pb.coe.pbhackathon.model.ParcelModel;
import pb.coe.pbhackathon.model.RateModel;
import pb.coe.pbhackathon.model.SpecialServiceModel;
import pb.coe.pbhackathon.model.WeightModel;
import pb.coe.pbhackathon.rest.model.Events;

/**
 * Created by chetan on 11/09/17.
 * Shipping Rate Fragment
 */
public class ShippingRateFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.rates_information_layout, container, false);
        ButterKnife.bind(this, inflatedView);
        setupUI();
        return inflatedView;
    }

    private void setupUI() {
        getActivity().setTitle(getString(R.string.label_rates_detail));

    }
}
