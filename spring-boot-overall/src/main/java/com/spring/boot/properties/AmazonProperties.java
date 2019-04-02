package com.spring.boot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName AmazonProperties
 * @Description TODO
 * @Author xuery
 * @Date 2019/4/1 18:18
 * @Version 1.0
 */
@Component
@ConfigurationProperties("amazon") //注入带amazon前缀的属性
public class AmazonProperties {

    private String associateId;

    //set方法会自动注入amazon.associateId
    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    public String getAssociateId() {
        return associateId;
    }
}
