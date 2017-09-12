package pb.coe.pbhackathon.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pb.coe.pbhackathon.R;
import pb.coe.pbhackathon.model.CountryDetailModel;

/**
 * Created by chetan on 11/09/17.
 * City List Adapter
 */

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder>{

    private List<CountryDetailModel> list;

    public CountryListAdapter(List<CountryDetailModel> list) {
        this.list = list;
    }

    @Override
    public CountryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.city_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CountryListAdapter.ViewHolder holder, int position) {
        CountryDetailModel model = list.get(position);
        holder.nameTextView.setText(model.name);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public void setList(List<CountryDetailModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.cityNameTextView);

        }
    }
}
