package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class Wx_ShowTitles {

    @GetMapping({"/question/list", "/test/question/list"})
    public List<String> get01(Integer page, Integer size) {

        List<String> title = new ArrayList<String>();
        title.add("A");
        title.add("B");
        System.out.print("title[0]:" + title.get(0));
        System.out.print("title[1]:" + title.get(1));
        return title;

    }

}