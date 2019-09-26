package com.oracle.stcdc.racgroup.bootstrap;

import com.oracle.stcdc.racgroup.repository.MyFirstLevelRepository;
import com.oracle.stcdc.racgroup.repository.MySecondLevelRepository;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.oracle.stcdc.racgroup.repository")
public class RepositoryBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext conext = new SpringApplicationBuilder(RepositoryBootStrap.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE)
                .run(args);

        //JunheFirstLevelRepository 是否在
        MyFirstLevelRepository respository1 = conext.getBean("JunheFirstLevelRepository", MyFirstLevelRepository.class);

        System.out.println("MyFirstLevelRepository bean: " + respository1);
        respository1.print("hello, my first level repository");

        MySecondLevelRepository respository2 = conext.getBean("JunheSecondLevelRepository", MySecondLevelRepository.class);

        System.out.println("MySecondLevelRepository bean: " + respository2);
        respository2.print("hello, my second level repository");
        conext.close();
    }
}
