package com.unita.heistit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.core.content.ContextCompat

class SplashActivity : AppCompatActivity() {
    private val splash_time_out:Long=3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
       // window.setFlags(
        //  WindowManager.LayoutParams.FLAG_FULLSCREEN,
          //  WindowManager.LayoutParams.FLAG_FULLSCREEN
      //  )
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.pink))
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)



        }, splash_time_out)
    }
}