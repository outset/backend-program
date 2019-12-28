package com.example.demo.model;

import lombok.Data;

@Data
public class User {
    private String uid;

    private String openid;

    private String nickname;

    private String token;

    private String avatarurl;

    private Byte gender;
}