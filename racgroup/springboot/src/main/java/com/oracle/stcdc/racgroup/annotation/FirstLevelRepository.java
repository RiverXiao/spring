package com.oracle.stcdc.racgroup.annotation;

/**
 *
 * 一级repsository {@link org.springframework.stereotype.Repository}
 */

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {

    String value() default "";
}
