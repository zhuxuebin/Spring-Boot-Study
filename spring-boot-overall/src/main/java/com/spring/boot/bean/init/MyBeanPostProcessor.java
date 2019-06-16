package com.spring.boot.bean.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * Created by xuery on 2019/6/7.
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

    private final Logger logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof  MySpringBean) {
            logger.info("###5.BeanPostProcessor-postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof  MySpringBean) {
            logger.info("###8.BeanPostProcessor-postProcessAfterInitialization");
        }
        return bean;
    }
}
