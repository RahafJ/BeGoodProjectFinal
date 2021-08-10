package com.example.begoodproject

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class billAdabter (private val billList : ArrayList<bills>) : RecyclerView.Adapter<billAdabter.billsViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): billsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: billsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return billList.size
    }

    class billsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val date: TextView = itemView.findViewById(R.id.tvtime)
    }

}