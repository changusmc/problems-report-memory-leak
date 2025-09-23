package com.pinterest.memoryleak.module7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module7Activity : AppCompatActivity() {
    
    private lateinit var module7Service: Module7Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module7)
        
        module7Service = Module7Service()
        module7Service.doSomething()
    }
}

class Module7Service {
    fun doSomething(): String {
        return "module7 service is working"
    }
}
