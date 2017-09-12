package pb.coe.pbhackathon.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.R;

/**
 * Created by chetan on 11/09/17.
 * Base AppCompat activity for framework
 */

public class BaseAppCompatActivity extends AppCompatActivity {

    @SuppressWarnings("deprecation")
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.msg_please_wait));
        progressDialog.setCancelable(false);
    }

    protected boolean needEventBus() {
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(needEventBus()) {
            AppDelegate.get().getEventBus().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(needEventBus()) {
            AppDelegate.get().getEventBus().unregister(this);
        }
    }

    protected final void showProgressDialog() {
        if(!progressDialog.isShowing()) {
            progressDialog.setMessage(getString(R.string.msg_please_wait));
            progressDialog.show();
        }
    }

    protected final void showProgressDialog(String message) {
        if(!progressDialog.isShowing()) {
            progressDialog.setMessage(message);
            progressDialog.show();
        }
    }

    protected final void hideProgressDialog() {
        if(progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    protected final void showShortToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected final void showLongToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
