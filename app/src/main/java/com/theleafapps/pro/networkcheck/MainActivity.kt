package com.theleafapps.pro.networkcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.theleafapps.pro.networkcheck.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var connectivityLiveData:ConnectivityLiveData
    private lateinit var activityMainBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        connectivityLiveData= ConnectivityLiveData(application)
        connectivityLiveData.observe(this, Observer {isAvailable->
            when(isAvailable)
            {
                true -> activityMainBinding.textView.text = "Connected with Internet"
                false -> activityMainBinding.textView.text = "No Network"
            }
        })
    }
}