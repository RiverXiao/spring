package com.oracle.stcdc.racgroup.web.template.thymeleaf;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.*;

public class ThymeleafTemplateBootstrap {

    public static void main(String[] args) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();

        Context context = new Context();
        context.setVariable("attr", "Hello Thymeleaf");
        //方法1： 直接给出模板的内容
        String content = "<p th:text=\"${attr}\">???</p> ";

        //方法2： 通过template file加载模板内容
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        //读取模板路径 classpath:templates/index.html
        Resource resouce = resourceLoader.getResource("classpath:templates/index.html");

        try {
            //获取模板内容
            File templateFile = resouce.getFile();
            FileInputStream inputStream = new FileInputStream(templateFile);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            content = outputStream.toString("UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 渲染模板，即把相应的变量输出到content
        String result = templateEngine.process(content, context);

        System.out.println(result);
    }
}
