package com.pinterest.memoryleak.module1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module1Activity : AppCompatActivity() {
    
    private lateinit var module1Service: Module1Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module1)
        
        module1Service = Module1Service()
        module1Service.doSomething()
    }
}

class Module1Service {
    fun doSomething(): String {
        return "module1 service is working"
    }
}
