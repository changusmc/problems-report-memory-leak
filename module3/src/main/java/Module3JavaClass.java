package com.pinterest.memoryleak.module3;

public class Module3JavaClass {
    
    private Module3JavaService javaService;
    
    public Module3JavaClass() {
        this.javaService = new Module3JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
