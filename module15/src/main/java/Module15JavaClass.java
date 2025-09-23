package com.pinterest.memoryleak.module15;

public class Module15JavaClass {
    
    private Module15JavaService javaService;
    
    public Module15JavaClass() {
        this.javaService = new Module15JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
