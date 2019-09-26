package com.oracle.stcdc.racgroup.annotation;
/**
 * Hello world 实现${@link org.springframework.context.annotation.ImportSelector}
 */

import com.oracle.stcdc.racgroup.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{ HelloWorldConfiguration.class.getName()};
    }
}
