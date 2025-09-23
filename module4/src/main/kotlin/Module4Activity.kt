package com.pinterest.memoryleak.module4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module4Activity : AppCompatActivity() {
    
    private lateinit var module4Service: Module4Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module4)
        
        module4Service = Module4Service()
        module4Service.doSomething()
    }
}

class Module4Service {
    fun doSomething(): String {
        return "module4 service is working"
    }
}
