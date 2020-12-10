package com.unita.heistit

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.unita.heistit.adapters.featured_items_adapter
import com.unita.heistit.models.featured_items
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var url="http://192.168.100.201/HeistIt/get_categories.php"
        var rq:RequestQueue=Volley.newRequestQueue(this)
        var list=ArrayList<featured_items>()
        var jar=JsonArrayRequest(Request.Method.GET,url, null, {
            response ->
            for (x in 0..response.length()-1)
            {
                list.add(featured_items(
                        response.getJSONObject(x).getInt("id"),
                                response.getJSONObject(x).getString("name"),
                                        response.getJSONObject(x).getDouble("priceRangeMin"),
                                                response.getJSONObject(x).getString("image" )

                ))
            }
            var adp=featured_items_adapter(this, list)
            rv_featured_items.layoutManager=LinearLayoutManager(this)
            rv_featured_items.adapter=adp
        },
                {
                    error ->
                    Toast.makeText(this, error.message,Toast.LENGTH_LONG).show()
                },
        )
        rq.add(jar)

    }
}

