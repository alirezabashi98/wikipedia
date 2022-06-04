package com.example.wikipedia

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.ExploreFragment
import com.example.wikipedia.fragments.ProfileFragment
import com.example.wikipedia.fragments.TrendFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)

        firstRun()

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
            when (it.itemId) {
                R.id.menu_explore -> {
                    replaceFragment(ExploreFragment())
                }
                R.id.menu_trend -> {
                    replaceFragment(TrendFragment())
                }
                R.id.menu_profile -> {
                    replaceFragment(ProfileFragment())
                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    private fun firstRun(){
        replaceFragment(ExploreFragment())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
    }
}