package com.pinterest.memoryleak.module18

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module18Activity : AppCompatActivity() {
    
    private lateinit var module18Service: Module18Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module18)
        
        module18Service = Module18Service()
        module18Service.doSomething()
    }
}

class Module18Service {
    fun doSomething(): String {
        return "module18 service is working"
    }
}
