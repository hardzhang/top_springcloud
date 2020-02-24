package com.linewell.demo.sapp.controller;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/1/20 0020 14:50
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * EurekaClientController
 *
 * 控制器
 *
 * @author 宋陆
 * @version 1.0.0
 */
@RestController
public class EurekaClientController {

    @Value("${server.port}")
    private String port;

    /**
     * 提供的一个restful服务，返回内容格式：服务协议://服务器地址:服务端口/服务uri
     *
     * @param request
     * @return
     */
    @RequestMapping("/info")
    public String info(HttpServletRequest request) {
        String message = request.getScheme() + "://bax" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
        return message;
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        String message = request.getScheme() + "://bax" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
        return message;
    }

    @RequestMapping("/login")
    public String callback(HttpServletRequest request) {
        String message = request.getScheme() + "://bax" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
        return message;
    }
}
