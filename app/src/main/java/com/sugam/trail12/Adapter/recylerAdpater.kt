package com.sugam.trail12.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sugam.trail12.databinding.ListviewBinding
import com.sugam.trail12.dataclass.User

class recylerAdapter(var context: Context, var reelList: ArrayList<User>): RecyclerView.Adapter<recylerAdapter.ViewHolder>(){

    inner class ViewHolder(var binding: ListviewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ListviewBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return reelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val imageid=findViewById<ImageView>(R.id.imageView)
//        val name=view.findViewById<TextView>(R.id.name)
//        val Description=view.findViewById<TextView>(R.id.Description)
//        val time=view.findViewById<TextView>(R.id.time)

        holder.binding.imageView.setImageResource(reelList[position].imageId)
        holder.binding.name.setText(reelList[position].name)
        holder.binding.Description.setText(reelList[position].description)
        holder.binding.time.setText(reelList[position].time)
    }

}