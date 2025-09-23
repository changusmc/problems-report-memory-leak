package com.pinterest.memoryleak.module16;

public class Module16JavaClass {
    
    private Module16JavaService javaService;
    
    public Module16JavaClass() {
        this.javaService = new Module16JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
