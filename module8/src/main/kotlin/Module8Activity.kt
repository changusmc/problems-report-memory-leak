package com.pinterest.memoryleak.module8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module8Activity : AppCompatActivity() {
    
    private lateinit var module8Service: Module8Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module8)
        
        module8Service = Module8Service()
        module8Service.doSomething()
    }
}

class Module8Service {
    fun doSomething(): String {
        return "module8 service is working"
    }
}
