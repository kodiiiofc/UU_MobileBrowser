package com.kodiiiofc.urbanuniversity.mobilebrowser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridViewAdapter(
    private val list: List<GridViewModal>,
    private val context: Context
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var textTV: TextView
    private lateinit var imageIV: ImageView

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.gv_item, null)
        }
        imageIV = convertView!!.findViewById(R.id.iv_image)
        textTV = convertView.findViewById(R.id.tv_text)

        imageIV.setImageResource(list[position].image)
        textTV.text = list[position].name

        return convertView
    }

}