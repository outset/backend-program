package com.example.demo.controller;

import com.example.demo.annotation.UserAuthenticate;
import com.example.demo.annotation.UserInject;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class Wx_ShowTitles {

    @GetMapping({"/question/list", "/test/question/list"})
    @UserAuthenticate(permission = true)
    public List<String> get01(@UserInject User user, Integer page, Integer size) {
        log.info("get request from User {}", user);

        List<String> title = new ArrayList<>();
        title.add("A");
        title.add("B");
        System.out.print("title[0]:" + title.get(0));
        System.out.print("title[1]:" + title.get(1));
        return title;

    }

}