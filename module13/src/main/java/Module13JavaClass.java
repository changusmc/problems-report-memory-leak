package com.pinterest.memoryleak.module13;

public class Module13JavaClass {
    
    private Module13JavaService javaService;
    
    public Module13JavaClass() {
        this.javaService = new Module13JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
