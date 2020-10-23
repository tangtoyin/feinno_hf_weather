package com.ucss.elementary.weather.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by HL on 2017/12/4.
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (context == null) {
            context = applicationContext;
        }
    }


    //通过name获取Bean.
    public static <T> T getBean(String beanName) {
        if (context.containsBean(beanName)) {
            return (T) context.getBean(beanName);
        } else {
            return null;
        }
    }

    //根据Type获取Bean
    public static <T> T getBeansOfType(Class<T> clazz) {
        return context.getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }
}