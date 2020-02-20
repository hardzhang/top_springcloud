package com.linewell.demo.sappmore.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/1/20 0020 15:17
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("访问来1了......");
        return "hello1";
    }

    @RequestMapping("/hjcs")
    public List<String> laowangs(String ids){
        List<String> list = new ArrayList<String>();
        list.add("laowang1");
        list.add("laowang2");
        list.add("laowang3");
        return list;
    }

    //新增的方法
    @RequestMapping(value = "/hellol", method= RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method= RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello (@RequestBody User user) {
        return "Hello "+ user. getName () + ", " + user. getAge ();
    }

}
