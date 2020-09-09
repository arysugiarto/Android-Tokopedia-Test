package com.tokopedia.maps.modul

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tokopedia.maps.R

class KountryListHolder(view: View): RecyclerView.ViewHolder(view) {
    var countryNameTV: TextView? = null
    var capitalNameTV: TextView? = null
    var flagImageView: ImageView? = null
    var populate: TextView? = null

    init {
        prepareView(view)
    }

    fun prepareView(view: View) {
        countryNameTV = view.findViewById<TextView>(R.id.country_name_text_view)
        capitalNameTV = view.findViewById<TextView>(R.id.capital_text_view)
        flagImageView = view.findViewById<ImageView>(R.id.flag_image_view)
        populate = view.findViewById(R.id.populate)

    }
}