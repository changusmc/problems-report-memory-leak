package com.pinterest.memoryleak.module13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module13Activity : AppCompatActivity() {
    
    private lateinit var module13Service: Module13Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module13)
        
        module13Service = Module13Service()
        module13Service.doSomething()
    }
}

class Module13Service {
    fun doSomething(): String {
        return "module13 service is working"
    }
}
