package com.chandra.suitmediatest.ui.main

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.databinding.ActivityMainBinding
import com.chandra.suitmediatest.ui.home.HomeFragment
import com.chandra.suitmediatest.utils.InternetConnection

@RequiresApi(Build.VERSION_CODES.M)
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

        if(!InternetConnection.isOnline(this)){
            Toast.makeText(this, "Please Turn On Your Internet", Toast.LENGTH_LONG).show()
        }

    }





}