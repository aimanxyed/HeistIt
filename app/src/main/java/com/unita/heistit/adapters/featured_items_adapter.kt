package com.unita.heistit.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unita.heistit.R
import com.unita.heistit.models.featured_items
import kotlinx.android.synthetic.main.featured_items.view.*

class featured_items_adapter(var context:Context , var list:ArrayList<featured_items>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       var v:View =LayoutInflater.from(context).inflate(R.layout.featured_items, parent, false)
        return itemHolder(v)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as itemHolder).bind(list[position].name, list[position].price, list[position].image)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class itemHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
       fun bind(n:String, p:Double, u:String)
       {
           itemView.tv_name_featured_items.text=n
           itemView.tv_price_featured_items.text=p.toString()
           Picasso.with(itemView.context).load(u).into(itemView.iv_items_featured)

       }
    }

}