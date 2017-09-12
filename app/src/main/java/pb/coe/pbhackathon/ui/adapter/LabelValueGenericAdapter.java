package pb.coe.pbhackathon.ui.adapter;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pb.coe.pbhackathon.R;

/**
 * Created by chetan on 12/09/17.
 * Generic Adapter for Label Value String pair.
 */

public class LabelValueGenericAdapter extends RecyclerView.Adapter<LabelValueGenericAdapter.ViewHolder> {

    private List<Pair<String, String>> pairList;

    public LabelValueGenericAdapter(List<Pair<String, String>> pairList) {
        this.pairList = pairList;
    }

    public void setPairList(List<Pair<String, String>> pairList) {
        this.pairList = pairList;
        notifyDataSetChanged();
    }

    @Override
    public LabelValueGenericAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.label_value_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(LabelValueGenericAdapter.ViewHolder holder, int position) {
        Pair<String, String> pair = pairList.get(position);
        holder.labelTextView.setText(pair.first);
        holder.valueTextView.setText(pair.second);
    }

    @Override
    public int getItemCount() {
        return pairList != null ? pairList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.labelTextView) TextView labelTextView;
        @BindView(R.id.valueTextView) TextView valueTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
