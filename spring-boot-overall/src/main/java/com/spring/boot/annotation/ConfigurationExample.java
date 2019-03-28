package com.spring.boot.annotation;

import com.spring.boot.entity.Book;
import com.spring.boot.entity.BookRack;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ConfigurationExample
 * @Description @Configuration注解测试
 *
 *
 * @Author xuery
 * @Date 2019/3/27 18:21
 * @Version 1.0
 */
//@Configuration
public class ConfigurationExample {

    @Bean
    public Book newBook(){
        return new Book();
    }

    /**
     * 采用@Configuration注解，newBook()每次返回的都是同一个实例
     * @return
     */
    //写法1
    @Bean
    public BookRack newBookRack(){
        return new BookRack(newBook());
    }

    //写法2
//    @Bean
//    public BookRack newBookRack(Book book){
//        return new BookRack(newBook());
//    }
}
