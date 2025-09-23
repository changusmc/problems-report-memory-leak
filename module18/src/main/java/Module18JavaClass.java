package com.pinterest.memoryleak.module18;

public class Module18JavaClass {
    
    private Module18JavaService javaService;
    
    public Module18JavaClass() {
        this.javaService = new Module18JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
