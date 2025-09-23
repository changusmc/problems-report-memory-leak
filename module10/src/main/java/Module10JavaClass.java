package com.pinterest.memoryleak.module10;

public class Module10JavaClass {
    
    private Module10JavaService javaService;
    
    public Module10JavaClass() {
        this.javaService = new Module10JavaService();
    }
    
    public void doSomething() {
        javaService.performAction();
    }
}
