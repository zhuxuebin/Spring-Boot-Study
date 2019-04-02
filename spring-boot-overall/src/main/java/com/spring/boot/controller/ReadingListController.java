package com.spring.boot.controller;

import com.spring.boot.entity.Book;
import com.spring.boot.properties.AmazonProperties;
import com.spring.boot.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ReadingListController
 * @Description TODO
 * @Author xuery
 * @Date 2019/3/27 16:27
 * @Version 1.0
 */
@Controller
@RequestMapping("/readingList")
public class ReadingListController {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Autowired
    private AmazonProperties amazonProperties;

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {

        List<Book> bookList = readingListRepository.findByReader(reader);
        if (!CollectionUtils.isEmpty(bookList)) {
            model.addAttribute("books", bookList);
        }

        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}"; //会跳转请求到readersBooks方法
    }

}
