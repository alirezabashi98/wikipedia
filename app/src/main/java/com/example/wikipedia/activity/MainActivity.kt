package com.example.wikipedia.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.wikipedia.R
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.ExploreFragment
import com.example.wikipedia.fragments.PhotographFragment
import com.example.wikipedia.fragments.ProfileFragment
import com.example.wikipedia.fragments.TrendFragment
import com.google.android.material.snackbar.Snackbar

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
                    SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setConfirmButton("ok") { sDialog ->
                            sDialog.dismissWithAnimation()
                        }
                        .setCancelButton(
                            "Cancel"
                        ) { sDialog ->
                            sDialog.dismissWithAnimation()
                        }
                        .show()
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_photograph -> {
                    replaceFragmentAddToBackState(PhotographFragment())
                    binding.navigationMain.menu.getItem(1).isChecked = true
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_video_maker -> {
                    Snackbar.make(binding.root, "You can Create Video!", Snackbar.LENGTH_SHORT)
                        .setAction("Retry") {}
                        .setBackgroundTint(ContextCompat.getColor(this, R.color.blue500))
                        .setActionTextColor(ContextCompat.getColor(this, R.color.white)).show()
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_translator -> {
                    startActivity(Intent(this, TranslatorActivity::class.java))
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_open_wikipedia -> {
                    openWebsite("https://wikipedia.org/")
                    binding.darawLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_open_wikiMedia -> {
                    openWebsite("https://www.wikimedia.org/")
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
            resetCheckMenuDrawable()
            true
        }

    }

    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun replaceFragment(fragment: Fragment) {
        clearAllFragmentInBackState()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    private fun replaceFragmentAddToBackState(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun clearAllFragmentInBackState() {
        val transaction = supportFragmentManager
        for (fragment in 0..(transaction.backStackEntryCount)) {
            transaction.popBackStack()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        resetCheckMenuDrawable()
    }

    private fun resetCheckMenuDrawable() {
        binding.navigationMain.menu.getItem(1).isChecked = false
    }

    private fun firstRun() {
        replaceFragment(ExploreFragment())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    @SuppressLint("ShowToast")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_exit -> {
                Snackbar.make(binding.root, "Sure you want to get out", Snackbar.LENGTH_LONG)
                    .setAction("Exit") {
                        finish()
                    }
                    .setActionTextColor(ContextCompat.getColor(this, R.color.white))
                    .setBackgroundTint(ContextCompat.getColor(this, R.color.blue500))
                    .show()
            }
        }
        return true
    }
}