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
 * Parcel Fragment
 */
public class ParcelFormFragment extends Fragment {

    @BindView(R.id.weight_edittext) EditText weightEditText;
    @BindView(R.id.length_edittext) EditText lengthEditText;
    @BindView(R.id.width_edittext) EditText widthEditText;
    @BindView(R.id.height_edittext) EditText heightEditText;

    @BindView(R.id.submit_button) Button submitButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.parcel_information_layout, container, false);
        ButterKnife.bind(this, inflatedView);
        setupUI();
        return inflatedView;
    }

    private void setupUI() {
        getActivity().setTitle(getString(R.string.label_parcel_detail));

        weightEditText.setText("12");
        lengthEditText.setText("2");
        widthEditText.setText("4");
        heightEditText.setText("3");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(weightEditText.getText()) ||
                        TextUtils.isEmpty(lengthEditText.getText()) ||
                        TextUtils.isEmpty(widthEditText.getText()) ||
                        TextUtils.isEmpty(heightEditText.getText())) {

                    Toast.makeText(getActivity(), getResources().getString(R.string.error_missing_entry), Toast.LENGTH_LONG).show();
                    return;
                }
                ParcelModel model = new ParcelModel();

                WeightModel weightModel = new WeightModel();
                weightModel.setWeight(Double.parseDouble(weightEditText.getText().toString().trim()));
                weightModel.setUnitOfMeasurement("OZ"); //Unit, check documentation

                model.setWeight(weightModel);

                DimensionModel dimensionModel = new DimensionModel();
                dimensionModel.setUnitOfMeasurement("IN"); //Unit, check documentation
                dimensionModel.setLength(Double.parseDouble(lengthEditText.getText().toString().trim()));
                dimensionModel.setWidth(Double.parseDouble(widthEditText.getText().toString().trim()));
                dimensionModel.setHeight(Double.parseDouble(heightEditText.getText().toString().trim()));
                dimensionModel.setIrregularParcelGirth(0.002); //Some value for size growth. check documentation

                model.setDimension(dimensionModel);

                RateInputDataManager.getInstance().parcel = model;

                // Preparing Rates model
                RateModel rateModel = new RateModel();
                rateModel.setCarrier("usps");
                rateModel.setServiceId("PM");
                rateModel.setParcelType("PKG");

                // SpecialServiceModel 1st Object
                SpecialServiceModel specialServiceModel1 = new SpecialServiceModel();
                specialServiceModel1.setSpecialServiceId("Ins");

                InputParameterModel inputParameterModel1 = new InputParameterModel();
                inputParameterModel1.setName("INPUT_VALUE");
                inputParameterModel1.setValue("50");

                InputParameterModel[] inputParameterModels1 = { inputParameterModel1 };

                specialServiceModel1.setInputParameters(inputParameterModels1);

                // SpecialServiceModel 12nd Object
                SpecialServiceModel specialServiceModel2 = new SpecialServiceModel();
                specialServiceModel2.setSpecialServiceId("DelCon");

                InputParameterModel inputParameterModel2 = new InputParameterModel();
                inputParameterModel2.setName("INPUT_VALUE");
                inputParameterModel2.setValue("0");

                InputParameterModel[] inputParameterModels2 = { inputParameterModel2 };

                specialServiceModel2.setInputParameters(inputParameterModels2);

                SpecialServiceModel[] specialServiceModels = {specialServiceModel1, specialServiceModel2};

                rateModel.setSpecialServices(specialServiceModels);
                rateModel.setInductionPostalCode("06484");

                RateInputDataManager.getInstance().rates = new RateModel[]{ rateModel };

                AppDelegate.get().getEventBus().postSticky(new Events.ParcelInformationCollectedEvent());
            }
        });
    }
}
