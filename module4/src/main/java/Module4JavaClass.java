package com.pinterest.memoryleak.module4;

public class Module4JavaClass {
    
    private Module4JavaService javaService;
    
    public Module4JavaClass() {
        this.javaService = new Module4JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
