package com.pinterest.memoryleak.module12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module12Activity : AppCompatActivity() {
    
    private lateinit var module12Service: Module12Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module12)
        
        module12Service = Module12Service()
        module12Service.doSomething()
    }
}

class Module12Service {
    fun doSomething(): String {
        return "module12 service is working"
    }
}
