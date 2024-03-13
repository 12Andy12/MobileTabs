package com.example.tabs

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment


class ThirdFragment : Fragment()  {
    private val cities = arrayOf("Москва", "Токио", "Пекин", "Вашингтон")
    private val temperatures = arrayOf("-20", "+12", "-6", "-32")
    private val imgs = arrayOf(R.drawable.flag, R.drawable.flag_japan, R.drawable.flag_china, R.drawable.flag_usa)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_third, container, false)

        val table : TableLayout = TableLayout(view.context)

        val range = cities.size - 1
        for(i in 0..range){
            val city = TextView(view.context)
            val image = ImageView(view.context)
            val temperature = TextView(view.context)

            city.text = cities[i]
            city.setTextColor(Color.parseColor("#FFFFFF"))
            city.gravity = Gravity.CENTER
            city.textSize = 30F

            temperature.text = temperatures[i]
            temperature.setTextColor(Color.parseColor("#0F9D58"))
            temperature.gravity = Gravity.CENTER
            temperature.textSize = 30F


            image.setImageResource(imgs[i])
            val tableRow = TableRow(view.context)

            tableRow.addView(city, TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0F))
            tableRow.addView(image, TableRow.LayoutParams(100, 100, 1.0F))
            tableRow.addView(temperature, TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0F))

            table.addView(tableRow)
        }

        view as ViewGroup
        view.addView(table)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}