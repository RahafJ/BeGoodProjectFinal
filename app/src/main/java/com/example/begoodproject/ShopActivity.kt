package com.example.begoodproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.begoodproject.databinding.ActivityShopBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.shop_item.*


class ShopActivity : AppCompatActivity() {

    private lateinit var dbref:  DatabaseReference

    private lateinit var rvShopitem :RecyclerView


    private lateinit var shopArrayList: ArrayList<ShopItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        rvShopitem=findViewById(R.id.rvShop)
        rvShopitem.layoutManager=LinearLayoutManager(this)

        rvShopitem.setHasFixedSize(true)

        shopArrayList = arrayListOf<ShopItem>()

        getShopItem()


    }// end on create

    private fun getShopItem() {
        dbref = FirebaseDatabase.getInstance().getReference("shopItem")
        dbref.addValueEventListener(object : ValueEventListener{


            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(shopSnapshot in snapshot.children){
                        val item = shopSnapshot.getValue(ShopItem::class.java)
                        shopArrayList.add(item!!)
                    }

                    rvShopitem.adapter=ShopAdapter(shopArrayList)
                }// end if

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

}