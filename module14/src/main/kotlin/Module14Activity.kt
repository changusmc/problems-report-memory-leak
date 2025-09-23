package com.pinterest.memoryleak.module14

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module14Activity : AppCompatActivity() {
    
    private lateinit var module14Service: Module14Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module14)
        
        module14Service = Module14Service()
        module14Service.doSomething()
    }
}

class Module14Service {
    fun doSomething(): String {
        return "module14 service is working"
    }
}
