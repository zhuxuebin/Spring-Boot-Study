package com.spring.boot.repository;

import com.spring.boot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ReadingListRepository
 * @Description TODO
 * @Author xuery
 * @Date 2019/3/27 16:25
 * @Version 1.0
 */
public interface ReadingListRepository extends JpaRepository<Book,Long> {

    List<Book> findByReader(String reader);
    
}
