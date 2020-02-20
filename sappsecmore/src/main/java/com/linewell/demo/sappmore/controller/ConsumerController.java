package com.linewell.demo.sappmore.controller;

import com.linewell.demo.sappmore.inter.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/1/20 0020 15:28
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
@RestController
public class ConsumerController {

    @Autowired
    FeignService feignService;

    @RequestMapping("/consumer")
    public String helloConsumer(){
        return feignService.hello();
    }

}