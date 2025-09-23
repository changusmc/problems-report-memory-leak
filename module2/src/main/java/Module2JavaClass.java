package com.pinterest.memoryleak.module2;

public class Module2JavaClass {
    
    private Module2JavaService javaService;
    
    public Module2JavaClass() {
        this.javaService = new Module2JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
