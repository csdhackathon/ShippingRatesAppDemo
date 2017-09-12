package pb.coe.pbhackathon.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.R;
import pb.coe.pbhackathon.rest.job.GetAccessTokenJob;
import pb.coe.pbhackathon.rest.model.Events;
import pb.coe.pbhackathon.rest.model.ResponseViews;
import pb.coe.pbhackathon.ui.activity.MainActivity;

/**
 * Created by chetan on 11/09/17.
 * Splash Activity (Launcher)
 */
public class SplashActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        AppDelegate.get().getJobManager().addJob(new GetAccessTokenJob());
    }

    private void launchMainActivity() {
        Intent intent = new Intent(this, ChooserActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected boolean needEventBus() {
        return true;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onAccessTokenEvent(Events.AccessTokenResponseEvent event) {
        event.removeSelf();
        if(event.getErrorMessage() == null) {
            launchMainActivity();
        } else {
            showShortToast(event.getErrorMessage());
            finish();
        }
    }
}
