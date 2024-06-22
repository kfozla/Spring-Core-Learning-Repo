package com.example.demo.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
class NormalClass{

}
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{

}
@Configuration
@ComponentScan
public class BeanScopesLauncher {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeanScopesLauncher.class)
        ){
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));



        }
    }
}
