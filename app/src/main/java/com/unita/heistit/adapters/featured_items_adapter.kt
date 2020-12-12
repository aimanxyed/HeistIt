package com.unita.heistit.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unita.heistit.ItemsActivity
import com.unita.heistit.R
import com.unita.heistit.UserSession
import com.unita.heistit.models.featured_items
import kotlinx.android.synthetic.main.featured_items.view.*

class featured_items_adapter(var context: Context, var list: ArrayList<featured_items>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       var v:View =LayoutInflater.from(context).inflate(R.layout.featured_items, parent, false)
        return itemHolder(v)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as itemHolder).bind(
            list[position].name,
            list[position].price,
            list[position].image,
            list[position].id
        )

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class itemHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
       fun bind(n: String, p: Double, u: String, featured_items_id: Int)
       {
           itemView.tv_name_featured_items.text=n
           itemView.tv_id_featured_items.text=featured_items_id.toString()
           itemView.tv_price_featured_items.text=p.toString()
           Picasso.with(itemView.context).load(u).into(itemView.iv_items_featured)
           itemView.iv_items_featured.setOnClickListener()
           {
               UserSession.featured_items_id=featured_items_id
               var intent = Intent(itemView.getContext(), ItemsActivity::class.java)
               intent.putExtra("Id", itemView.tv_name_featured_items.text)
               itemView.getContext().startActivity(intent)
           }




       }
    }

}