package com.linewell.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/2/21 0021 13:47
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
@SpringBootApplication
@EnableResourceServer
public class OAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuthApplication.class, args);
    }
}
