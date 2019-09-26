package com.oracle.stcdc.racgroup.repository;

import com.oracle.stcdc.racgroup.annotation.FirstLevelRepository;

@FirstLevelRepository(value = "JunheFirstLevelRepository")  //Bean的名称
public class MyFirstLevelRepository {

    public static void print(String s){
        System.out.println("MyFirstLevelRepository: = " + s);
    }
}
