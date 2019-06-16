package com.spring.boot.bean.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * https://www.cnblogs.com/redcool/p/6397398.html
 * Created by xuery on 2019/6/7.
 */
public class MySpringBean implements BeanNameAware, BeanFactoryAware,ApplicationContextAware,
        InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(MySpringBean.class);

    public MySpringBean(){
        logger.info("###1.new MySpringBean");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("###3.BeanNameAware-setBeanName......");
    }

    @Override
    public void setBeanName(String s) {
        logger.info("###2.BeanNameAware-setBeanName......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("###6.InitializingBean-afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("###4.ApplicationContextAware-setApplicationContext......");
    }

    public void init(){
        logger.info("###7.init-method......");
    }
}
