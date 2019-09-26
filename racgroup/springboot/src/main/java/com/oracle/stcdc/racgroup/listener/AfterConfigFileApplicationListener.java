package com.oracle.stcdc.racgroup.listener;
/**
 * After {@link ConfigFileApplicationListener}
 */

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

public class AfterConfigFileApplicationListener implements Ordered, SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent > eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEventevent = (ApplicationEnvironmentPreparedEvent)event;
            Environment env = preparedEventevent.getEnvironment();
            System.out.println("Junhe_AfterConfigFileApplicationListener: " + env.getProperty("spring.datasource.raccdc.jdbcUrl"));
        }

    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
    }
}
