package com.tokopedia.filter.view.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tokopedia.filter.R;

import java.util.ArrayList;
import java.util.HashMap;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder> {
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater = null;
    public Resources res;

    public FilterAdapter(Activity activity, ArrayList<HashMap<String, String>> data) {
        this.data = data;
        inflater = LayoutInflater.from(activity);
    }

    @Override
    public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FilterViewHolder holder, final int position) {
        String name = data.get(position).get("name");
        String priceInt = data.get(position).get("priceInt");
        String city = data.get(position).get("city");

//        String image = data.get(position).get("imageUrl");
//        Glide.with(getContext())
//                .load("imageUrl")
//                .centerCrop()
//                .crossFade()
//                .into(flag);

//        Glide.with(holder.itemView.getContext())
//                .load(activity.getApplicationContext().getResources().getIdentifier(data.get(position).get("imageUrl"), "assets", activity.getApplicationContext().getPackageName()))
//                .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_star_24)
//                        .error(R.drawable.ic_baseline_star_24))
//                .into(holder.imageView);

        holder.tvName.setText(name);
        holder.tvPrice.setText(priceInt);
        holder.tvCity.setText(city);
//        holder.Item.setText(image);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class FilterViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice,tvCity;

        FilterViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.title);
            tvPrice = itemView.findViewById(R.id.price);
            tvCity = itemView.findViewById(R.id.lokasi);
        }
    }
}
