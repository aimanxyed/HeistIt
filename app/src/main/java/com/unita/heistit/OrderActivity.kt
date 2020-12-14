package com.unita.heistit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.unita.heistit.adapters.get_items_adapter
import com.unita.heistit.adapters.order_temp_adapter
import com.unita.heistit.models.get_items
import com.unita.heistit.models.get_order_temp
import kotlinx.android.synthetic.main.activity_items.*
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        var url:String="http://192.168.100.201/HeistIt/get_temp_order.php?mobile="+UserSession.mobile
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var list=ArrayList<get_order_temp>()
        var jar= JsonArrayRequest(
            Request.Method.GET,url, null, {
                response ->
            for (x in 0..response.length()-1)
            {
                list.add(
                    get_order_temp(
                        response.getJSONObject(x).getInt("id"),
                        response.getJSONObject(x).getString("name"),
                        response.getJSONObject(x).getString("menus_name"),
                        response.getJSONObject(x).getDouble("priceRangeMin"),
                        response.getJSONObject(x).getInt("quantity" ),
                        response.getJSONObject(x).getString("mobile")



                        )
                )

            }

            var adp= order_temp_adapter(this, list)
            rv_order_temp.layoutManager= LinearLayoutManager(this)
            rv_order_temp.adapter=adp
        },
            {
                    error ->
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            },
        )

        rq.add(jar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.item_menu)
        {
            var i =Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        else if (item.itemId==R.id.item_cancel)
        {
            var url_cancel:String="http://192.168.100.201/HeistIt/cancel_order.php?mobile="+UserSession.mobile
            var rq: RequestQueue = Volley.newRequestQueue(this)
            var sr = StringRequest(Request.Method.GET , url_cancel , {
                response ->

                var i = Intent(this, MainActivity::class.java)
                startActivity(i)


            },
                    {
                        error ->
                        Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
                    }
            )
            rq.add(sr)
        }
        else if (item.itemId==R.id.item_confirm)
        {
            var url_confirm:String="http://192.168.100.201/HeistIt/confirm_order.php?mobile="+UserSession.mobile
            var rq: RequestQueue = Volley.newRequestQueue(this)
            var sr = StringRequest(Request.Method.GET , url_confirm , {
                response ->

                var intent = Intent(this, TotalActivity::class.java)
                intent.putExtra("bno", response)
                startActivity(intent)


            },
                    {
                        error ->
                        Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
                    }
            )
            rq.add(sr)


        }

        return super.onOptionsItemSelected(item)
    }
}