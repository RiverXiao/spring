package com.oracle.stcdc.racgroup.repository;


import com.oracle.stcdc.racgroup.annotation.SecondLevelRepository;

@SecondLevelRepository(value = "JunheSecondLevelRepository")
public class MySecondLevelRepository {

    public static void print(String s){
        System.out.println("JunheSecondLevelRepository: = " + s);
    }
}
