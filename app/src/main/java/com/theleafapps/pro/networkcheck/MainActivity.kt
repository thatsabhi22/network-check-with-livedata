package com.theleafapps.pro.networkcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var connectivityLiveData:ConnectivityLiveData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectivityLiveData= ConnectivityLiveData(application)
        connectivityLiveData.observe(this, Observer {isAvailable->
            when(isAvailable)
            {
                true->true
//                true->textView.text="Connected with Internet"
//                false-> textView.text="No Network"
                else -> {}
            }
        })
    }
}