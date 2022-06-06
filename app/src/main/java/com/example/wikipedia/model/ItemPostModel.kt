package com.example.wikipedia.model

data class ItemPostModel(
    val ImageUrl: String,
    val Title: String,
    val Subtitle: String,
    val Detail: String,
    val isTrend: Boolean = false,
    val insight: String = ""
)
