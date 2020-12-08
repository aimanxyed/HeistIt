package com.unita.heistit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            var mobile:String=tv_mobileno.text.toString().toString()
            var url:String="http://192.168.100.201/HeistIt/search_user.php?mobile="+mobile
            var rq:RequestQueue=Volley.newRequestQueue(this)
            var sr=StringRequest(Request.Method.GET, url, {
                response ->
                if (response.equals("0"))
                {
                    Toast.makeText(this, "Mobile no not exists", Toast.LENGTH_LONG).show()
                }
                else
                {
                    UserSession.mobile=mobile
                    Toast.makeText(this, "Loggedin successfully", Toast.LENGTH_LONG).show()
                    var i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                }

            },
                {
                    error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
                })
            rq.add(sr)
        }



























        tv_signup.setOnClickListener {
            var i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }


    }
}