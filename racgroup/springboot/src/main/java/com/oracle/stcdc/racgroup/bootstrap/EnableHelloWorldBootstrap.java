package com.oracle.stcdc.racgroup.bootstrap;

import com.oracle.stcdc.racgroup.annotation.EnableHelloWorld;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        SpringApplicationBuilder build = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class);

        build.bannerMode(Banner.Mode.OFF);
        build.web(WebApplicationType.NONE);

        build.run(args);

        ConfigurableApplicationContext context = build.context();

        String helloworld = context.getBean("helloworld", String.class);

        System.out.println("Helloworld Bean: = " + helloworld);

        int s = context.getBean("printint", Integer.class);

        System.out.println("printint Bean: = " + s);

        context.close();
    }
}
