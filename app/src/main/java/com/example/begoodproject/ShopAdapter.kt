package com.example.begoodproject

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.shop_item.view.*
import org.w3c.dom.Text

class ShopAdapter( val shopItem:ArrayList<ShopItem>):RecyclerView.Adapter<ShopAdapter.ShopViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopAdapter.ShopViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.shop_item,
        parent,false)
        return ShopViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:ShopViewHolder, position: Int) {
        val currentitem= shopItem[position]
        holder.aboutIt.text=currentitem.aboutIt
        holder.price.text = currentitem.price
        holder.points.text = currentitem.points
    }

    override fun getItemCount(): Int {
        return shopItem.size
    }

class ShopViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val aboutIt : TextView = itemView.findViewById(R.id.textView7)
    val price :Button = itemView.findViewById(R.id.button)
    val points : Button = itemView.findViewById(R.id.button2)
}
}
