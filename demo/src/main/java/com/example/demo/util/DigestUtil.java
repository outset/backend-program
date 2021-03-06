package com.example.demo.util;


import com.example.demo.error.CommonErrorCode;
import com.example.demo.error.ErrorCodeException;
import org.apache.commons.codec.digest.DigestUtils;


public class DigestUtil {
    public static void checkDigest(String rawData, String sessionKey, String signature) {
        // 调用 apache 的公共包进行 SHA1 加密处理
        String sha1 = DigestUtils.sha1Hex((rawData + sessionKey).getBytes());
        boolean equals = sha1.equals(signature);
        if (!equals) {
            throw new ErrorCodeException(CommonErrorCode.SIGNATURE_ERROR);
        }
    }
}
