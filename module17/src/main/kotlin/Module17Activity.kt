package com.pinterest.memoryleak.module17

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module17Activity : AppCompatActivity() {
    
    private lateinit var module17Service: Module17Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module17)
        
        module17Service = Module17Service()
        module17Service.doSomething()
    }
}

class Module17Service {
    fun doSomething(): String {
        return "module17 service is working"
    }
}
