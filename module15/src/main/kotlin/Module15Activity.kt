package com.pinterest.memoryleak.module15

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module15Activity : AppCompatActivity() {
    
    private lateinit var module15Service: Module15Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module15)
        
        module15Service = Module15Service()
        module15Service.doSomething()
    }
}

class Module15Service {
    fun doSomething(): String {
        return "module15 service is working"
    }
}
