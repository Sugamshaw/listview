package com.sugam.trail12.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.sugam.trail12.R
import com.sugam.trail12.dataclass.User

class Adapter(val context: Activity,val arrayList: ArrayList<User>): ArrayAdapter<User>(context, R.layout.listview,arrayList){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater=LayoutInflater.from(context)
        val view=layoutInflater.inflate(R.layout.listview,parent,false)

        val imageid=view.findViewById<ImageView>(R.id.imageView)
        val name=view.findViewById<TextView>(R.id.name)
        val Description=view.findViewById<TextView>(R.id.Description)
        val time=view.findViewById<TextView>(R.id.time)

        imageid.setImageResource(arrayList[position].imageId)
        name.setText(arrayList[position].name)
        Description.setText(arrayList[position].description)
        time.setText(arrayList[position].time)


        return view
    }

}