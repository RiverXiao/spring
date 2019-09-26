package com.oracle.stcdc.racgroup;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.oracle.stcdc.racgroup.web.servlet")
public class SpringBootStrapStart {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootStrapStart.class);
        builder.web(WebApplicationType.NONE);
        builder.run(args);

    }
}
