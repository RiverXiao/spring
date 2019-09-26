package com.oracle.stcdc.racgroup.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

/**
 * 初始化类
 * Order可以两种方式实现， 一是注释Order, 一个是实现Ordered接口
 */
@Order(HIGHEST_PRECEDENCE)
public class HelloWorldInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("Junhe_ HelloWorldInitializer: "  + applicationContext.getId());
    }
}
