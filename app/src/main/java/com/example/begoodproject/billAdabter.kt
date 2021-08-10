package com.example.begoodproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class billAdabter (private val billList : ArrayList<bills>) : RecyclerView.Adapter<billAdabter.billsViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): billsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.bill_item,parent, false)
        return billsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: billsViewHolder, position: Int) {
        val currentItem = billList[position]

        holder.Date.text= currentItem.date.toString()
        holder.cost.text=currentItem.cost
        holder.points.text = currentItem.points.toString()



    }

    override fun getItemCount(): Int {
        return billList.size
    }

    class billsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Date: TextView = itemView.findViewById(R.id.tvtime)
        val cost :TextView = itemView.findViewById(R.id.tvValue)
        val points : TextView = itemView.findViewById(R.id.tvPoints)
    }

}