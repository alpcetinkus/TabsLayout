package com.example.tabslayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentList = ArrayList<Fragment>()
    private val fragmenTagtList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentList.add(fragment1())
        fragmentList.add(fragment2())
        fragmentList.add(fragment3())

        val adapter = MyViewPagerAdapter(this)
        viewPager2.adapter = adapter

        fragmenTagtList.add("One")
        fragmenTagtList.add("Two")
        fragmenTagtList.add("Three")

        TabLayoutMediator(tabLayout,viewPager2){ tab, position ->
            tab.setText(fragmenTagtList[position])
        }.attach()
    }


    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {

            return fragmentList.size

        }

        override fun createFragment(position: Int): Fragment {

            return fragmentList[position]

        }

    }
}