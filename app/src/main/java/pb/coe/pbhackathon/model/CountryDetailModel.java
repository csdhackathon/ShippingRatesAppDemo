package pb.coe.pbhackathon.model;

import android.support.annotation.NonNull;

/**
 * Created by chetan on 12/09/17.
 * Country Detail Model, with comparable support.
 */
public class CountryDetailModel implements Comparable<CountryDetailModel> {
    public final String name;
    public final String code;

    public CountryDetailModel(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int compareTo(@NonNull CountryDetailModel model) {
        if(name == null || model.name == null) {
            return 0;
        }
        return name.compareToIgnoreCase(model.name);
    }
}
