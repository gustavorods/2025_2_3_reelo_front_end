package com.example.noticias.data

data class News(
    val id: String,
    val title: String,
    val description: String,
    val content: String,
    val url: String,
    val image: String,
    val publishedAt: String,
    val lang: String,
    val source: Source
)

data class Source(
    val id: String?,
    val name: String,
    val url: String,
    val country: String
)
