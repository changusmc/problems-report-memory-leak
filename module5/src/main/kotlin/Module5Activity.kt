package com.pinterest.memoryleak.module5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module5Activity : AppCompatActivity() {
    
    private lateinit var module5Service: Module5Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module5)
        
        module5Service = Module5Service()
        module5Service.doSomething()
    }
}

class Module5Service {
    fun doSomething(): String {
        return "module5 service is working"
    }
}
