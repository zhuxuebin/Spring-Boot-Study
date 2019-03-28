package com.spring.boot.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName BookRack
 * @Description 书架实体类
 * @Author xuery
 * @Date 2019/3/27 18:23
 * @Version 1.0
 */
@Setter
@Getter
public class BookRack {

    private Book book;

    public BookRack(Book book){
        this.book = book;
    }


}
