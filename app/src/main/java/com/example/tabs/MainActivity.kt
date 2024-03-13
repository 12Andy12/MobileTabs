package com.example.tabs

import android.os.Bundle
import android.widget.ListView
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val adapter = MyAdapter(supportFragmentManager)
//        val viewPager = findViewById<ViewPager>(R.id.viewpager)
//        viewPager.adapter = adapter // устанавливаем адаптер
//        viewPager.currentItem = 1 // выводим второй экран (центр)
//    }
//
//
//}
val tabNames = arrayOf(
    "",
    "",
    ""
)

val tabIcons = arrayOf(
    R.drawable.icon_user,
    R.drawable.icon_menu,
    R.drawable.icon_weather
)

class MainActivity : FragmentActivity() {

    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = NumberAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter





        tabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNames[position]
            tab.setIcon(tabIcons[position])
        }.attach()

    }
}

//
//class MyAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {
//    override fun getCount(): Int {
//        return 3
//    }
//
//    override fun getItem(position: Int): Fragment {
//        return when (position) {
//            0 -> FirstFragment()
//            1 -> SecondFragment()
//            2 -> ThirdFragment()
//            else -> FirstFragment()
//        }
//    }
//}