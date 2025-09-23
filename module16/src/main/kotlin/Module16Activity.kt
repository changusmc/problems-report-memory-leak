package com.pinterest.memoryleak.module16

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module16Activity : AppCompatActivity() {
    
    private lateinit var module16Service: Module16Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module16)
        
        module16Service = Module16Service()
        module16Service.doSomething()
    }
}

class Module16Service {
    fun doSomething(): String {
        return "module16 service is working"
    }
}
