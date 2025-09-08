package com.example.noticias.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("url") // POR ENQUANTO SOMENTE RODANDO O BACK LOCALMENTE! ANTES DE UPAR COM A URL REAL É NECESSARIO PASSAR A AUTH KEY
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}