package com.pinterest.memoryleak.module12;

public class Module12JavaClass {
    
    private Module12JavaService javaService;
    
    public Module12JavaClass() {
        this.javaService = new Module12JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
