package com.gustavo.bookstore.data.apimanager

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient(
    baseUrl: String,
) {
    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("$baseUrl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> createService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}
