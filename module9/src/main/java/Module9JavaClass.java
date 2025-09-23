package com.pinterest.memoryleak.module9;

public class Module9JavaClass {
    
    private Module9JavaService javaService;
    
    public Module9JavaClass() {
        this.javaService = new Module9JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
