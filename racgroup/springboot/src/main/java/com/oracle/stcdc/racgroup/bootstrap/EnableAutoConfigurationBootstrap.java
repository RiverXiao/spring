package com.oracle.stcdc.racgroup.bootstrap;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

/**
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration} create the bootstrap class
 */

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class EnableAutoConfigurationBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE)
                .run(args);


        String helloworld = context.getBean("helloworld", String.class);

        System.out.println("Helloworld Bean: = " + helloworld);

        int s = context.getBean("printint", Integer.class);

        System.out.println("printint Bean: = " + s);

        context.close();
    }





}
