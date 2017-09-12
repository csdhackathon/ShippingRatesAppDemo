package pb.coe.pbhackathon.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import pb.coe.pbhackathon.AppDelegate;
import pb.coe.pbhackathon.R;
import pb.coe.pbhackathon.rest.job.GetShippingCountryListJob;
import pb.coe.pbhackathon.rest.model.Events;
import pb.coe.pbhackathon.ui.adapter.CountryListAdapter;

public class ListActivity extends BaseAppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private CountryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.title_country_list));
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CountryListAdapter(null);
        recyclerView.setAdapter(adapter);

        showProgressDialog(getString(R.string.msg_getting_country_list));
        AppDelegate.get().getJobManager().addJob(new GetShippingCountryListJob());
    }

    @Override
    protected boolean needEventBus() {
        return true;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventList(Events.GetCountryListStickyEvent event) {
        event.removeSelf();
        hideProgressDialog();
        adapter.setList(event.getList());
        if(event.getList() == null) {
            showLongToast(getString(R.string.toast_no_data_available));
            finish();
        }
    }
}
