package com.tokopedia.maps.api

import com.tokopedia.maps.model.Kountry
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("rest/v2/all")
    fun getAllKountries(): Observable<ArrayList<Kountry>>

//    @GET("rest/v2/alpha/{code}")
//    fun getKountry(@Path("code") alpha2Code: String): Observable<Kountry>

    companion object Factory {
        fun create(): ApiClient {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(AppConstants.BASE_URL)
                    .build()

            return retrofit.create(ApiClient::class.java)
        }
    }
}