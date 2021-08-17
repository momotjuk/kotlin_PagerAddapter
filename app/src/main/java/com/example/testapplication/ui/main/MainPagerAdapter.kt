package com.example.testapplication.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testapplication.ui.home.HomeFragment
import com.example.testapplication.ui.settings.SettingsFragment

class MainPagerAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {

    enum class Tabs {
        HOME,
        SETTINGS
    }

    override fun getItemCount(): Int {
        return Tabs.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            Tabs.HOME.ordinal -> HomeFragment()
            Tabs.SETTINGS.ordinal -> SettingsFragment()
            else -> Fragment()
        }
    }
}