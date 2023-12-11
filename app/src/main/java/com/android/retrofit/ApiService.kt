package com.android.retrofit

import com.android.retrofit.data.Ticker
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("public/ticker/{order_currency}_{payment_currency}")
       fun getCoinTicker(
            @Path("order_currency") orderCurrency: String,
            @Path("payment_currency") paymentCurrency: String
        ): Call<Ticker>
}
