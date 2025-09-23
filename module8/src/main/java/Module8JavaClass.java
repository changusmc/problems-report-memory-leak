package com.pinterest.memoryleak.module8;

public class Module8JavaClass {
    
    private Module8JavaService javaService;
    
    public Module8JavaClass() {
        this.javaService = new Module8JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
