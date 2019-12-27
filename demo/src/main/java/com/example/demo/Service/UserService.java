package com.example.demo.Service;

import com.example.demo.Model.User;
import org.springframework.stereotype.Service;

@Service("UserService")
public interface UserService {


    User insertSelective(User record);

    String selectByToken(String token);

}
