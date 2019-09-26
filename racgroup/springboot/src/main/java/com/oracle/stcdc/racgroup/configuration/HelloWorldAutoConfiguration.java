package com.oracle.stcdc.racgroup.configuration;


import com.oracle.stcdc.racgroup.annotation.EnableHelloWorld;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration  // spring annotation
//@Import(HelloWorldConfiguration.class)
@EnableHelloWorld
public class HelloWorldAutoConfiguration {
}
