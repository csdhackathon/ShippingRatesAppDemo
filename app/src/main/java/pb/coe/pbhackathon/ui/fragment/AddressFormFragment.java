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
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.R;
import pb.coe.pbhackathon.manager.RateInputDataManager;
import pb.coe.pbhackathon.model.AddressModel;
import pb.coe.pbhackathon.rest.model.Events;

public class AddressFormFragment extends Fragment {

    public static final String TYPE_FROM_ADDRESS = "from_address_args";

    @BindView(R.id.from_address1_edittext) EditText addressLine1EditText;
    @BindView(R.id.from_address2_edittext) EditText addressLine2EditText;
    @BindView(R.id.from_address3_edittext) EditText addressLine3EditText;

    @BindView(R.id.from_city_edittext) EditText cityEditText;
    @BindView(R.id.from_state_edittext) EditText stateEditText;
    @BindView(R.id.from_postalcode_edittext) EditText postalCodeEditText;
    @BindView(R.id.from_countrycode_edittext) EditText countryCodeEditText;
    @BindView(R.id.from_name_edittext) EditText nameEditText;
    @BindView(R.id.from_company_edittext) EditText companyEditText;
    @BindView(R.id.from_phone_edittext) EditText phoneEditText;
    @BindView(R.id.from_email_edittext) EditText emailEditText;
    @BindView(R.id.from_submit_button) Button submitButton;
    @BindView(R.id.addressTypeLabelTextView) TextView addressTypeLabelTextView;

    private boolean isTypeFromAddressMode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.from_address_layout, container, false);
        isTypeFromAddressMode = getArguments().getBoolean(TYPE_FROM_ADDRESS);
        ButterKnife.bind(this, inflatedView);
        setupUI();
        return inflatedView;
    }

    private void setupUI() {
        getActivity().setTitle(getString(R.string.label_shipping_detail));

        addressTypeLabelTextView.setText(isTypeFromAddressMode ? R.string.from_address : R.string.to_address);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(addressLine1EditText.getText()) ||
                        TextUtils.isEmpty(cityEditText.getText()) ||
                        TextUtils.isEmpty(postalCodeEditText.getText()) ||
                        TextUtils.isEmpty(countryCodeEditText.getText()) ||
                        TextUtils.isEmpty(nameEditText.getText()) ||
                        TextUtils.isEmpty(companyEditText.getText()) ||
                        TextUtils.isEmpty(phoneEditText.getText()) ||
                        TextUtils.isEmpty(emailEditText.getText())) {

                    Toast.makeText(getContext(), getResources().getString(R.string.error_missing_entry), Toast.LENGTH_LONG).show();
                    return;
                }
                AddressModel model = new AddressModel();
                model.setAddressLines(new String[]{addressLine1EditText.getText().toString().trim(),
                        addressLine2EditText.getText().toString().trim(),
                        addressLine3EditText.getText().toString().trim()});
                model.setCityTown(cityEditText.getText().toString().trim());
                model.setStateProvince(stateEditText.getText().toString().trim());
                model.setPostalCode(postalCodeEditText.getText().toString().trim());
                model.setCountryCode(countryCodeEditText.getText().toString().trim());
                model.setName(nameEditText.getText().toString().trim());
                model.setCompany(companyEditText.getText().toString().trim());
                model.setPhone(phoneEditText.getText().toString().trim());
                model.setEmail(emailEditText.getText().toString().trim());

                if(isTypeFromAddressMode) {
                    RateInputDataManager.getInstance().fromAddress = model;
                    AppDelegate.get().getEventBus().postSticky(new Events.FromAddressInformationCollectedEvent());
                } else {
                    RateInputDataManager.getInstance().toAddress = model;
                    AppDelegate.get().getEventBus().postSticky(new Events.ToAddressInformationCollectedEvent());
                }
            }
        });
        setDummyData();
    }

    /**
     * Dummy data to test/demo
     */
    private void setDummyData() {
        if(isTypeFromAddressMode) {
            nameEditText.setText("John");
            phoneEditText.setText("12233222222");
            postalCodeEditText.setText("06484");
            emailEditText.setText("sender@something.com");
            companyEditText.setText("Pitney Bowes");
        } else {
            nameEditText.setText("Jack");
            phoneEditText.setText("12233222444");
            postalCodeEditText.setText("03901");
            emailEditText.setText("other@something.com");
            companyEditText.setText("Google");
        }

        addressLine1EditText.setText("Florida");
        cityEditText.setText("Denbury");
        stateEditText.setText("CT");

        countryCodeEditText.setText("US");
    }
}
