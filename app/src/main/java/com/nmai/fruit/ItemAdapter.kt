package com.nmai.fruit

import android.content.Context
import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ItemAdapter(
    val context: Context
) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    var onClick : (item: Item) -> Unit = {}
    var listItem = mutableListOf<Item>()

    inner class ItemHolder(val view : View) : RecyclerView.ViewHolder(view){
        private var img : ImageView = view.findViewById(R.id.img_item)
        private var txtName : TextView = view.findViewById(R.id.txt_name_item)
        private var txtCost: TextView = view.findViewById(R.id.txt_cost_item)

        fun bind(item: Item){
            img.clipToOutline = true
            img.setImageResource(item.image)
            txtName.text = item.name
            txtCost.text = item.cost.toString()
            itemView.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent,false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        return holder.bind(listItem[listItem.size-1- position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    fun addAll(list : List<Item>){
        listItem.clear()
        listItem.addAll(list)
        notifyDataSetChanged()
    }

    fun change(item : Item){
        item.name = "a"
        notifyDataSetChanged()
    }

}