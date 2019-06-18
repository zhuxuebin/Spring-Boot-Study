package com.spring.boot;

import com.spring.boot.bean.init.MySpringBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
//@ComponentScan
//@EnableAutoConfiguration
public class SpringBootOverallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOverallApplication.class, args);
    }


    @Bean(initMethod = "init")
    public MySpringBean mySpringBean(){
        return new MySpringBean();
    }
}
