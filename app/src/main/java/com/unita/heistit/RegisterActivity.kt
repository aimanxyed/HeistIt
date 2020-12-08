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
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_Reg.setOnClickListener {
            var name:String=tv_name.text.toString().toString()
            var email:String=tv_email.text.toString().toString()
            var mobile:String=tv_mobile.text.toString().toString()
            var address:String=tv_address.text.toString().toString()
            var url:String="http://192.168.100.201/HeistIt/add_user.php?name="+name + "&mobile="+mobile+"&email="+email+"&address="+address
            var rq:RequestQueue= Volley.newRequestQueue(this)
            var sr=StringRequest(Request.Method.GET, url,
                {
                    response ->
                    if(response.equals("0"))
                    {
                        Toast.makeText(this, "Mobile No already exists", Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        UserSession.mobile=mobile
                        Toast.makeText(this, "Registered successfully", Toast.LENGTH_LONG).show()
                        var i= Intent(this, MainActivity::class.java)
                        startActivity(i)
                    }
                },
                {
                    error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
                }
            )
            rq.add(sr)


        }
    }
}