package com.spring.boot.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName Book
 * @Description TODO
 * @Author xuery
 * @Date 2019/3/27 16:18
 * @Version 1.0
 */
@Data
@Entity
public class Book implements Serializable{

    private static final long serialVersionUID = 1L;

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
