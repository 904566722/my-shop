package com.hhhqqq.my.shop.commons.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 获取 bean 实例
 * @ClassName SpringContext
 * @Description TODO
 * @Author HHQ
 * @Date 2020/3/30 14:55
 * @Version 1.0
 */
public final class SpringContext {

    public Object getBean(String beanId){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        return context.getBean(beanId);
    }
}
