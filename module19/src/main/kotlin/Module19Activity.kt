package com.pinterest.memoryleak.module19

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module19Activity : AppCompatActivity() {
    
    private lateinit var module19Service: Module19Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module19)
        
        module19Service = Module19Service()
        module19Service.doSomething()
    }
}

class Module19Service {
    fun doSomething(): String {
        return "module19 service is working"
    }
}
