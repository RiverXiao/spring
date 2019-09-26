package com.stacdc.racgroup.springframework.servlet.support;

/**
 * 替换web.xml的引导类
 */

import com.stacdc.racgroup.springframework.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DefaultAnnotationConfigDisaptcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {  // web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {    // DispatcherServlet
        return new Class[]{DispatcherServletConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
