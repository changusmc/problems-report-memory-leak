package com.pinterest.memoryleak.module2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module2Activity : AppCompatActivity() {
    
    private lateinit var module2Service: Module2Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module2)
        
        module2Service = Module2Service()
        module2Service.doSomething()
    }
}

class Module2Service {
    fun doSomething(): String {
        return "module2 service is working"
    }
}
