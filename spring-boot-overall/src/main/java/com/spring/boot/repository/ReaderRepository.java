package com.spring.boot.repository;

import com.spring.boot.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName ReaderRepository
 * @Description TODO
 * @Author xuery
 * @Date 2019/3/27 20:37
 * @Version 1.0
 */
public interface ReaderRepository extends JpaRepository<Reader,String> {
}
