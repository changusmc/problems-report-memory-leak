package com.pinterest.memoryleak.module17;

public class Module17JavaClass {
    
    private Module17JavaService javaService;
    
    public Module17JavaClass() {
        this.javaService = new Module17JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
