package com.example.tabs

import android.content.Context
import android.os.Bundle
//import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ListArrayAdapter(context: Context, resource: Int, objects: Array<String>) : ArrayAdapter<String>(context, resource, objects) {

    private var objs: Array<String> = arrayOf()

    init{
        objs = objects
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater :  LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val row : View = inflater.inflate(R.layout.image_view, parent, false)
        val text : TextView = row.findViewById(R.id.text)
        val image : ImageView = row.findViewById(R.id.image)

        text.text = objs[position]
        image.setImageResource(R.drawable.icon_min)

        return row
    }
}

class SecondFragment : Fragment() {

    val listSmth = arrayOf(
        "Безумно можно быть первым",
        "Делай как надо, как не надо не делай",
        "Работа не волк, работа это ворк, а волк это ходить",
        "Если волк молчит то лучше его не перебивать",
        "Лучше один раз упасть, чем сто раз упасть",
        "Запомните, твари, а то забудите",
        "Безумно можно быть последним"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter: ListArrayAdapter = ListArrayAdapter(view.context, android.R.layout.simple_list_item_1, listSmth)

        val listView : ListView = view.findViewById(R.id.list)
        listView.adapter = adapter
    }

}