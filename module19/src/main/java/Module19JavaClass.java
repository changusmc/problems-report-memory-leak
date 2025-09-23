package com.pinterest.memoryleak.module19;

public class Module19JavaClass {
    
    private Module19JavaService javaService;
    
    public Module19JavaClass() {
        this.javaService = new Module19JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
