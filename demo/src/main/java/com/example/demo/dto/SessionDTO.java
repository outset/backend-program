package com.example.demo.dto;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;


@Data
public class SessionDTO {
    private String openid;

    @JSONField(name = "session_key")
    private String sessionKey;
}