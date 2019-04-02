package com.spring.boot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.fail;

/**
 * @ClassName SimpleWebTest
 * @Description 测试运行在服务器里的Web应用程序
 * @Author xuery
 * @Date 2019/4/2 20:13
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleWebTest {

    @Test(expected= HttpClientErrorException.class)
    public void pageNotFound() {
        try {
            RestTemplate rest = new RestTemplate();
            rest.getForObject(
                    "http://localhost:8080/bogusPage", String.class);
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
            throw e;
        }
    }
}
