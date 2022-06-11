package com.example.wikipedia.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.wikipedia.R
import com.example.wikipedia.databinding.ActivityTranslatorBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TranslatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTranslatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTranslatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load(R.drawable.img_translatore)
            .transform(RoundedCornersTransformation(32, 8))
            .into(binding.imgTranslator)
    }
}