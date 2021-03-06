package com.platzi.conf.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.platzi.conf.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(findViewById(R.id.tollbarMain))
        configNav()
    }
    fun configNav(){
        NavigationUI.setupWithNavController(bnMenu,Navigation.findNavController(this,R.id.fracContent))
    }
}
