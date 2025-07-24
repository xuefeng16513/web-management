package com.zidong.tlians_web_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//开启了对servlet组件支持
@SpringBootApplication
public class TliansWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliansWebManagementApplication.class, args);
    }

}
