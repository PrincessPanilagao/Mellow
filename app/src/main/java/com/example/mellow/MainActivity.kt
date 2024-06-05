package com.example.mellow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.screenDisplay)
        tabLayout = findViewById(R.id.navbar)

        // Adapter variable works as an array
        val adapter = ViewPagerAdapter(this)
        // adding fragment to an array
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(InstructionsFragment(), "Instructions")
        adapter.addFragment(ProfileFragment(), "Profile")

        viewPager.adapter = adapter

        // List of icons for the tab bar (default/selected)
        val tabIcons = listOf(
            R.drawable.tab_home_selector,
            R.drawable.tab_info_selector,
            R.drawable.tab_profile_selector
        )

        // Placing the icons in the navbar
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(tabIcons[position])
        }.attach()
    }

    // Class for changing screen displays
    class ViewPagerAdapter(fragmentActivity: AppCompatActivity) : FragmentStateAdapter(fragmentActivity) {
        private val fragments = ArrayList<Fragment>()
        private val fragmentTitles = ArrayList<String>()

        fun addFragment(fragment: Fragment, title:String) {
            fragments.add(fragment)
            fragmentTitles.add(title)
        }

        // Built-in Functions
        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]

        fun getPageTitle(position: Int): String = fragmentTitles[position]
    }
}