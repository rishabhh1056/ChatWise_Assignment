package com.example.learnapi.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.learnapi.R
import com.example.learnapi.retofit.Product
import com.squareup.picasso.Picasso

class RvAdapter(val context: Activity, val productArrayList: List<Product>):
RecyclerView.Adapter<RvAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachrow, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]

        holder.title.text = currentItem.title
        Picasso.get().load(currentItem.thumbnail).into(holder.img)
        holder.prize.text = currentItem.price.toString()
        holder.decs.text = currentItem.description
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title : TextView
        var  img: ImageView
        var prize: TextView
        var decs: TextView

        init {
            title = itemView.findViewById(R.id.title)
            img = itemView.findViewById(R.id.profile)
            prize = itemView.findViewById(R.id.prize)
            decs = itemView.findViewById(R.id.decs)
        }
    }
}