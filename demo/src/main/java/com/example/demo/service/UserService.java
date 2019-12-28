package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service("UserService")
public interface UserService {


    User insertSelective(User record);

    String selectByToken(String token);

}
