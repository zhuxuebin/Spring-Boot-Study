package com.spring.boot.annotation;

import com.spring.boot.entity.Book;
import com.spring.boot.entity.BookRack;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationAnnotationTests {

    @Autowired
    private Book book;

    @Autowired
    private BookRack bookRack;

    @Test
    public void testConfiguration() {
        //只需要看下book与bookRack.book是否为同一个实例就知道@Configuration里面的bean是否每次都是返回同一个实例
        Assert.assertEquals(book,bookRack.getBook());
    }

    @Test
    public void testComponent(){
        //只需要看下book与bookRack.book是否为同一个实例就知道@Component里面的bean是否每次都是返回不同的实例
        Assert.assertEquals(book,bookRack.getBook());
    }

}
