package com.example.begoodproject

import android.media.tv.TvView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.bill_item.view.*

class billAdabter(
    private var  billList:MutableList<bills>

):RecyclerView.Adapter<billAdabter.BilsViewHolder>(){

  class BilsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BilsViewHolder {
        return BilsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.bill_item,
                parent,
                false
            )
        )
    }


//    private fun toggleStrikeThrough(tvtime: TextView, tvValue:TextView, tvPoints: Int){
//
//    }

    fun addToBill(bill: bills){
        billList.add(bill)
        notifyItemInserted(billList.size-1)
    }



    override fun onBindViewHolder(holder: BilsViewHolder, position: Int) {
        val curBill = billList[position]
        holder.itemView.apply {
            tvtime.text = curBill.date.toString()
            tvValue.text = curBill.cost
            tvPoints.text= curBill.points.toString()
        }
    }

    override fun getItemCount(): Int {
        return billList.size
    }
}