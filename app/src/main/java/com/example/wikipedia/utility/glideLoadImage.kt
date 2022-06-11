package com.example.wikipedia.utility

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.wikipedia.R

fun Context.glideLoadImageUrl(
    url: String,
    imageView: ImageView,
) = Glide.with(this).load(url).placeholder(R.drawable.loading).into(imageView)

fun Fragment.glideLoadImageUrl(
    url: String,
    imageView: ImageView
) = Glide.with(this).load(url).placeholder(R.drawable.loading).into(imageView)

fun Activity.glideLoadImageUrl(
    url: String,
    imageView: ImageView
) = Glide.with(this).load(url).placeholder(R.drawable.loading).into(imageView)
