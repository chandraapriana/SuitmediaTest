package com.chandra.suitmediatest.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.databinding.ActivityMainBinding
import com.chandra.suitmediatest.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding:ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        if(savedInstanceState == null){
            val homeFragment = HomeFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_main, homeFragment)
                .commit()
        }

    }


}