package com.oracle.stcdc.racgroup.initializer;

/**
 * 初始化类
 * Order可以两种方式实现， 一是注释Order, 一个是实现Ordered接口
 */

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

public class LowpriorityInitializer implements ApplicationContextInitializer, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("Junhe_ LowpriorityInitializer: "  + applicationContext.getDisplayName());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
