package com.example.testapplication.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R
import com.example.testapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configure()
    }

/*    private fun configure() {
        var check = false

        binding.textView.setOnClickListener {
//            binding.textView.text = "Text1".takeIf { check } ?: "Text2"
//            binding.textView.textSize = 100f.takeIf { check } ?: 200f
//            check = check.not()

            navigateHome()
        }
    }

    private fun navigateHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }*/

    private fun configure() {
        binding.viewPager.offscreenPageLimit = MainPagerAdapter.Tabs.values().size
        binding.viewPager.adapter = MainPagerAdapter(this)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeMenuItem -> {
                    binding.viewPager.setCurrentItem(
                        MainPagerAdapter.Tabs.HOME.ordinal,
                        true
                    )
                }

                R.id.settingsMenuItem -> {
                    binding.viewPager.setCurrentItem(
                        MainPagerAdapter.Tabs.SETTINGS.ordinal,
                        true
                    )
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}