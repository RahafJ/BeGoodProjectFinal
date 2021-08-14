package com.example.begoodproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_bills_layout.*
import kotlinx.android.synthetic.main.bill_item.*


class BillsLayout : AppCompatActivity() {


private lateinit var recyclerView : RecyclerView
private lateinit var billAdabter: billAdabter

    var pointsYouHave :Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bills_layout)

        billAdabter= billAdabter(mutableListOf())
        rvBills.adapter = billAdabter

        rvBills.layoutManager=LinearLayoutManager(this)

        // add points to user

            btnAddBill.setOnClickListener {
            val value = etddbill . text . toString ();
            val billValue: Int = etddbill.text.toString().toInt()

             if(value.isEmpty()){
               Toast.makeText(baseContext,"Enter Your Bill Value",Toast.LENGTH_LONG).show()
           }else if(billValue<11)
            {
                pointsYouHave += 50;
            }else if (billValue<21 && billValue>=11){
                pointsYouHave += 40;
            }else if (billValue<31 && billValue>=21){
                pointsYouHave += 30;
            }else if (billValue<41 && billValue>=31){
                pointsYouHave += 20;
            }else if (billValue<51 && billValue>=41){
                pointsYouHave += 10;
            }else if (billValue>=51){
                pointsYouHave +=0 ;
            }
        Toast.makeText(baseContext,"Points you have it "+pointsYouHave,Toast.LENGTH_LONG).show();

                val pointsInLayout: String ="$pointsYouHave Points"
                if(value.isNotEmpty()){
                   val bill= bills("12-12-2021",value+"$",pointsInLayout)
                    billAdabter.addToBill((bill))

                }

            }


    }
}