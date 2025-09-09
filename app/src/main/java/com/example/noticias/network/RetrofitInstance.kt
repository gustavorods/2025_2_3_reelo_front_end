package com.example.noticias.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://2025-2-3-reelo-backend.vercel.app/api/news/"  // substitua pela URL da sua API
    private const val API_KEY = "" // sua chave de auth

    private val client = OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val original: Request = chain.request()
            val request: Request = original.newBuilder()
                .header("x-api-key", API_KEY) // aqui você passa sua chave
                .build()
            chain.proceed(request)
        })
        .connectTimeout(30, java.util.concurrent.TimeUnit.SECONDS) // tempo para conectar
        .readTimeout(60, java.util.concurrent.TimeUnit.SECONDS)    // tempo para ler a resposta
        .writeTimeout(60, java.util.concurrent.TimeUnit.SECONDS)   // tempo para enviar a requisição
        .build()

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)  // conecta o client com o interceptor
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
