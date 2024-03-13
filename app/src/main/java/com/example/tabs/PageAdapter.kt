package com.example.tabs

//import android.support.v4.app.Fragment
//import android.support.v4.app.FragmentPagerAdapter
//import android.support.v4.app.FragmentManager
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentManager

import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> {
                SecondFragment()
            }
            else -> {
                ThirdFragment()
            }
        }
    }
    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> {
                return "Third Tab"
            }
        }
    }
}



class NumberAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = tabNames.size

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment
        if(position == 0)
            fragment = FirstFragment()
        else if (position == 1)
        {
            fragment = SecondFragment()
        }

        else
            fragment = ThirdFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }

}