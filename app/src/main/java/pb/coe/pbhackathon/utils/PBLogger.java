package pb.coe.pbhackathon.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by chetan on 11/09/17.
 */

public class PBLogger {

    private static final boolean DEBUG = true;
    private String tag = "";

    private static PBLogger pbLogger;

    private PBLogger(String tag) {
        this.tag = tag;
    }

    public static PBLogger getPbLogger(Class clazz)
    {
        if(pbLogger == null)
        {
            pbLogger = new PBLogger(clazz.getSimpleName());
        }
        return pbLogger;
    }
    public void d(String... string) {
        if (DEBUG) {
            Log.d(tag, TextUtils.join(",", string));
        }
    }

    public void v(String... string) {
        if (DEBUG) {
            Log.v(tag, TextUtils.join(",", string));
        }
    }

    public void i(String... string) {
        if (DEBUG) {
            Log.i(tag, TextUtils.join(",", string));
        }
    }

    public void e(String... string) {
        if (DEBUG) {
            Log.e(tag, TextUtils.join(",", string));
        }
    }
}
