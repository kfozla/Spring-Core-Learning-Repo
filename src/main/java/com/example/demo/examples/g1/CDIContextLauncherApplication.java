package com.example.demo.examples.g1;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import jakarta.inject.Named;

import java.util.Arrays;

//@Component
@Named
class BusinessService{
    private DataService dataService;
    //@Autowired
    @Inject
    public void setDataService(DataService dataService){
        this.dataService=dataService;
    }

    public DataService getDataService(){
        System.out.println("Setter Injection");
        return dataService;
    }

}
//@Component
@Named
class DataService{

}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class)
        ){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
