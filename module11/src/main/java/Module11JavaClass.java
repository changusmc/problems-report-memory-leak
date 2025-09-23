package com.pinterest.memoryleak.module11;

public class Module11JavaClass {
    
    private Module11JavaService javaService;
    
    public Module11JavaClass() {
        this.javaService = new Module11JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
