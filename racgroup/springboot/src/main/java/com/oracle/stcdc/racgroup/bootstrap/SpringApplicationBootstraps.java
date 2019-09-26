package com.oracle.stcdc.racgroup.bootstrap;


import com.oracle.stcdc.racgroup.configuration.HelloWorldConfiguration;
import com.oracle.stcdc.racgroup.listener.HelloWorldListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;

/**
 * Java spring 引导 类
 */
public class SpringApplicationBootstraps {

    public static void main(String[] args) {

//        SpringApplication.run(ApplicationConfiguration.class);
        Set<String> sources = new HashSet<>();
        sources.add(SpringApplicationBootstraps.class.getName());
        sources.add(HelloWorldConfiguration.class.getName());

        SpringApplication app = new SpringApplication();  //注意此处没有传入当前类
        app.setBannerMode(Banner.Mode.OFF);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.setSources(sources);    //使用sources来加载bean类

//        app.addInitializers(); // 此处不需要add, 可以在meta-inf中spring.factories进行配置
//        app.addListeners(); // 此处不需要add, 可以在meta-inf中spring.factories进行配置
//        app.addListeners(new HelloWorldListener());  //也可以按此方法添加
        List<String> stooges = Arrays.asList("Larry");
        ConfigurableApplicationContext context = app.run(args);
        String helloworld = context.getBean("helloworld", String.class);

        System.out.println("Helloworld Bean: = " + helloworld);

        context.close();
    }

    @SpringBootApplication
    public static class ApplicationConfiguration{

    }
}
