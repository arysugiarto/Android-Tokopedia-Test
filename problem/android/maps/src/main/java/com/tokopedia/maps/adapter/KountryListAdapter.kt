package com.tokopedia.maps.adapter

import androidx.recyclerview.widget.RecyclerView
import com.tokopedia.maps.R
import com.tokopedia.maps.api.AppConstants
import com.tokopedia.maps.model.Kountry
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import com.squareup.picasso.Picasso
import com.tokopedia.maps.modul.KountryListHolder


class KountryListAdapter (val kountryList: ArrayList<Kountry>): RecyclerView.Adapter<KountryListHolder>() {
    var kountryListFiltered = kountryList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KountryListHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.kountry_list_cell, parent, false)
        return KountryListHolder(v)
    }

    override fun onBindViewHolder(holder: KountryListHolder, position: Int) {
        var kountry = kountryListFiltered[position]
        holder?.countryNameTV?.text = kountry.name
        holder?.capitalNameTV?.text = kountry.capital
        holder?.populate?.text = kountry.population.toString()
        Picasso
                .with(holder?.itemView?.context)
                .load(AppConstants.BASE_URL_FLAG + kountry.alpha2Code + ".png")
                .into(holder?.flagImageView)

    }

    override fun getItemCount(): Int {
        return kountryListFiltered.size
    }

    // perform the filtering when query is typed in search view
    fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                Log.d("MainAdapter", charString)

                //if query string is empty add all in filtered list
                if (charString.isEmpty()) {
                    kountryListFiltered = kountryList
                } else {
                    var filteredList = ArrayList<Kountry>()
                    for (row in kountryList) {
                        // if found query string add country in filtered lsit
                        if (row.name.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList!!.add(row)
                        }
                    }

                    kountryListFiltered = filteredList
                }

                val filterResults = FilterResults()
                filterResults.values = kountryListFiltered
                return filterResults
            }

            // call back for showing result
            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                kountryListFiltered = filterResults.values as ArrayList<Kountry>
                notifyDataSetChanged()
            }
        }
    }


}