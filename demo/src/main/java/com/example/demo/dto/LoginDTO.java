package com.example.demo.dto;


import lombok.Data;

@Data
public class LoginDTO {
    // 用户信息原始数据
    private String rawData;

    // 用于验证用户信息是否被篡改过
    private String signature;
    // 用户获取 session_key 的 code
    private String code;
}
