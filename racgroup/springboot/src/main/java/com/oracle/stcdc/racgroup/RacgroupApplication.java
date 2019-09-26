package com.oracle.stcdc.racgroup;
/**
 * {@Link DispatcherServletAutoConfiguration}
 */

import com.oracle.stcdc.racgroup.service.ClusterService;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;
@SpringBootApplication(scanBasePackages = {"com.oracle.stcdc.racgroup"}, exclude = DataSourceAutoConfiguration.class)
//@SpringBootApplication(scanBasePackages = {"com.oracle.stcdc"})
public class RacgroupApplication {

    public static void main(String[] args) {

        Set<String> sources = new HashSet<String>();
        SpringApplication app  = new SpringApplication(RacgroupApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
//        app.addListeners(new ApplicationListener<ApplicationEvent>() {
//            @Override
//            public void onApplicationEvent(ApplicationEvent event) {
//                System.out.println("Junhe: ApplicationListener 事件监听器：" + event.getSource());
//            }
//        });
//        app.addInitializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {
//            @Override
//            public void initialize(ConfigurableApplicationContext applicationContext) {
//                System.out.println("Junhe: ApplicationContextInitializer 初始化器 ：" + applicationContext.getDisplayName());
//            }
//        });
        sources.add(ClusterService.class.getName());
        app.setSources(sources);
        ConfigurableApplicationContext context = app.run(args);
        System.out.println("Junhe: Get Bean : " + context.getBean(ClusterService.class));
//        context.close();
    }

}
