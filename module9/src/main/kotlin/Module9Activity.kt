package com.pinterest.memoryleak.module9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module9Activity : AppCompatActivity() {
    
    private lateinit var module9Service: Module9Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module9)
        
        module9Service = Module9Service()
        module9Service.doSomething()
    }
}

class Module9Service {
    fun doSomething(): String {
        return "module9 service is working"
    }
}
