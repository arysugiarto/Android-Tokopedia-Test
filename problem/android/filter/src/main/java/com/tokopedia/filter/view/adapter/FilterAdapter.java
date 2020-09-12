package com.tokopedia.filter.view.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;
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


        Glide.with(holder.itemView.getContext())
                .load(data.get(position).get("imageUrl"))
                .into(holder.image);

        holder.tvName.setText(name);
        holder.tvPrice.setText(priceInt);
        holder.tvCity.setText(city);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class FilterViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice,tvCity;
        ImageView image;

        FilterViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.title);
            tvPrice = itemView.findViewById(R.id.price);
            tvCity = itemView.findViewById(R.id.lokasi);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
