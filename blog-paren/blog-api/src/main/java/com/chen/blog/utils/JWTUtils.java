package com.chen.blog.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JWTUtils
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/22 14:32
 */
public class JWTUtils {
    private static final String jwtToken = "123456xiaochenzlu!@#$$";

    public static String createToken(Long userId) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken)//签发算法，私钥为jwtToken
                .setClaims(claims)//body数据，要唯一，自行设置
                .setIssuedAt(new Date())//设置签发时间
                //一天的有效时间
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 60 * 60 * 1000));
        String token = jwtBuilder.compact();
        return token;

    }

    public static Map<String, Object> checkToken(String token) {
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String token = JWTUtils.createToken(100L);
        System.out.println(token);
        Map<String, Object> map = JWTUtils.checkToken(token);
        System.out.println(map.get("userId"));
    }
}
