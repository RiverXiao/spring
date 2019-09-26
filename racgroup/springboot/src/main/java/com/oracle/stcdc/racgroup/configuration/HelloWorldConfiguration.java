package com.oracle.stcdc.racgroup.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean("helloworld")
    public String hellworld() {
        return "Hello world 2019";
    }

    @Bean("printint")
    public Integer printInt(){
        return 2019;
    }
}
