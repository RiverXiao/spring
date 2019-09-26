package com.oracle.stcdc.racgroup.listener;

import org.springframework.context.event.EventListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Junhe: First Listener started:  " + sce.getSource() );
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Junhe: First Listener destroyed:  " + sce.getSource() );
    }
}
