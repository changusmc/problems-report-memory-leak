package com.pinterest.memoryleak.module5;

public class Module5JavaClass {
    
    private Module5JavaService javaService;
    
    public Module5JavaClass() {
        this.javaService = new Module5JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
