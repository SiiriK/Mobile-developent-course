package com.example.listapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ItemAdapter(
    context: Context,
    private val items: Array<String>,
    private val prices: Array<String>,
    private val descriptions: Array<String>
) : BaseAdapter() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: mInflater.inflate(R.layout.my_listview_detail, parent, false)

        // Find the TextViews within the inflated layout
        val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        val priceTextView = view.findViewById<TextView>(R.id.priceTextView)

        // Set the data for each TextView
        nameTextView.text = items[position]
        descriptionTextView.text = descriptions[position]
        priceTextView.text = prices[position]

        return view
    }
}
