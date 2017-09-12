package pb.coe.pbhackathon.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.R;
import pb.coe.pbhackathon.manager.RateInputDataManager;
import pb.coe.pbhackathon.rest.job.PostShippingRateJob;
import pb.coe.pbhackathon.rest.model.Events;
import pb.coe.pbhackathon.ui.fragment.AddressFormFragment;
import pb.coe.pbhackathon.ui.fragment.ParcelFormFragment;
import pb.coe.pbhackathon.ui.fragment.ShippingRateFragment;
import pb.coe.pbhackathon.utils.PBLogger;

/**
 * Created by chetan on 11/09/17.
 * Main activity for Shipment Rate form and result data.
 */
public class MainActivity extends BaseAppCompatActivity {
    private static final PBLogger log = PBLogger.getPbLogger(MainActivity.class);

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();

        Fragment fragment = new AddressFormFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(AddressFormFragment.TYPE_FROM_ADDRESS, true);
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
    }

    @Override
    protected boolean needEventBus() {
        return true;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventFromAddressCollected(Events.FromAddressInformationCollectedEvent event) {
        event.removeSelf();
        Fragment fragment = new AddressFormFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(AddressFormFragment.TYPE_FROM_ADDRESS, false);
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventToAddressCollected(Events.ToAddressInformationCollectedEvent event) {
        event.removeSelf();
        Fragment fragment = new ParcelFormFragment();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventParcelDetailCollected(Events.ParcelInformationCollectedEvent event) {
        event.removeSelf();
        postRateDetailJob();
    }

    private void postRateDetailJob() {
        showProgressDialog();
        AppDelegate.get().getJobManager().addJob(new PostShippingRateJob());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvenShippingRate(Events.PostShippingStickyEvent event) {
        log.v("onEvenShippingRate", "Success: " + event.isSuccess());
        event.removeSelf();
        hideProgressDialog();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE); //remove all previous fragments
        if(event.isSuccess()) {
            Fragment fragment = new ShippingRateFragment();
            Bundle args = new Bundle();
            args.putParcelable(ShippingRateFragment.ARGS_RATE_MODEL, event.getModel());
            fragment.setArguments(args);
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
        } else {
            if(event.getError() == null) {
                showLongToast(getString(R.string.shipping_post_failed));
            } else {
                showLongToast(event.getError());
            }
            RateInputDataManager.getInstance().reset();
            finish();
        }
    }
}
