package com.unita.heistit.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unita.heistit.QuantityFragment
import com.unita.heistit.R
import com.unita.heistit.UserSession
import com.unita.heistit.models.get_items
import kotlinx.android.synthetic.main.featured_items.view.*
import kotlinx.android.synthetic.main.get_items.view.*

class get_items_adapter(var context: Context, var list: ArrayList<get_items>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v:View = LayoutInflater.from(context).inflate(R.layout.get_items, parent, false)
        return itemHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as itemHolder).bind(
            list[position].item_name,
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
        fun bind(n: String, p: Double, u: String, get_items_id: Int)
        {
            itemView.name_item1.text=n
            itemView.price_item1.text=p.toString()
            Picasso.with(itemView.context).load(u).into(itemView.image_item)
           itemView.cart_item1.setOnClickListener()
            {
                   UserSession.get_items_id=get_items_id
                var obj = QuantityFragment()
                val manager = (itemView.context as FragmentActivity).supportFragmentManager
                //var manager=(itemView.context as Activity).support
                obj.show(manager, "Qty")
               //  var intent = Intent(itemView.getContext(), ItemsActivity::class.java)
              //  intent.putExtra("Id", itemView.tv_name_featured_items.text)
               // itemView.getContext().startActivity(intent)

            }




        }
    }

}

