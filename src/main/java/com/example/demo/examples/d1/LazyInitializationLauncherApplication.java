package com.example.demo.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}
@Lazy
@Component
class ClassB{
    private ClassA classA;
    public ClassB(ClassA classA){
        System.out.println("Some Initialization logic");
        this.classA = classA;
    }
    public void doSomething(){
        System.out.println("Do something");

    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)
        ){
            System.out.println("initialization of context");
            context.getBean(ClassB.class).doSomething();
        }
    }
}
