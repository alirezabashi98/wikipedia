package com.example.wikipedia.utility

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun Context.glideLoadImageUrl(
    url: String,
    imageView: ImageView
) = Glide.with(this).load(url).into(imageView)

fun Fragment.glideLoadImageUrl(
    url: String,
    imageView: ImageView
) = Glide.with(this).load(url).into(imageView)

fun Activity.glideLoadImageUrl(
    url: String,
    imageView: ImageView
) = Glide.with(this).load(url).into(imageView)
