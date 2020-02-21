package com.linewell.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/1/20 0020 14:09
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OAuthServerApplication {

    public static void main(String[] args){
        SpringApplication.run(OAuthServerApplication.class, args);
    }
}
