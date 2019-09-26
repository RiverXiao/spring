package com.oracle.stcdc.racgroup.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class HelloWorldListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("Junhe Listener: " + event.getSource());
    }
}
