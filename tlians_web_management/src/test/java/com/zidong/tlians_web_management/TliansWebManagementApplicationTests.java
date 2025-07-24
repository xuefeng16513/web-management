package com.zidong.tlians_web_management;

import com.aliyun.oss.common.auth.HmacSHA256Signature;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliansWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    //测试JWT令牌的生成
    @Test
    public void JwtGenerator(){
        Map<String, Object> claims =  new HashMap<> ();
        claims.put ("id",1);
        claims.put ("name", "tom");
        String Jwt = Jwts.builder ().signWith (SignatureAlgorithm.HS256 ,
                        "itheimaitheimaitheimaitheimaitheimaitheimaitheima" +
                                "itheimaitheimaitheimaitheimaitheimaitheimaitheima")//签名算法
                .setClaims (claims)//自定义载荷部分
                .setExpiration (new Date (System.currentTimeMillis () + 3600000))//设置JWT令牌的有效期
                .compact ();
        System.out.println (Jwt);
    }

    @Test
    public void JwtParser(){
        Claims claims = Jwts.parser ().setSigningKey ("itheimaitheimaitheimaitheimaitheimaitheimaitheima"  +
                                                "itheimaitheimaitheimaitheimaitheimaitheimaitheima")
                .build ().parseClaimsJws ("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTc1MTc2MDA1Nn0.AdbwdbOmIJpNAnLf81y-xaqcx9__lADAydy_7DaQB-c")
                .getBody ();
        System.out.println (claims);
    }

}
