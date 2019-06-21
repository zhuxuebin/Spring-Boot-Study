package com.spring.boot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName Book
 * @Description TODO
 * @Author xuery
 * @Date 2019/3/27 16:18
 * @Version 1.0
 */
@Setter
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reader;

    private String isbn;

    private String title;

    private String author;

    private String description;

//    private String version;


}
