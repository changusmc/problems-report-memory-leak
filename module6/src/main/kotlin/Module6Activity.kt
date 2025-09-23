package com.pinterest.memoryleak.module6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Module6Activity : AppCompatActivity() {
    
    private lateinit var module6Service: Module6Service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module6)
        
        module6Service = Module6Service()
        module6Service.doSomething()
    }
}

class Module6Service {
    fun doSomething(): String {
        return "module6 service is working"
    }
}
