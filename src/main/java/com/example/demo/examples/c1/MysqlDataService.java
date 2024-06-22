package com.example.demo.examples.c1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MysqlDataService implements DataService{
    public int [] retrieveData(){
        return new int[] {1,2,3,4,5};
    }
}
