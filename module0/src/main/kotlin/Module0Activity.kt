package com.pinterest.memoryleak.module0

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module0Activity : AppCompatActivity() {
    
    private lateinit var module0Service: Module0Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module0)
        
        module0Service = Module0Service()
        module0Service.doSomething()
    }
}

class Module0Service {
    fun doSomething(): String {
        return "module0 service is working"
    }
}
