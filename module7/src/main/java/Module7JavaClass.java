package com.pinterest.memoryleak.module7;

public class Module7JavaClass {
    
    private Module7JavaService javaService;
    
    public Module7JavaClass() {
        this.javaService = new Module7JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
