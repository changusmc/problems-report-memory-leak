package com.pinterest.memoryleak.module14;

public class Module14JavaClass {
    
    private Module14JavaService javaService;
    
    public Module14JavaClass() {
        this.javaService = new Module14JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
