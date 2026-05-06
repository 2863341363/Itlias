package com.yangzhong.itlias.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Component
public class JWT {

    private static SecretKey secretKey;
    private static  long expirationTime;

    /**
     * 构造 JWT 工具类。
     * 作用：
     * 1. 读取配置文件中的密钥。
     * 2. 把字符串密钥转换成 JJWT 可用的加密密钥对象。
     * 3. 读取 token 的过期时间配置。
     *
     * @param secret 配置文件中的 JWT 密钥
     * @param expirationTime token 过期时间，单位是毫秒
     */
    public JWT(@Value("${jwt.secret-key}") String secret,
               @Value("${jwt.expiration-time}") long expirationTime) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationTime = expirationTime;
    }

    /**
     * 生成 JWT 字符串。
     *
     * @param id 用户 id
     * @param username 用户名
     * @param name 姓名
     * @return 生成后的 JWT 字符串
     */
    public static String generateToken(Integer id, String username, String name) {
        Instant now = Instant.now();
        return Jwts.builder()
                .claim("id", id) // 把用户 id 保存到 JWT 载荷中
                .claim("username", username) // 把用户名保存到 JWT 载荷中
                .claim("name", name) // 把姓名保存到 JWT 载荷中
                .issuedAt(Date.from(now)) // 设置 token 的签发时间
                .expiration(Date.from(now.plusMillis(expirationTime))) // 设置 token 的过期时间
                .signWith(secretKey) // 使用密钥进行签名，防止 token 被篡改
                .compact(); // 把前面的头、载荷、签名压缩成最终的 JWT 字符串
    }

    /**
     * 解析 JWT 字符串并返回 Claims。
     * 作用：
     * 1. 校验 token 签名是否正确。
     * 2. 校验 token 是否过期。
     * 3. 解析出 token 中保存的载荷数据。
     * 如果 token 非法或者已过期，JJWT 会直接抛出异常。
     *
     * @param token 前端传入的 JWT 字符串
     * @return 解析后的 Claims 对象
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(secretKey) // 指定验签时使用的密钥
                .build() // 创建解析器对象
                .parseSignedClaims(token) // 解析 JWT，并校验签名和过期时间
                .getPayload(); // 取出 JWT 中保存的载荷数据
    }
}
