package com.spring.boot.controller;

import com.spring.boot.entity.Book;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @ClassName MockMvcWebTests
 * @Description TODO
 * @Author xuery
 * @Date 2019/4/2 14:54
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration //开启web上下文测试
public class MockMvcWebTests {

    @Autowired
    private WebApplicationContext webContext;

    private MockMvc mockMvc;

    //提前设置mockMvc
    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext)
                .apply(springSecurity()) //test中的请求也要通过Spring Security验证
                .build();
    }

    @Test
    public void homePage() throws Exception{
        mockMvc.perform(get("/readingList/zxb"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", is(empty())));
    }

    @Test
    public void postBook() throws Exception{
        mockMvc.perform(post("/readingList/zxb")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title","BOOK TITLE")
                .param("author","BOOK AUTHOR")
                .param("isbn","1234567890")
                .param("description","DESCRIPTION"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location","/readingList/zxb"));

        Book expectedBook = new Book();
        expectedBook.setId(1L);
        expectedBook.setReader("zxb");
        expectedBook.setTitle("BOOK TITLE");
        expectedBook.setAuthor("BOOK AUTHOR");
        expectedBook.setIsbn("1234567890");
        expectedBook.setDescription("DESCRIPTION");

        mockMvc.perform(get("/readingList/zxb"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books",hasSize(1)))
                .andExpect(model().attribute("books",contains(samePropertyValuesAs(expectedBook))));
    }

    @Test
    public void homePage_unauthenticatedUser() throws Exception{
        mockMvc.perform(get("/hello/hi")
                .param("name","zxb"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location","http://localhost/login"));
    }
}
