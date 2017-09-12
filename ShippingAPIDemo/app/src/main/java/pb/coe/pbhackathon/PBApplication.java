package pb.coe.pbhackathon;

import android.app.Application;

/**
 * Created by chetan on 11/09/17.
 * Main Application class
 */
public class PBApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDelegate.get().init(this);
    }
}
