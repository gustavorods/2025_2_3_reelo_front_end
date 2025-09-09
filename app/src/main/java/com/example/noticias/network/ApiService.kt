package com.example.noticias.network
import retrofit2.http.GET
import com.example.noticias.data.News

interface ApiService {
    @GET("get-news")
    suspend fun getNews(): List<News>
}