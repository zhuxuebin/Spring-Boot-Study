package com.spring.boot.controller;

import com.spring.boot.entity.Book;
import com.spring.boot.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author xuery
 * @Date 2019/3/27 16:27
 * @Version 1.0
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value ="/hi",method = RequestMethod.GET)
    @ResponseBody //必须加，不然会报错TemplateInputException
    public void readersBooks(@RequestParam(value = "name") String name){

        System.out.println("hi "+name);
    }

}
