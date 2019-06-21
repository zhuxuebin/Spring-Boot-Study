package com.spring.boot.redis;

import com.alibaba.fastjson.JSON;
import com.spring.boot.SpringBootOverallApplicationTests;
import com.spring.boot.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisSerializerTests
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/21 16:28
 * @Version 1.0
 */
public class RedisSerializerTests extends SpringBootOverallApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test_fastjson_serializer(){

        Book book = new Book();
        book.setId(123L);

//        redisTemplate.opsForValue().set("zxb", book);

        Book girl = (Book) redisTemplate.opsForValue().get("zxb");

        System.out.println();

    }
}
