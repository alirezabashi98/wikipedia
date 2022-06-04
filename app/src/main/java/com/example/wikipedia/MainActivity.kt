package com.example.wikipedia

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.wikipedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.darawLayoutMain,
            binding.toolbarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.darawLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navigationMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_writer -> {
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_photograph -> {
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_video_maker -> {
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_translator -> {
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_open_wikipedia -> {
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_open_wikiMedia -> {
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
            }
            true
        }

        binding.bottomNavigationMain.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_explore -> {}
                R.id.menu_trend -> {}
                R.id.menu_profile -> {}
            }
            true
        }

    }
}