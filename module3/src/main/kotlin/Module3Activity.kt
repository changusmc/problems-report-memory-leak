package com.pinterest.memoryleak.module3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module3Activity : AppCompatActivity() {
    
    private lateinit var module3Service: Module3Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module3)
        
        module3Service = Module3Service()
        module3Service.doSomething()
    }
}

class Module3Service {
    fun doSomething(): String {
        return "module3 service is working"
    }
}
