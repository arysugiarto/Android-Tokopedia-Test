package com.tokopedia.maps.api

import android.content.Context
import android.net.ConnectivityManager
import java.util.*

class AppConstants {
    companion object {
        // base url to get country information
        val BASE_URL = "https://restcountries.eu/"

        //base url for country flag
        val BASE_URL_FLAG = "https://raw.githubusercontent.com/emcrisostomo/flags/master/png/256/"

        fun isConnectedWithNetwork(context: Context): Boolean {

            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }

    }
}