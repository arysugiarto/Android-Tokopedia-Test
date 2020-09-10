package com.tokopedia.filter.view;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.tokopedia.filter.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater = null;
    public Resources res;

    public ContactAdapter(Activity activity, ArrayList<HashMap<String, String>> data) {
        this.data = data;
        inflater = LayoutInflater.from(activity);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, final int position) {
        String name = data.get(position).get("name");
        String priceInt = data.get(position).get("priceInt");
        String city = data.get(position).get("city");

//        String image = data.get(position).get("imageUrl");
//        Glide.with(getContext())
//                .load("imageUrl")
//                .centerCrop()
//                .crossFade()
//                .into(flag);

        holder.tvName.setText(name);
        holder.tvPrice.setText(priceInt);
        holder.tvCity.setText(city);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice,tvCity;

        ContactViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.title);
            tvPrice = itemView.findViewById(R.id.price);
            tvCity = itemView.findViewById(R.id.lokasi);
        }
    }
}
