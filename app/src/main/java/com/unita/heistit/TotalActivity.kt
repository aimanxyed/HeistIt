package com.unita.heistit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_total.*

class TotalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)



        var url_confirm:String="http://192.168.100.201/HeistIt/total.php?bill_no="+intent.getStringExtra("bno")
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var sr = StringRequest(
            Request.Method.GET , url_confirm , {
                response ->

           tv_total_rs.text=response


        },
            {
                    error ->
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            }
        )
        rq.add(sr)
    }
}