package com.platzi.conf.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.platzi.conf.R
import kotlinx.android.synthetic.main.activity_splash_screenn.*


class SplashScreennActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animation = AnimationUtils.loadAnimation(this, R.anim.animation)
        val intend= Intent(this,MainActivity::class.java)
        setContentView(R.layout.activity_splash_screenn)
        ivlogoPlatziConf.startAnimation(animation)
        animation.setAnimationListener( object: Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(intend)
                finish()
            }

            override fun onAnimationStart(animation: Animation?) {

            }

        })
    }
}
