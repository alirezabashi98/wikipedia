package com.example.wikipedia.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemPostModel(
    val ImageUrl: String,
    val Title: String,
    val Subtitle: String,
    val Detail: String,
    val isTrend: Boolean = false,
    val insight: String = ""
) : Parcelable
