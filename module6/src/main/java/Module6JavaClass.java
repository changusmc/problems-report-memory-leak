package com.pinterest.memoryleak.module6;

public class Module6JavaClass {
    
    private Module6JavaService javaService;
    
    public Module6JavaClass() {
        this.javaService = new Module6JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
