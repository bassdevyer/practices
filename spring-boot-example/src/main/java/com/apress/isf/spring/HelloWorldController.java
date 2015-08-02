package com.apress.isf.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by seymourdiera on 31/07/2015.
 */
// Indicates that an annotated class is a "Controller" (e.g. a web controller).
@Controller
// Enable auto-configuration of the Spring Application Context
@EnableAutoConfiguration
public class HelloWorldController {

    /**
     * Annotation for mapping web requests onto specific handler classes and/or
     * handler methods. Provides a consistent style between Servlet and Portlet
     * environments, with the semantics adapting to the concrete environment.
     */
    @RequestMapping("/")
    /**
     * Annotation that indicates a method return value should be bound to the web
     * response body. Supported for annotated handler methods in Servlet environments.
     */
    @ResponseBody
    String getMessage() {
        return "<h1>Hello World!</h1>";
    }

    public static void main(String[] args) {
        /**
         * Static helper that can be used to run a SpringApplication from the
         * specified source using default settings.
         */
        SpringApplication.run(HelloWorldController.class, args);
    }

}
