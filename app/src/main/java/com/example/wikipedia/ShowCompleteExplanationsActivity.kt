package com.example.wikipedia

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wikipedia.databinding.ActivityShowCompleteExplanationsBinding
import com.example.wikipedia.fragments.Key_Send_Item_Post
import com.example.wikipedia.model.ItemPostModel
import com.example.wikipedia.utility.glideLoadImageUrl

class ShowCompleteExplanationsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowCompleteExplanationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowCompleteExplanationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarShowComplete)
        setSettingAppBar()
        setNewData()
    }

    private fun setSettingAppBar() {
        binding.collapsingToolBar.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun setNewData() {
        val data = intent.getParcelableExtra<ItemPostModel>(Key_Send_Item_Post)

        if (data != null) {
            glideLoadImageUrl(data.ImageUrl, binding.imgShowCompleteCollapsing)
//            supportActionBar!!.title = data.Title
            binding.txtTitle.text = data.Title
            binding.txtSubtitle.text = data.Subtitle
            binding.txtDescription.text = data.Detail
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return true
    }
}