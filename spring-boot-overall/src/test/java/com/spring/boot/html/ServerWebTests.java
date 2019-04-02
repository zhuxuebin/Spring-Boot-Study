package com.spring.boot.html;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * @ClassName ServerWebTests
 * @Description 代码清单4-6 在Spring Boot里使用Selenium测试的模板
 * @Author xuery
 * @Date 2019/4/2 20:29
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //随机端口号启动,新版本@SpringBootTest包含了很多之前的注解
public class ServerWebTests {

    @Value("${local.server.port}")
    private int port;

    private static ChromeDriver browser;

    @BeforeClass
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\chromeDriver2\\chromedriver.exe"); //注意chromedriver.exe与chrome对应的版本号
        browser = new ChromeDriver();
        String baseUrl = "https://www.google.com";
        browser.get(baseUrl);
        browser.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS); //等待10s，给启动一定的时间
    }

    @Test
    public void addBookToEmptyList(){
        String baseUrl = "http://localhost:" + port+"/readingList/zxb";

        browser.get(baseUrl); //获取主页

        assertEquals("You have no books in your book list",
                browser.findElementByTagName("div").getText());

        browser.findElementByName("title")
                .sendKeys("BOOK TITLE");
        browser.findElementByName("author")
                .sendKeys("BOOK AUTHOR");
        browser.findElementByName("isbn")
                .sendKeys("1234567890");
        browser.findElementByName("description")
                .sendKeys("DESCRIPTION");
        browser.findElementByTagName("form")
                .submit();

        //判断列表中是否有新书
        WebElement dl = browser.findElementByCssSelector("dt.bookHeadline");
        assertEquals("BOOK TITLE by BOOK AUTHOR (ISBN: 1234567890)",
                dl.getText());

        WebElement dt = browser.findElementByCssSelector("dd.bookDescription");
        assertEquals("DESCRIPTION", dt.getText());
    }

    @AfterClass
    public static void closeBrowser(){
        browser.quit(); //测试完毕，关闭浏览器
    }
}
