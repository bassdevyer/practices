package com.apress.isf.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by seymourdiera on 31/07/2015.
 */

@Configuration
// Indicates that a class declares one or more @Bean methods and may be processed by the Spring container
// to generate bean definitions and service requests for those beans at runtime
@ComponentScan
// Configures component scanning directives for use with @Configuration classes.
// Provides support parallel with Spring XML's <context:component-scan> element.
public class Application {

    // Indicates that a method produces a bean to be managed by the Spring container.
    @Bean
    MessageService helloWorldMessageService(){
        //This simple example defines an interface. In the main class, you are injecting its implementation by using the
//        @Bean annotation over the helloWorldMessageService method. This will tell the Spring Framework container that
//        the HelloWorldMessage class is the implementation and it will be used at some point.
        return new HelloWorldMessage();
    }

    public static void main(String[] args){
        // Central interface to provide configuration for an application.
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        // Standalone application context, accepting annotated classes as input

        // Return the bean instance that uniquely matches the given object type, if any.
        MessageService service = context.getBean(MessageService.class);

        System.out.println(service.getMessage());

    }
}
