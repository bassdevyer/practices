package com.apress.isf.spring;

/**
 * Created by seymourdiera on 31/07/2015.
 */
public class HelloWorldMessage implements MessageService{
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
