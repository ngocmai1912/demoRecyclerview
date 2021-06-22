package com.nmai.fruit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class  ItemAdapter2(
    val context: Context
): ListAdapter<Item, ItemAdapter2.ItemViewHolder>(ItemAdapter2.ItemDiffUtil) {
    var onClick : (item: Item) -> Unit = {}
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var img : ImageView = view.findViewById(R.id.img_item)
        private var txtName : TextView = view.findViewById(R.id.txt_name_item)
        private var txtCost: TextView = view.findViewById(R.id.txt_cost_item)
        fun onBind(item: Item) {
            img.setImageResource(item.image)
            txtName.text = item.name
            txtCost.text = item.cost.toString()
            itemView.setOnClickListener{
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent,false)
        return ItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }


    object ItemDiffUtil : DiffUtil.ItemCallback<Item>() {

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

}