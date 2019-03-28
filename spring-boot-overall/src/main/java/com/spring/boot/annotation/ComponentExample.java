package com.spring.boot.annotation;

import com.spring.boot.entity.Book;
import com.spring.boot.entity.BookRack;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName ConfigurationExample
 * @Description @Configuration注解测试
 *
 *
 * @Author xuery
 * @Date 2019/3/27 18:21
 * @Version 1.0
 */
@Component
public class ComponentExample {

    @Bean
    public Book newBook(){
        return new Book();
    }

    /**
     * 采用@Component注解，newBook()每次返回的都是不同的实例
     * @return
     */
    //写法1
    @Bean
    public BookRack newBookRack(){
        return new BookRack(newBook());
    }

    //写法2,这种写法book是同一个实例
//    @Bean
//    public BookRack newBookRack(Book book){
//        return new BookRack(book);
//    }
}
