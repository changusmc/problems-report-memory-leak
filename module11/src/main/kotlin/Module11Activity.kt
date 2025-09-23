package com.pinterest.memoryleak.module11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module11Activity : AppCompatActivity() {
    
    private lateinit var module11Service: Module11Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module11)
        
        module11Service = Module11Service()
        module11Service.doSomething()
    }
}

class Module11Service {
    fun doSomething(): String {
        return "module11 service is working"
    }
}
