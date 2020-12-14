package com.unita.heistit.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unita.heistit.ItemsActivity
import com.unita.heistit.R
import com.unita.heistit.UserSession
import com.unita.heistit.models.get_items
import com.unita.heistit.models.get_order_temp
import kotlinx.android.synthetic.main.featured_items.view.*
import kotlinx.android.synthetic.main.get_order_temp.view.*

class order_temp_adapter(var context: Context, var list: ArrayList<get_order_temp>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v:View = LayoutInflater.from(context).inflate(R.layout.get_order_temp, parent, false)
        return order_temp_adapter.itemHolder(v)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as order_temp_adapter.itemHolder).bind(
                list[position].id,
                list[position].name,
                list[position].menus_name,
                list[position].price,
                list[position].quantity,
                list[position].mobile

        )

    }

    override fun getItemCount(): Int {
        return list.size

    }
    class itemHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        fun bind(i: Int, n: String, menus_name: String, price: Double, quantity:Int , mobile:String)
        {
            itemView.tv_name_order_temp.text=n
            itemView.tv_menus_name_order_temp.text=menus_name
            itemView.tv_price_order_temp.text=price.toString()
            itemView.tv_quantity_order_temp.text=quantity.toString()






        }
    }

}