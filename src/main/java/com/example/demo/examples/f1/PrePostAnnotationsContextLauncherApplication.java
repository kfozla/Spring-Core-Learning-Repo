package com.example.demo.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private SomeDependency someDependency;
    public SomeClass(SomeDependency someDependency){
        this.someDependency = someDependency;
        System.out.println("all dependencies are ready");
    }

   @PostConstruct
    public void Initialize(){
        someDependency.getReady();
    }

    @PreDestroy
    public void CleanUp(){
        System.out.println("CleanUp");
    }

}
@Component
class SomeDependency{
    public void getReady(){
        System.out.println("Some Logic Using some dep");
    }

}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)
        ){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
