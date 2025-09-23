package com.pinterest.memoryleak.module10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module10Activity : AppCompatActivity() {
    
    private lateinit var module10Service: Module10Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module10)
        
        module10Service = Module10Service()
        module10Service.doSomething()
    }
}

class Module10Service {
    fun doSomething(): String {
        return "module10 service is working"
    }
}
