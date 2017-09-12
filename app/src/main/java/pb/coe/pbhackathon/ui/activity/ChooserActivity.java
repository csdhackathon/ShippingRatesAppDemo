package pb.coe.pbhackathon.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pb.coe.pbhackathon.R;

public class ChooserActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.goListButton)
    public void onClickGoList(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.goRateFormButton)
    public void onClickGoMainForm(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
