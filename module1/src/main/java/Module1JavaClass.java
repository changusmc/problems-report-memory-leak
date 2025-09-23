package com.pinterest.memoryleak.module1;

public class Module1JavaClass {
    
    private Module1JavaService javaService;
    
    public Module1JavaClass() {
        this.javaService = new Module1JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
