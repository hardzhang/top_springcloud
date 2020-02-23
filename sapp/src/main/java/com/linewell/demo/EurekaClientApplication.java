package com.linewell.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/1/20 0020 14:22
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
@EnableDiscoveryClient// 启用 eureka client 相关默认配置，在 Edgware 以后的版本该注解可以省略
@SpringBootApplication
@EnableOAuth2Sso
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
