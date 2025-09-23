package com.pinterest.memoryleak.module0;

public class Module0JavaClass {
    
    private Module0JavaService javaService;
    
    public Module0JavaClass() {
        this.javaService = new Module0JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
