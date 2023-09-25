package edu.temple.helloworld

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TextSizeAdapter(private val context: Context, private val textSizes: Array<Int>) : BaseAdapter (){


//    override fun getCount(): Int {
//        return textSizes.size
//    }
    override fun getCount() = textSizes.size

//    override fun getItem(position: Int): Any {
//        return textSizes[position]
//    }
    override fun getItem(position: Int) = textSizes[position]

//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return (getDropDownView(position, convertView, parent) as TextView).apply {
            textSize = 22f
        }

    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView: TextView

        if (convertView != null) {
            textView = convertView as TextView
        } else {
            textView = TextView(context)
            textView.setPadding(5, 10, 0, 10)
        }

        textView.text = textSizes[position].toString()
        textView.textSize = textSizes[position].toFloat()

        return textView
    }
}