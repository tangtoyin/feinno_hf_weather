package com.ucss.elementary.tnwn.aspect;

import java.lang.annotation.*;

/**
 * @author smile
 * 自定义注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CmsPermission {
    String value() default "";
}